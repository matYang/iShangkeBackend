package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.ClassPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.TeacherEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.PartnerEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CourseTemplateManager;
import com.ishangke.edunav.manager.TransformManager;
import com.ishangke.edunav.manager.converter.CourseTemplateConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.converter.PartnerConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.transform.Operation;

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

    @Autowired
    private ClassPhotoEntityExtMapper photoMapper;

    @Autowired
    private TeacherEntityExtMapper teacherMapper;

    @Autowired
    private TransformManager transformManager;

    @Autowired
    private GroupEntityExtMapper groupMapper;

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

        String roleName = authManager.getRole(userBo.getId());
        if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            // 如果是合作商管理员
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
                throw new ManagerException("cannot create other partner's template");
            }
            // 验证教师信息和classphoto信息是否属于本机构
            List<ClassPhotoBo> classPhotos = courseTemplateBo.getClassPhotoList();
            if (classPhotos != null) {
                for (ClassPhotoBo photo : classPhotos) {
                    ClassPhotoEntityExt photoEntity = null;
                    try {
                        photoEntity = photoMapper.getById(photo.getId());
                    } catch (Exception e) {
                        throw new ManagerException("failed when query photo in partner repository");
                    }
                    if (photoEntity == null || photoEntity.getPartnerId() != partnerBo.getId()) {
                        throw new ManagerException("classphoto cannot found in partner photo repository");
                    }
                }
            }
            List<TeacherBo> teachers = courseTemplateBo.getTeacherList();
            if (teachers != null) {
                for (TeacherBo teacher : teachers) {
                    TeacherEntityExt teacherEntity = null;
                    try {
                        teacherEntity = teacherMapper.getById(teacher.getId());
                    } catch (Exception e) {
                        throw new ManagerException("failed when query teacher in partner repository");
                    }
                    if (teacherEntity == null || teacherEntity.getPartnerId() != partnerBo.getId()) {
                        throw new ManagerException("teacher cannot found in partner teacher repository");
                    }
                }
            }
            // Convert
            CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
            try {
                // 强制使用传递过来的partnerId
                courseTemplateEntity.setPartnerId(partnerBo.getId());
                // 刚刚创建出来的course template状态属于待审核状态
                courseTemplateEntity.setStatus(Constant.COURSESTATUSPENDINGREVIEW);
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

        } else if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName)) {
            // 如果是ishangke管理员

            // 验证教师信息和classphoto信息是否属于同一家机构
            // 即使不属于同一家机构，但是ishangke管理员也可以强行提交，日志系统会发出警报
            List<ClassPhotoBo> classPhotos = courseTemplateBo.getClassPhotoList();
            if (classPhotos != null) {
                for (ClassPhotoBo photo : classPhotos) {
                    ClassPhotoEntityExt photoEntity = null;
                    try {
                        photoEntity = photoMapper.getById(photo.getId());
                    } catch (Exception e) {
                        throw new ManagerException("failed when query photo");
                    }
                    if (photoEntity == null) {
                        LOGGER.warn(String.format("[create course template] ishangke admin [%d] try to use illegal photo, photo [%d] cannot found", userBo.getId(), photoEntity == null ? null : photoEntity.getId()));
                    }
                    if (photoEntity.getPartnerId() != partnerBo.getId()) {
                        LOGGER.warn(String.format("[create course template] ishangke admin [%d] try to use illegal photo, photo [%d] belong [%d]", userBo.getId(), photoEntity.getId(),
                                photo.getPartnerId()));
                    }
                }
            }
            List<TeacherBo> teachers = courseTemplateBo.getTeacherList();
            if (teachers != null) {
                for (TeacherBo teacher : teachers) {
                    TeacherEntityExt teacherEntity = null;
                    try {
                        teacherEntity = teacherMapper.getById(teacher.getId());
                    } catch (Exception e) {
                        throw new ManagerException("failed when query teacher");
                    }
                    if (teacherEntity == null) {
                        LOGGER.warn(String.format("[create course template] ishangke admin [%d] try to use illegal teacher, teacher [%d] cannot found", userBo.getId(), teacherEntity == null ? null : teacherEntity.getId()));
                    }
                    if (teacherEntity.getPartnerId() != partnerBo.getId()) {
                        LOGGER.warn(String.format("[create course template] ishangke admin [%d] try to use illegal teacher, teacher [%d] belong [%d]", userBo.getId(), teacherEntity.getId(),
                                teacherEntity.getPartnerId()));
                    }
                }
            }
            CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
            try {
                // 强制使用传递过来的partnerId
                courseTemplateEntity.setPartnerId(partnerBo.getId());
                // admin创建出来的course template 默认为已上线状态
                courseTemplateEntity.setStatus(Constant.COURSESTATUSONLINED);
                int result = 0;
                result = courseTemplateMapper.add(courseTemplateEntity);
                if (result > 0) {
                    LOGGER.warn(String.format("[create course template] ishangke admin or system admin [%d] crate course template for partner [%d], course template id is [%d]", userBo.getId(),
                            partnerBo.getId(), result));
                    return CourseTemplateConverter.toBo(courseTemplateEntity);
                } else {
                    throw new ManagerException("CourseTemplate Create Failed");
                }
            } catch (Throwable t) {
                throw new ManagerException("CourseTemplate Create Failed", t);
            }

        } else {
            // 如果是别的角色的用户，则不能创建课程模版
            throw new ManagerException("cannot create coursetemplate current role");
        }
    }

    /**
     * 用于修改couse template的内容 仅供内部使用，不对外提供接口 只有当进行提交修改这个状态转移的时候，才可以使用此方法
     * 
     * @param courseTemplateBo
     * @param oldCourseTemplateBo
     * @return
     */
    public CourseTemplateBo updateCourseTemplate(CourseTemplateBo courseTemplateBo, CourseTemplateBo oldCourseTemplateBo) {

        // try {
        // courseTemplateMapper.update(courseTemplateEntity);
        // return CourseTemplateConverter.toBo(courseTemplateEntity);
        // } catch (Throwable t) {
        // throw new ManagerException("CourseTemplate Update Failed", t);
        // }
        return null;
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
        List<CourseTemplateBo> resultList = new ArrayList<CourseTemplateBo>();

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
        // List<GroupEntityExt> groupList =
        // groupEntityExtMapper.listGroupsByUserId(userBo.getId());
        // if (groupList == null) {
        // throw new ManagerException("unlogin user");
        // }
        // boolean isSameGroup = false;
        // for (GroupEntityExt g : groupList) {
        // if (g.getPartnerId() == partnerBo.getId()) {
        // isSameGroup = true;
        // break;
        // }
        // }
        // if (isSameGroup == false) {
        // throw new ManagerException("Invalid user");
        // }

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

    @Override
    public CourseTemplateBo transformCourseTmeplateStatus(CourseTemplateBo courseTemplateBo, int operation, UserBo userBo) {
        CourseTemplateEntityExt courseTemplate = courseTemplateMapper.getById(courseTemplateBo.getId());
        if (courseTemplate == null) {
            throw new ManagerException("course template is not exits");
        }
        String roleName = authManager.getRole(userBo.getId());
        List<Operation> operationList = transformManager.getOperationByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, courseTemplate.getStatus());
        Operation op = null;
        for (Operation o : operationList) {
            if (o.getOperateCode() == operation) {
                op = o;
            }
        }
        if (Constant.ROLEUSER.equals(roleName)) {
            throw new ManagerException("user cannot transform course template status");
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName)) {
            List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("unlogin user");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (g.getPartnerId().equals(courseTemplate.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (!isSameGroup) {
                throw new ManagerException("cannot modify other's course template");
            }
            // 按照业务流程修改courseTemplate
            if (op == null) {
                throw new ManagerException("cannot modify current course template status");
            }
            courseTemplate.setLastModifyTime(DateUtility.getCurTimeInstance());
            courseTemplate.setStatus(op.getNextStatus());
            courseTemplateMapper.update(courseTemplate);
            // 插入可以进行的下一步操作
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, op.getNextStatus());
            CourseTemplateBo result = CourseTemplateConverter.toBo(courseTemplateMapper.getById(courseTemplateBo.getId()));
            result.setActionList(actions);
            return result;
        } else if (Constant.ROLEADMIN.equals(roleName)) {
            if (op == null) {
                throw new ManagerException("cannot modify current course tempalte status");
            }
            if (op.getOperateCode() == Constant.COURSEOPERATIONSUBMITUPDATED) {
                return this.updateCourseTemplate(courseTemplateBo, CourseTemplateConverter.toBo(courseTemplate));
            }
            courseTemplate.setStatus(op.getNextStatus());
            courseTemplateMapper.update(courseTemplate);
            // 插入可以运行的下一步操作
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, op.getNextStatus());
            CourseTemplateBo result = CourseTemplateConverter.toBo(courseTemplateMapper.getById(courseTemplateBo.getId()));
            result.setActionList(actions);
            return result;
        } else if (Constant.ROLESYSTEMADMIN.equals(roleName)) {

        }
        return null;
    }

}
