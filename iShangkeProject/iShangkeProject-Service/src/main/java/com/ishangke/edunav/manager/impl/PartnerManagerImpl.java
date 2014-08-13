package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.common.utilities.IdChecker;
import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.PartnerEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.UserEntityExt;
import com.ishangke.edunav.dataaccess.model.gen.UserEntity;
import com.ishangke.edunav.manager.AddressManager;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.PartnerManager;
import com.ishangke.edunav.manager.converter.AddressConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.converter.UserConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.exception.authentication.AuthenticationException;
import com.ishangke.edunav.manager.exception.notfound.PartnerNotFoundException;

@Component
public class PartnerManagerImpl implements PartnerManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerManagerImpl.class);

    @Autowired
    private PartnerEntityExtMapper partnerMapper;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Autowired
    private AuthManager authManager;

    @Autowired
    private AddressManager addressManager;

    @Override
    // public data, does not check permission
    public List<PartnerBo> query(PartnerBo partnerBo, PaginationBo paginationBo, UserBo userBo) {
        if (userBo == null) {
            throw new ManagerException("无效请求参数");
        }
        PartnerEntityExt partnerEntity = partnerBo == null ? null : PartnerConverter.fromBo(partnerBo);
        PaginationEntity page = paginationBo == null ? null : PaginationConverter.fromBo(paginationBo);
        UserEntityExt userEntity = UserConverter.fromBo(userBo);

        List<PartnerEntityExt> results = null;
        try {
            results = partnerMapper.list(partnerEntity, page);
        } catch (Throwable t) {
            throw new ManagerException("对不起，合作机构查询失败，请稍后再试", t);
        }

        if (results == null) {
            return new ArrayList<PartnerBo>();
        }
        List<PartnerBo> convertedResults = new ArrayList<PartnerBo>();
        for (PartnerEntityExt result : results) {
            convertedResults.add(PartnerConverter.toBo(result));
        }
        return convertedResults;
    }

    @Override
    // public data, does not check permission
    public PartnerBo queryById(PartnerBo partnerBo, UserBo userBo) {
        if (partnerBo == null) {
            throw new ManagerException("无效请求参数");
        }
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        PartnerEntityExt result = null;
        try {
            result = partnerMapper.getInfoById(partnerEntity.getId());
        } catch (Throwable t) {
            throw new ManagerException("对不起，合作机构查询失败，请稍后再试", t);
        }

        if (result == null) {
            throw new PartnerNotFoundException("对不起，无法找到ID为" + partnerEntity.getId() + "的合作机构");
        }
        return PartnerConverter.toBo(result);
    }

    @Override
    public PartnerBo updatePartner(PartnerBo partnerBo, UserBo userBo) {
        if (partnerBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 更新partner记录
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        if (IdChecker.isNull(partnerEntity.getId())) {
            throw new ManagerException("更新合作机构时必须标注合作机构ID");
        }
        PartnerEntityExt previousPartner = partnerMapper.getById(partnerEntity.getId());
        if (previousPartner == null) {
            throw new PartnerNotFoundException("对不起，无法找到ID为" + partnerEntity.getId() + "的合作机构");
        }

        // 验证用户是否属于此partner
        List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null || groupList.size() == 0) {
            throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
        }
        boolean isSameGroup = false;
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            isSameGroup = true;
            LOGGER.warn(String.format("[PartnerManagerImpl]system admin || admin[%s] call updatePartner at " + new Date(), userBo.getName()));
        } else {
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), previousPartner.getId())) {
                    isSameGroup = true;
                    break;
                }
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("对不起，您无权执行该请求");
        }

        partnerEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        partnerEntity.setCreateTime(null);
        partnerEntity.setDeleted(null);
        try {
            partnerMapper.update(partnerEntity);
        } catch (Throwable t) {
            throw new ManagerException("对不起，合作机构更新失败，请稍后再试", t);
        }

        return PartnerConverter.toBo(partnerMapper.getById(partnerEntity.getId()));
    }

    @Override
    public PartnerBo createPartner(PartnerBo partnerBo, UserBo userBo) {
        if (partnerBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        // 验证用户是否为admin
        if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
            LOGGER.warn(String.format("[PartnerManagerImpl]system admin || admin [%s] call createPartner at " + new Date(), userBo.getName()));
        } else {
            throw new AuthenticationException("对不起，您无权创建合作机构");
        }

        // 插入新的partner记录
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        UserEntity userEntity = UserConverter.fromBo(userBo);

        int result = 0;
        partnerEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        partnerEntity.setCreateTime(DateUtility.getCurTimeInstance());
        partnerEntity.setEnabled(0);
        partnerEntity.setDeleted(0);
        try {
            result = partnerMapper.add(partnerEntity);
            if (result <= 0) {
                throw new ManagerException("对不起，合作机构创建失败，请稍后再试");
            }
            // 判断不为空
            if (partnerEntity.getAddressList() != null) {
                for (int i = 0; i < partnerEntity.getAddressList().size(); i++) {
                    AddressBo toStore = AddressConverter.toBo(partnerEntity.getAddressList().get(i));
                    AddressBo stored = addressManager.createAddress(toStore, userBo);
                    // store the one with the id
                    partnerEntity.getAddressList().set(i, AddressConverter.fromBo(stored));
                }
            }

        } catch (Throwable t) {
            LOGGER.warn(t.getMessage(), t);
            if (t instanceof ManagerException) {
                throw t;
            }
            throw new ManagerException("对不起，合作机构创建失败，请稍后再试", t);
        }
        // 创建关于此partner的两个group 分别对应 partner admin 和 partner wenyuan
        GroupEntityExt group = new GroupEntityExt();
        group.setPartnerId(partnerEntity.getId());
        group.setCreateTime(DateUtility.getCurTimeInstance());
        group.setLastModifyTime(DateUtility.getCurTimeInstance());
        //插两种不同的group
        group.setName((partnerEntity.getInstName() != null ? partnerEntity.getInstName() : "") + Constant.ROLEPARTNERADMIN);
        group.setRoleId(Constant.ROLEPARTNERADMINID);
        int i = 0;
        i = groupMapper.add(group);
        if (i <= 0) {
            throw new ManagerException("对不起, 为ID为" + partnerEntity.getId() + "的合作机构创建管理员用户组失败, 请稍后再试");
        }
        group.setName((partnerEntity.getInstName() != null ? partnerEntity.getInstName() : "") + Constant.ROLEPARTNERWENYUAN);
        group.setRoleId(Constant.ROLEPARTNERWENYUANID);
        int j = 0;
        j = groupMapper.add(group);
        if (j <= 0) {
            throw new ManagerException("对不起, 为ID为" + partnerEntity.getId() + "的合作机构创建文员用户组失败, 请稍后再试");
        }
        return PartnerConverter.toBo(partnerMapper.getById(partnerEntity.getId()));
    }

    @Override
    public int queryTotal(PartnerBo partnerBo, UserBo userBo) {
        return partnerMapper.getListCount(PartnerConverter.fromBo(partnerBo));
    }

}
