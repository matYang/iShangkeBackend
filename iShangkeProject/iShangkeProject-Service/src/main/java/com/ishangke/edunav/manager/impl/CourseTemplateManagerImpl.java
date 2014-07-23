package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateApproveBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateRejectBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CourseTemplateManager;
import com.ishangke.edunav.manager.converter.CourseTemplateConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.exception.ManagerException;


//todo
//关于权限的控制，状态的转移，需要再考虑一下
@Component
public class CourseTemplateManagerImpl implements CourseTemplateManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseTemplateManagerImpl.class);

    @Autowired
    private CourseTemplateEntityExtMapper courseTemplateMapper;

    @Autowired
    private GroupEntityExtMapper groupEntityExtMapper;
    
    @Autowired
    private AuthManager authManager;

    @Override
    public CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Create Failed: CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("CourseTemplate Create Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Create Failed: UserBo is null");
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerBo.getId()) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // to do状态改变

        try {
            courseTemplateEntity.setPartnerId(partnerEntity.getId());
            int result = 0;
            result = courseTemplateMapper.add(courseTemplateEntity);
            if (result > 0) {
                return CourseTemplateConverter.toBo(courseTemplateEntity);
            } else {
                throw new ManagerException("CourseTemplate Create Failed");
            }
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Create Failed", t);
        }
    }

    @Override
    public CourseTemplateBo submitCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Submit Failed: CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("CourseTemplate Submit Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Submit Failed: UserBo is null");
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerBo.getId()) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseTemplateEntity.getPartnerId() == null || courseTemplateEntity.getPartnerId() == 0) {
            throw new ManagerException("CourseTemplate Submit Failed: 课程template的partnerId为null或0");
        }

        // Check whether the courseTemplate belongs to the partner
        if (courseTemplateEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("CourseTemplate Submit Failed: 该课程tempalte不属于此合作商");
        }

        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Submit Failed", t);
        }
    }

    @Override
    public CourseTemplateBo approveCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, CommentCourseTemplateApproveBo commentCourseTemplateApproveBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Approve Failed: CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("CourseTemplate Approve Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Approve Failed: UserBo is null");
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerBo.getId()) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseTemplateEntity.getPartnerId() == null || courseTemplateEntity.getPartnerId() == 0) {
            throw new ManagerException("CourseTemplate Approve Failed: 课程template的partnerId为null或0");
        }

        // Check whether the courseTemplate belongs to the partner
        if (courseTemplateEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("CourseTemplate Approve Failed: 该课程tempalte不属于此合作商");
        }

        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Approve Failed", t);
        }
    }

    @Override
    public CourseTemplateBo rejectCourseTemplate(CourseTemplateBo courseTemplateBo, CommentCourseTemplateRejectBo commentCourseTemplateRejectBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Reject Failed: CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("CourseTemplate Reject Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Reject Failed: UserBo is null");
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerBo.getId()) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseTemplateEntity.getPartnerId() == null || courseTemplateEntity.getPartnerId() == 0) {
            throw new ManagerException("CourseTemplate Reject Failed: 课程template的partnerId为null或0");
        }

        // Check whether the courseTemplate belongs to the partner
        if (courseTemplateEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("CourseTemplate Reject Failed: 该课程tempalte不属于此合作商");
        }

        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Reject Failed", t);
        }
    }

    @Override
    public CourseTemplateBo cancelCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Cancel Failed: CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("CourseTemplate Cancel Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Cancel Failed: UserBo is null");
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerBo.getId()) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseTemplateEntity.getPartnerId() == null || courseTemplateEntity.getPartnerId() == 0) {
            throw new ManagerException("CourseTemplate Cancel Failed: 课程template的partnerId为null或0");
        }

        // Check whether the courseTemplate belongs to the partner
        if (courseTemplateEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("CourseTemplate Cancel Failed: 该课程tempalte不属于此合作商");
        }

        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Cancel Failed", t);
        }
    }

    @Override
    public CourseTemplateBo resubmitCourserTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Resubmit Failed: CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("CourseTemplate Resubmit Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Resubmit Failed: UserBo is null");
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerBo.getId()) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseTemplateEntity.getPartnerId() == null || courseTemplateEntity.getPartnerId() == 0) {
            throw new ManagerException("CourseTemplate Resubmit Failed: 课程template的partnerId为null或0");
        }

        // Check whether the courseTemplate belongs to the partner
        if (courseTemplateEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("CourseTemplate Resubmit Failed: 该课程tempalte不属于此合作商");
        }

        try {
            // Change status
            int status = 0;
            courseTemplateEntity.setStatus(status);
            courseTemplateMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Resubmit Failed", t);
        }
    }

    @Override
    public CourseTemplateBo deleteCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Delete Failed: CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("CourseTemplate Delete Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Delete Failed: UserBo is null");
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerBo.getId()) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseTemplateEntity.getPartnerId() == null || courseTemplateEntity.getPartnerId() == 0) {
            throw new ManagerException("CourseTemplate Delete Failed: 课程template的partnerId为null或0");
        }

        // Check whether the courseTemplate belongs to the partner
        if (courseTemplateEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("CourseTemplate Delete Failed: 该课程tempalte不属于此合作商");
        }

        try {
            courseTemplateMapper.deleteById(courseTemplateEntity.getId());
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Delete Failed", t);
        }
    }

    @Override
    public CourseTemplateBo updateCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Update Failed: CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("CourseTemplate Update Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Update Failed: UserBo is null");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);

        // Check Ids
        if (courseTemplateEntity.getPartnerId() == null || courseTemplateEntity.getPartnerId() == 0) {
            throw new ManagerException("CourseTemplate Update Failed: 课程template的partnerId为null或0");
        }

        // Check whether the courseTemplate belongs to the partner
        if (courseTemplateEntity.getPartnerId() != partnerEntity.getId()) {
            throw new ManagerException("CourseTemplate Update Failed: 该课程tempalte不属于此合作商");
        }

        try {
            courseTemplateMapper.update(courseTemplateEntity);
            return CourseTemplateConverter.toBo(courseTemplateEntity);
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Update Failed", t);
        }
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, PartnerBo partnerBo, PaginationBo paginationBo) {
        PaginationEntity pageEntity = null;

        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Query Failed: CourseTemplateBo is null");
        }
        if (partnerBo == null) {
            throw new ManagerException("CourseTemplate Query Failed: PartnerBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Query Failed: UserBo is null");
        }
        if (paginationBo != null) {
            pageEntity = PaginationConverter.fromBo(paginationBo);
        }

        // 验证userBo是否是否属于同一家机构
        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        if (groupList == null) {
            throw new ManagerException("unlogin user");
        }
        boolean isSameGroup = false;
        for (GroupEntityExt g : groupList) {
            if (g.getPartnerId() == partnerBo.getId()) {
                isSameGroup = true;
                break;
            }
        }
        if (isSameGroup == false) {
            throw new ManagerException("Invalid user");
        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        PartnerEntityExt partnerEntity = PartnerConverter.fromBo(partnerBo);
        List<CourseTemplateEntityExt> courseTemplateList = null;
        List<CourseTemplateBo> resultList = null;

        try {
            courseTemplateList = courseTemplateMapper.list(courseTemplateEntity, pageEntity);
            for (CourseTemplateEntityExt courseTemplatePo : courseTemplateList) {
                if (courseTemplatePo.getPartnerId() != partnerEntity.getId()) {
                    throw new ManagerException("CourseTemplate Query Failed: 该课程tempalte不属于此合作商");
                }
                resultList.add(CourseTemplateConverter.toBo(courseTemplatePo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate Query Failed", t);
        }
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate QueryById Failed: CourseTemplateBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate QueryById Failed: UserBo is null");
        }

        // 验证userBo是否是否属于同一家机构
//        List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
//        if (groupList == null) {
//            throw new ManagerException("unlogin user");
//        }
//        boolean isSameGroup = false;
//        for (GroupEntityExt g : groupList) {
//            if (g.getPartnerId() == partnerBo.getId()) {
//                isSameGroup = true;
//                break;
//            }
//        }
//        if (isSameGroup == false) {
//            throw new ManagerException("Invalid user");
//        }

        // Convert
        CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
        List<CourseTemplateEntityExt> courseTemplateList = null;
        List<CourseTemplateBo> resultList = null;

        try {
            courseTemplateList = courseTemplateMapper.list(courseTemplateEntity, null);
            for (CourseTemplateEntityExt courseTemplatePo : courseTemplateList) {
                resultList.add(CourseTemplateConverter.toBo(courseTemplatePo));
            }
            return resultList;
        } catch (Throwable t) {
            throw new ManagerException("CourseTemplate QueryById Failed", t);
        }
    }

}
