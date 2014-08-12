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
import com.ishangke.edunav.commoncontract.model.ActionBo;
import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.ClassPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateClassPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateTeacherEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.TeacherEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateTeacherEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CourseTemplateManager;
import com.ishangke.edunav.manager.TransformManager;
import com.ishangke.edunav.manager.converter.CourseTemplateConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.transform.Operation;

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

    @Autowired
    private CourseTemplateTeacherEntityExtMapper courseTemplateTeacherMapper;

    @Autowired
    private CourseTemplateClassPhotoEntityExtMapper courseTemplatePhotoMapper;

    @Override
    public CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo) {
        // Check Null
        if (courseTemplateBo == null) {
            throw new ManagerException("CourseTemplate Create Failed: CourseTemplateBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("CourseTemplate Create Failed: UserBo is null");
        }
        // 获取当前用户橘色
        String roleName = authManager.getRole(userBo.getId());
        if (Constant.ROLEPARTNERADMIN.equals(roleName) || Constant.ROLEPARTNERWENYUAN.equals(roleName)) {
            // 如果是合作商管理员
            // 验证userBo是否是否属于同一家机构
            List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("unlogin user");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), courseTemplateBo.getPartnerId())) {
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
                    if (photoEntity == null || IdChecker.notEqual(photoEntity.getPartnerId(), courseTemplateBo.getPartnerId())) {
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
                    if (teacherEntity == null || IdChecker.notEqual(teacherEntity.getPartnerId(), courseTemplateBo.getPartnerId())) {
                        throw new ManagerException("teacher cannot found in partner teacher repository");
                    }
                }
            }
            // Convert
            CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
            try {
                // 刚刚创建出来的course template状态属于待审核状态
                courseTemplateEntity.setStatus(Constant.COURSESTATUSPENDINGREVIEW);
                // 修改创建时间
                courseTemplateEntity.setCreateTime(DateUtility.getCurTimeInstance());
                // 修来lastmodifytime
                courseTemplateEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
                int result = 0;
                result = courseTemplateMapper.add(courseTemplateEntity);
                if (result > 0) {
                    // 插入classphoto关联
                    if (classPhotos != null) {
                        for (ClassPhotoBo photo : classPhotos) {
                            try {
                                CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
                                courseTemplateClassPhotoEntityExt.setClassPhotoId(photo.getId());
                                courseTemplateClassPhotoEntityExt.setCourseTemplateId(courseTemplateEntity.getId());
                                courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                                courseTemplatePhotoMapper.add(courseTemplateClassPhotoEntityExt);
                            } catch (Exception e) {
                                throw new ManagerException("failed when add photo course template relationship");
                            }
                        }
                    }
                    // 插入teacher关联
                    if (teachers != null) {
                        for (TeacherBo teacher : teachers) {
                            try {
                                CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
                                courseTemplateTeacherEntityExt.setTeacherId(teacher.getId());
                                courseTemplateTeacherEntityExt.setCourseTemplateId(courseTemplateEntity.getId());
                                courseTemplateTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                                courseTemplateTeacherMapper.add(courseTemplateTeacherEntityExt);
                            } catch (Exception e) {
                                throw new ManagerException("failed when add teacher course tempalte relationship");
                            }
                        }
                    }
                    List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, courseTemplateEntity.getStatus());
                    CourseTemplateBo courseTemplate = CourseTemplateConverter.toBo(courseTemplateMapper.getById(courseTemplateEntity.getId()));
                    courseTemplate.setActionList(actions);

                    return courseTemplate;
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
                        LOGGER.warn(String.format("[create course template] ishangke admin [%d] try to use illegal photo, photo [%d] cannot found", userBo.getId(), photoEntity == null ? null
                                : photoEntity.getId()));
                    }
                    if (IdChecker.notEqual(photoEntity.getPartnerId(), courseTemplateBo.getPartnerId())) {
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
                        LOGGER.warn(String.format("[create course template] ishangke admin [%d] try to use illegal teacher, teacher [%d] cannot found", userBo.getId(), teacherEntity == null ? null
                                : teacherEntity.getId()));
                    }
                    if (IdChecker.notEqual(teacherEntity.getPartnerId(), courseTemplateBo.getPartnerId())) {
                        LOGGER.warn(String.format("[create course template] ishangke admin [%d] try to use illegal teacher, teacher [%d] belong [%d]", userBo.getId(), teacherEntity.getId(),
                                teacherEntity.getPartnerId()));
                    }
                }
            }
            CourseTemplateEntityExt courseTemplateEntity = CourseTemplateConverter.fromBo(courseTemplateBo);
            try {
                // admin创建出来的course template 默认为已上线状态
                courseTemplateEntity.setStatus(Constant.COURSESTATUSONLINED);
                int result = 0;
                result = courseTemplateMapper.add(courseTemplateEntity);
                if (result > 0) {
                    LOGGER.warn(String.format("[create course template] ishangke admin or system admin [%d] crate course template for partner [%d], course template id is [%d]", userBo.getId(),
                            courseTemplateBo.getPartnerId(), courseTemplateEntity.getId()));

                    List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, courseTemplateEntity.getStatus());
                    CourseTemplateBo courseTemplate = CourseTemplateConverter.toBo(courseTemplateMapper.getById(courseTemplateEntity.getId()));
                    courseTemplate.setActionList(actions);

                    return courseTemplate;
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
    public CourseTemplateBo updateCourseTemplate(CourseTemplateEntityExt courseTemplateEntityModify, CourseTemplateEntityExt oldCourseTemplateEntity, boolean isOnlineNow) {
        if (!isOnlineNow) {
            if ((courseTemplateEntityModify.getPrice() != null && !courseTemplateEntityModify.getPrice().equals(oldCourseTemplateEntity.getPrice()))
                    || (courseTemplateEntityModify.getCourseName() != null && !courseTemplateEntityModify.getCourseName().equals(oldCourseTemplateEntity.getCourseName()))
                    || (courseTemplateEntityModify.getOriginalPrice() != null && !courseTemplateEntityModify.getOriginalPrice().equals(oldCourseTemplateEntity.getOriginalPrice()))) {
                throw new ManagerException("cannot modify price , name , origin price");
            }
            List<ClassPhotoEntityExt> classPhotos = null;
            List<TeacherEntityExt> teachers = null;
            // 验证教师信息和classphoto信息是否属于本机构
            if (courseTemplateEntityModify.getClassPhotoList() != null) {
                classPhotos = courseTemplateEntityModify.getClassPhotoList();
                if (classPhotos != null) {
                    for (ClassPhotoEntityExt photo : classPhotos) {
                        ClassPhotoEntityExt photoEntity = null;
                        try {
                            photoEntity = photoMapper.getById(photo.getId());
                        } catch (Exception e) {
                            throw new ManagerException("failed when query photo in partner repository");
                        }
                        if (photoEntity == null || IdChecker.notEqual(photoEntity.getPartnerId(), oldCourseTemplateEntity.getPartnerId())) {
                            throw new ManagerException("classphoto cannot found in partner photo repository");
                        }
                    }
                }
            }

            if (courseTemplateEntityModify.getTeacherList() != null) {
                teachers = courseTemplateEntityModify.getTeacherList();
                if (teachers != null) {
                    for (TeacherEntityExt teacher : teachers) {
                        TeacherEntityExt teacherEntity = null;
                        try {
                            teacherEntity = teacherMapper.getById(teacher.getId());
                        } catch (Exception e) {
                            throw new ManagerException("failed when query teacher in partner repository");
                        }
                        if (teacherEntity == null || IdChecker.notEqual(teacherEntity.getPartnerId(), oldCourseTemplateEntity.getPartnerId())) {
                            throw new ManagerException("teacher cannot found in partner teacher repository");
                        }
                    }
                }
            }
            // 删除原有的教师信息/classphoto与classtemplate的关联
            List<TeacherEntityExt> oldTeachers = teacherMapper.listTeacherByCourseId(courseTemplateEntityModify.getId());
            if (oldTeachers != null && oldTeachers.size() != 0) {
                for (TeacherEntityExt t : oldTeachers) {
                    courseTemplateTeacherMapper.deleteByCourseTemplateIdTeacherId(courseTemplateEntityModify.getId(), t.getId());
                }
            }
            List<ClassPhotoEntityExt> oldPhotos = photoMapper.listClassPhotoByCourseTempleteId(courseTemplateEntityModify.getId());
            if (oldPhotos != null && oldPhotos.size() != 0) {
                for (ClassPhotoEntityExt p : oldPhotos) {
                    courseTemplatePhotoMapper.deleteByCourseTemplateIdClassPhotoId(courseTemplateEntityModify.getId(), p.getId());
                }
            }
            // 建立新的教师信息/classphoto与classtemplate的关联
            // 插入classphoto关联
            if (classPhotos != null) {
                for (ClassPhotoEntityExt photo : classPhotos) {
                    try {
                        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
                        courseTemplateClassPhotoEntityExt.setClassPhotoId(photo.getId());
                        courseTemplateClassPhotoEntityExt.setCourseTemplateId(courseTemplateEntityModify.getId());
                        courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                        courseTemplatePhotoMapper.add(courseTemplateClassPhotoEntityExt);
                    } catch (Exception e) {
                        throw new ManagerException("failed when add photo course template relationship");
                    }
                }
            }
            // 插入teacher关联
            if (teachers != null) {
                for (TeacherEntityExt teacher : teachers) {
                    try {
                        CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
                        courseTemplateTeacherEntityExt.setTeacherId(teacher.getId());
                        courseTemplateTeacherEntityExt.setCourseTemplateId(courseTemplateEntityModify.getId());
                        courseTemplateTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                        courseTemplateTeacherMapper.add(courseTemplateTeacherEntityExt);
                    } catch (Exception e) {
                        throw new ManagerException("failed when add teacher course tempalte relationship");
                    }
                }
            }
            // 不能修改partner id
            courseTemplateEntityModify.setPartnerId(oldCourseTemplateEntity.getPartnerId());
            // 状态设置为待审核
            courseTemplateEntityModify.setStatus(Constant.COURSESTATUSPENDINGREVIEW);
            // 修改lastmodifytime
            courseTemplateEntityModify.setLastModifyTime(DateUtility.getCurTimeInstance());
            courseTemplateMapper.update(courseTemplateEntityModify);

        } else {
            List<ClassPhotoEntityExt> classPhotos = courseTemplateEntityModify.getClassPhotoList();
            List<TeacherEntityExt> teachers = courseTemplateEntityModify.getTeacherList();
            // 删除原有的教师信息/classphoto与classtemplate的关联
            List<TeacherEntityExt> oldTeachers = teacherMapper.listTeacherByCourseTempleteId(courseTemplateEntityModify.getId());
            if (oldTeachers != null && oldTeachers.size() != 0) {
                for (TeacherEntityExt t : oldTeachers) {
                    courseTemplateTeacherMapper.deleteByCourseTemplateIdTeacherId(courseTemplateEntityModify.getId(), t.getId());
                }
            }
            List<ClassPhotoEntityExt> oldPhotos = photoMapper.listClassPhotoByCourseTempleteId(courseTemplateEntityModify.getId());
            if (oldPhotos != null && oldPhotos.size() != 0) {
                for (ClassPhotoEntityExt p : oldPhotos) {
                    courseTemplatePhotoMapper.deleteByCourseTemplateIdClassPhotoId(courseTemplateEntityModify.getId(), p.getId());
                }
            }
            // 建立新的教师信息/classphoto与classtemplate的关联
            // 插入classphoto关联
            if (classPhotos != null) {
                for (ClassPhotoEntityExt photo : classPhotos) {
                    try {
                        CourseTemplateClassPhotoEntityExt courseTemplateClassPhotoEntityExt = new CourseTemplateClassPhotoEntityExt();
                        courseTemplateClassPhotoEntityExt.setClassPhotoId(photo.getId());
                        courseTemplateClassPhotoEntityExt.setCourseTemplateId(courseTemplateEntityModify.getId());
                        courseTemplateClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                        courseTemplatePhotoMapper.add(courseTemplateClassPhotoEntityExt);
                    } catch (Exception e) {
                        throw new ManagerException("failed when add photo course template relationship");
                    }
                }
            }
            // 插入teacher关联
            if (teachers != null) {
                for (TeacherEntityExt teacher : teachers) {
                    try {
                        CourseTemplateTeacherEntityExt courseTemplateTeacherEntityExt = new CourseTemplateTeacherEntityExt();
                        courseTemplateTeacherEntityExt.setTeacherId(teacher.getId());
                        courseTemplateTeacherEntityExt.setCourseTemplateId(courseTemplateEntityModify.getId());
                        courseTemplateTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                        courseTemplateTeacherMapper.add(courseTemplateTeacherEntityExt);
                    } catch (Exception e) {
                        throw new ManagerException("failed when add teacher course tempalte relationship");
                    }
                }
            }
            // 不能修改partner
            courseTemplateEntityModify.setPartnerId(oldCourseTemplateEntity.getPartnerId());
            // 修改lastmodifytime
            courseTemplateEntityModify.setLastModifyTime(DateUtility.getCurTimeInstance());
            // 状态直接设置为已上线
            courseTemplateEntityModify.setStatus(Constant.COURSESTATUSONLINED);
            courseTemplateMapper.update(courseTemplateEntityModify);
        }
        return CourseTemplateConverter.toBo(courseTemplateMapper.getById(courseTemplateEntityModify.getId()));
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
        if (operationList != null) {
            for (Operation o : operationList) {
                if (o.getOperateCode() == operation) {
                    op = o;
                }
            }
        }
        if (Constant.ROLEUSER.equals(roleName)) {
            throw new ManagerException("user cannot transform course template status");
        } else if (Constant.ROLEPARTNERADMIN.equals(roleName) || Constant.ROLEPARTNERWENYUAN.equals(roleName)) {
            List<GroupEntityExt> groupList = groupMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("unlogin user");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), courseTemplate.getPartnerId())) {
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
            // 如果是更新操作转，调用update方法
            if (op.getOperateCode() == Constant.COURSEOPERATIONSUBMITUPDATED) {
                CourseTemplateEntityExt courseTemplateModify = CourseTemplateConverter.fromBo(courseTemplateBo);
                // 不会被立刻上线
                CourseTemplateBo result = this.updateCourseTemplate(courseTemplateModify, courseTemplate, false);
                List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, op.getNextStatus());
                result.setActionList(actions);
                return result;
            }
            // 如果是删除操作
            if (op.getOperateCode() == Constant.COURSEOPERATIONDELETE) {
                LOGGER.warn(String.format("[transform course template status] partner admin [%d] is deleteing course template [%d]", userBo.getId(), courseTemplate.getId()));
                courseTemplate.setStatus(Constant.COURSESTATUSOFFLINED);
                try {
                    courseTemplateMapper.deleteById(courseTemplate.getId());
                    return new CourseTemplateBo();
                } catch (Exception e) {
                    throw new ManagerException("delete failed");
                }
            }
            // 修改lastmodifytime
            courseTemplate.setLastModifyTime(DateUtility.getCurTimeInstance());
            courseTemplate.setStatus(op.getNextStatus());
            courseTemplateMapper.update(courseTemplate);
            // 插入可以进行的下一步操作
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, op.getNextStatus());
            CourseTemplateBo result = CourseTemplateConverter.toBo(courseTemplateMapper.getById(courseTemplateBo.getId()));
            result.setActionList(actions);
            return result;
        } else if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName)) {
            if (op == null) {
                throw new ManagerException("cannot modify current course tempalte status");
            }
            courseTemplate.setStatus(op.getNextStatus());
            courseTemplateMapper.update(courseTemplate);

            // 如果是更新操作,则直接上线
            if (op.getOperateCode() == Constant.COURSEOPERATIONSUBMITUPDATED) {
                CourseTemplateEntityExt courseTemplateModify = CourseTemplateConverter.fromBo(courseTemplateBo);
                CourseTemplateBo result = this.updateCourseTemplate(courseTemplateModify, courseTemplate, true);
                LOGGER.warn(String.format("[transform course template status] ishangke admin [%d] edit course template and online [%d]", userBo.getId(), courseTemplate.getId()));
                List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, op.getNextStatus());
                result.setActionList(actions);
                return result;
            }

            // 如果是删除操作
            if (op.getOperateCode() == Constant.COURSEOPERATIONDELETE) {
                LOGGER.warn(String.format("[transform course template status] ishangke admin [%d] is deleteing course template [%d]", userBo.getId(), courseTemplate.getId()));
                courseTemplate.setStatus(Constant.COURSESTATUSOFFLINED);
                try {
                    courseTemplateMapper.deleteById(courseTemplate.getId());
                    return new CourseTemplateBo();
                } catch (Exception e) {
                    throw new ManagerException("delete failed");
                }
            }
            courseTemplate.setStatus(op.getNextStatus());
            courseTemplateMapper.update(courseTemplate);
            LOGGER.warn(String.format("[Booking]system admin [%d] [%s] courseTemplate status to [%d] at" + new Date(), userBo.getId(), op.getName(), op.getNextStatus()));
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, op.getNextStatus());
            CourseTemplateBo result = CourseTemplateConverter.toBo(courseTemplateMapper.getById(courseTemplateBo.getId()));
            result.setActionList(actions);
            return result;
        }
        return null;
    }

    @Override
    public List<CourseTemplateBo> queryCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, PaginationBo paginationBo) {
        String roleName = authManager.getRole(userBo.getId());
        if (Constant.ROLEPARTNERADMIN.equals(roleName) || Constant.ROLEPARTNERWENYUAN.equals(roleName)) {
            // 判断用户是否属于此partner
            List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("unlogin user");
            }
            boolean isSameGroup = false;
            if (authManager.isAdmin(userBo.getId()) || authManager.isSystemAdmin(userBo.getId())) {
                isSameGroup = true;
                LOGGER.warn(String.format("[TeacherManagerImpl]system admin || admin[%s] call createTeacher at " + new Date(), userBo.getName()));
            }
            else {
                for (GroupEntityExt g : groupList) {
                    // //因为我们有特殊情况 api中需要提供/coursetemplate/{id} 在这种情况下coursetemplate
                    // bo id明确为一个id值
                    if (IdChecker.isEqual(g.getPartnerId(), courseTemplateBo.getPartnerId())) {
                        isSameGroup = true;
                        break;
                    }
                }
            }
            
            if (isSameGroup == false) {
                throw new ManagerException("cannot query other partner's template");
            }
            ArrayList<CourseTemplateBo> convertered = new ArrayList<>();
            try {
                List<CourseTemplateEntityExt> list = courseTemplateMapper.list(CourseTemplateConverter.fromBo(courseTemplateBo), PaginationConverter.fromBo(paginationBo));
                if (list != null) {
                    for (CourseTemplateEntityExt c : list) {
                        CourseTemplateBo b = CourseTemplateConverter.toBo(c);
                        List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, b.getStatus());
                        b.setActionList(actions);
                        convertered.add(b);

                    }
                }
            } catch (Exception e) {
                throw new ManagerException("query course template failed");
            }
            return convertered;
        } else if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName)) {
            ArrayList<CourseTemplateBo> convertered = new ArrayList<>();
            try {
                List<CourseTemplateEntityExt> list = courseTemplateMapper.list(CourseTemplateConverter.fromBo(courseTemplateBo), PaginationConverter.fromBo(paginationBo));
                if (list != null) {
                    for (CourseTemplateEntityExt c : list) {
                        CourseTemplateBo b = CourseTemplateConverter.toBo(c);
                        List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSETEMPLATE, b.getStatus());
                        b.setActionList(actions);
                        convertered.add(b);

                    }
                }
            } catch (Exception e) {
                throw new ManagerException("query course template failed");
            }
            return convertered;
        }
        return null;
    }

    @Override
    public CourseTemplateBo queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo) {
        String roleName = authManager.getRole(userBo.getId());
        CourseTemplateEntityExt courseEntity = courseTemplateMapper.getInfoById(courseTemplateBo.getId());
        if (courseEntity == null) {
            throw new ManagerException("course template is not exits");
        }
        if (Constant.ROLEPARTNERADMIN.equals(roleName) || Constant.ROLEPARTNERWENYUAN.equals(roleName)) {
            // 判断此coursetemplate是否属于此user所在的partner
            List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("unlogin user");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), courseEntity.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (isSameGroup == false) {
                throw new ManagerException("cannot query other partner's template");
            }
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, courseEntity.getStatus());
            CourseTemplateBo b = CourseTemplateConverter.toBo(courseEntity);
            b.setActionList(actions);
            return b;
        } else if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName)) {
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, courseEntity.getStatus());
            CourseTemplateBo b = CourseTemplateConverter.toBo(courseEntity);
            b.setActionList(actions);
            return b;
        }
        return null;
    }

    @Override
    public int queryCourseTemplateTotal(CourseTemplateBo courseTemplateBo, UserBo userBo) {
        return courseTemplateMapper.getListCount(CourseTemplateConverter.fromBo(courseTemplateBo));
    }

}
