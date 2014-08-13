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
import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.dataaccess.mapper.CategoryEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.ClassPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseClassPhotoEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseCommentEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseTeacherEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseTemplateEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.GroupEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.TeacherEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.ClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseClassPhotoEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseCommentEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTeacherEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseTemplateEntityExt;
import com.ishangke.edunav.dataaccess.model.GroupEntityExt;
import com.ishangke.edunav.dataaccess.model.TeacherEntityExt;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CacheManager;
import com.ishangke.edunav.manager.CourseManager;
import com.ishangke.edunav.manager.TransformManager;
import com.ishangke.edunav.manager.converter.CourseCommentConverter;
import com.ishangke.edunav.manager.converter.CourseConverter;
import com.ishangke.edunav.manager.converter.PaginationConverter;
import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.manager.transform.Operation;

//todo
//关于权限的控制，状态的转移，需要再考虑一下
@Component
public class CourseManagerImpl implements CourseManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseManagerImpl.class);

    @Autowired
    private CourseEntityExtMapper courseMapper;

    @Autowired
    private AuthManager authManager;

    @Autowired
    private CourseTemplateEntityExtMapper courseTemplateMapper;

    @Autowired
    private GroupEntityExtMapper groupEntityExtMapper;

    @Autowired
    private ClassPhotoEntityExtMapper photoMapper;

    @Autowired
    private TeacherEntityExtMapper teacherMapper;

    @Autowired
    private TransformManager transformManager;

    @Autowired
    private GroupEntityExtMapper groupMapper;

    @Autowired
    private CourseTeacherEntityExtMapper courseTeacherMapper;

    @Autowired
    private CourseClassPhotoEntityExtMapper coursePhotoMapper;

    @Autowired
    private CourseCommentEntityExtMapper courseCommentMapper;

    @Autowired
    private CategoryEntityExtMapper categoryMapper;

    @Autowired
    private CacheManager cacheManager;

    @Override
    public CourseBo createCourse(CourseBo courseBo, UserBo userBo) {
        if (courseBo == null) {
            throw new ManagerException("Course Create Failed: CourseBo is null");
        }
        if (userBo == null) {
            throw new ManagerException("Course Create Failed: UserBo is null");
        }
        // 获取角色信息
        String roleName = authManager.getRole(userBo.getId());
        // 将courseBo转为courseEntity
        CourseEntityExt course = CourseConverter.fromBo(courseBo);
        if (Constant.ROLEPARTNERADMIN.equals(roleName) || Constant.ROLEPARTNERWENYUAN.equals(roleName)) {
            // 如果是合作机构管理员
            // 验证userBo是否是否属于同一家机构
            List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), courseBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (isSameGroup == false) {
                throw new ManagerException("cannot create other partner's course");
            }
            // 判断courseTemplate是否属于此partner
            CourseTemplateEntityExt courseTemplateEntity = courseTemplateMapper.getById(courseBo.getCourseTemplateId());
            if (courseTemplateEntity == null) {
                throw new ManagerException("course template is not exits");
            }
            if (IdChecker.notEqual(courseTemplateEntity.getPartnerId(), course.getPartnerId())) {
                throw new ManagerException("cannot user other partner's courseTemplate");
            }
            // 判断course template是否处于上线状态
            // course只能从上线状态的course template进行创建课程操作
            if (Constant.COURSESTATUSONLINED != courseTemplateEntity.getStatus()) {
                throw new ManagerException("course template is not online");
            }
            // 判断course/原价/ishangke价格是否与模版一致
            if (!courseTemplateEntity.getCourseName().equals(course.getCourseName()) || !courseTemplateEntity.getPrice().equals(course.getPrice())
                    || !courseTemplateEntity.getOriginalPrice().equals(course.getOriginalPrice())) {
                throw new ManagerException("cannot modify course name or price or origin price, must equal course template");
            }
            // 验证教师信息和classphoto信息是否属于本机构
            List<ClassPhotoEntityExt> classPhotos = course.getClassPhotoList();
            if (classPhotos != null) {
                for (ClassPhotoEntityExt photo : classPhotos) {
                    ClassPhotoEntityExt photoEntity = null;
                    try {
                        photoEntity = photoMapper.getById(photo.getId());
                    } catch (Exception e) {
                        throw new ManagerException("failed when query photo in partner repository");
                    }
                    if (photoEntity == null || IdChecker.notEqual(photoEntity.getPartnerId(), courseBo.getPartnerId())) {
                        throw new ManagerException("classphoto cannot found in partner photo repository");
                    }
                }
            }
            List<TeacherEntityExt> teachers = course.getTeacherList();
            if (teachers != null) {
                for (TeacherEntityExt teacher : teachers) {
                    TeacherEntityExt teacherEntity = null;
                    try {
                        teacherEntity = teacherMapper.getById(teacher.getId());
                    } catch (Exception e) {
                        throw new ManagerException("failed when query teacher in partner repository");
                    }
                    if (teacherEntity == null || IdChecker.notEqual(teacherEntity.getPartnerId(), courseBo.getPartnerId())) {
                        throw new ManagerException("teacher cannot found in partner teacher repository");
                    }
                }
            }
            // 开始插入
            try {
                // 刚刚创建出来的course template状态属于待审核状态
                course.setStatus(Constant.COURSESTATUSPENDINGREVIEW);
                // 修改创建时间
                course.setCreateTime(DateUtility.getCurTimeInstance());
                // 修来lastmodifytime
                course.setLastModifyTime(DateUtility.getCurTimeInstance());
                int result = 0;
                result = courseMapper.add(course);
                if (result > 0) {
                    // 插入classphoto关联
                    if (classPhotos != null) {
                        for (ClassPhotoEntityExt photo : classPhotos) {
                            try {
                                CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
                                courseClassPhotoEntityExt.setClassPhotoId(photo.getId());
                                courseClassPhotoEntityExt.setCourseId(course.getId());
                                courseClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                                coursePhotoMapper.add(courseClassPhotoEntityExt);
                            } catch (Exception e) {
                                throw new ManagerException("failed when add photo course relationship");
                            }
                        }
                    }
                    // 插入teacher关联
                    if (teachers != null) {
                        for (TeacherEntityExt teacher : teachers) {
                            try {
                                CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
                                courseTeacherEntityExt.setTeacherId(teacher.getId());
                                courseTeacherEntityExt.setCourseId(course.getId());
                                courseTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                                courseTeacherMapper.add(courseTeacherEntityExt);
                            } catch (Exception e) {
                                throw new ManagerException("failed when add teacher course relationship");
                            }
                        }
                    }
                    return CourseConverter.toBo(course);
                } else {
                    throw new ManagerException("Course Create Failed");
                }
            } catch (Throwable t) {
                throw new ManagerException("Course Create Failed", t);
            }
        } else if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName)) {
            // 如果是ishangke管理员

            // 验证教师信息和classphoto信息是否属于同一家机构
            // 即使不属于同一家机构，但是ishangke管理员也可以强行提交，日志系统会发出警报
            List<ClassPhotoEntityExt> classPhotos = course.getClassPhotoList();
            if (classPhotos != null) {
                for (ClassPhotoEntityExt photo : classPhotos) {
                    ClassPhotoEntityExt photoEntity = null;
                    try {
                        photoEntity = photoMapper.getById(photo.getId());
                    } catch (Exception e) {
                        throw new ManagerException("failed when query photo");
                    }
                    if (photoEntity == null) {
                        LOGGER.warn(String.format("[create course] ishangke admin [%d] try to use illegal photo, photo [%d] cannot found", userBo.getId(),
                                photoEntity == null ? null : photoEntity.getId()));
                    }
                    if (IdChecker.notEqual(photoEntity.getPartnerId(), courseBo.getPartnerId())) {
                        LOGGER.warn(String.format("[create course] ishangke admin [%d] try to use illegal photo, photo [%d] belong [%d]", userBo.getId(), photoEntity.getId(), photo.getPartnerId()));
                    }
                }
            }
            List<TeacherEntityExt> teachers = course.getTeacherList();
            if (teachers != null) {
                for (TeacherEntityExt teacher : teachers) {
                    TeacherEntityExt teacherEntity = null;
                    try {
                        teacherEntity = teacherMapper.getById(teacher.getId());
                    } catch (Exception e) {
                        throw new ManagerException("failed when query teacher");
                    }
                    if (teacherEntity == null) {
                        LOGGER.warn(String.format("[create course] ishangke admin [%d] try to use illegal teacher, teacher [%d] cannot found", userBo.getId(), teacherEntity == null ? null
                                : teacherEntity.getId()));
                    }
                    if (IdChecker.notEqual(teacherEntity.getPartnerId(), courseBo.getPartnerId())) {
                        LOGGER.warn(String.format("[create course] ishangke admin [%d] try to use illegal teacher, teacher [%d] belong [%d]", userBo.getId(), teacherEntity.getId(),
                                teacherEntity.getPartnerId()));
                    }
                }
            }
            try {
                // admin创建出来的course template 默认为已上线状态
                course.setStatus(Constant.COURSESTATUSONLINED);
                // 设置createtime
                course.setCreateTime(DateUtility.getCurTimeInstance());
                // 设置lastmodifytime
                course.setLastModifyTime(DateUtility.getCurTimeInstance());
                int result = 0;
                result = courseMapper.add(course);
                if (result > 0) {
                    LOGGER.warn(String.format("[create course] ishangke admin or system admin [%d] crate course template for partner [%d], course id is [%d]", userBo.getId(), courseBo.getId(),
                            course.getId()));
                    return CourseConverter.toBo(courseMapper.getInfoById(course.getId()));
                } else {
                    throw new ManagerException("Course Create Failed");
                }
            } catch (Throwable t) {
                throw new ManagerException("Course Create Failed", t);
            }
        }
        return null;
    }

    @Override
    public CourseCommentBo commentCourse(CourseCommentBo courseCommentBo, UserBo userBo) {
        if (IdChecker.notEqual(courseCommentBo.getUserId(), userBo.getId())) {
            throw new ManagerException("must crate comment for self");
        }
        CourseCommentEntityExt courseCommentEntity = CourseCommentConverter.fromBo(courseCommentBo);
        courseCommentEntity.setCourseTemplateId(courseCommentBo.getCourseTemplateId());
        courseCommentEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
        courseCommentEntity.setCreateTime(DateUtility.getCurTimeInstance());
        try {
            courseCommentMapper.add(courseCommentEntity);
        } catch (Exception e) {
            throw new ManagerException("create comment failed");
        }
        return CourseCommentConverter.toBo(courseCommentEntity);
    }

    @Override
    public List<CourseCommentBo> queryCommentByCourseId(CourseBo courseBo, PaginationBo paginationBo) {
        CourseEntityExt course = courseMapper.getById(courseBo.getId());
        if (course == null) {
            throw new ManagerException("course is not exits");
        }
        if (Constant.COURSESTATUSONLINED != course.getStatus()) {
            throw new ManagerException("course is not online");
        }
        int courseTemplateId = course.getCourseTemplateId();
        CourseCommentEntityExt courseEntity = new CourseCommentEntityExt();
        courseEntity.setCourseTemplateId(courseTemplateId);
        List<CourseCommentBo> convertered = new ArrayList<>();
        try {
            List<CourseCommentEntityExt> result = courseCommentMapper.list(courseEntity, PaginationConverter.fromBo(paginationBo));
            if (result != null) {
                for (CourseCommentEntityExt c : result) {
                    convertered.add(CourseCommentConverter.toBo(c));
                }
            }
        } catch (Exception e) {
            throw new ManagerException("query course comment failed");
        }
        return convertered;
    }

    @Override
    public CourseCommentBo deleteCommentByCommentId(CourseCommentBo courseCommentBo, UserBo userBo) {
        if (courseCommentBo == null || userBo == null) {
            throw new ManagerException("无效请求参数");
        }

        String roleName = authManager.getRole(userBo.getId());
        if (!(Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName))) {
            throw new ManagerException("cannot delete comment current user");
        }
        try {
            courseCommentMapper.deleteById(courseCommentBo.getId());
        } catch (Exception e) {
            throw new ManagerException("delete course comment failed");
        }
        LOGGER.warn(String.format("[delete course comment] ishangke admin [%d] delete course comment [%d]", userBo.getId(), courseCommentBo.getId()));
        return new CourseCommentBo();
    }

    @Override
    public List<CategoryBo> queryCategoryByKeyword(String keyword) {
        // todo 搜索功能，根据用户输入的关键词，跳转到相应的三级目录的功能
        // 需要提前录入
        if (keyword.length() >= Constant.CATEGORYCACHEMAXLENGTH) {
            keyword.substring(0, Constant.CATEGORYCACHEMAXLENGTH);
        }
        ArrayList<CategoryBo> result = (ArrayList<CategoryBo>) cacheManager.get(Constant.CATEGORYCACHE + keyword);
        if (result == null) {
            LOGGER.error("[query category] cannot find category cache " + Constant.CATEGORYCACHE + keyword);
            result = new ArrayList<>();
        }
        return result;
    }

    @Override
    public List<CourseBo> queryCourse(CourseBo courseBo, UserBo userBo, PaginationBo paginationBo) {
        String roleName = authManager.getRole(userBo.getId());
        if (Constant.ROLEPARTNERADMIN.equals(roleName) || Constant.ROLEPARTNERWENYUAN.equals(roleName)) {
            // 如果是合作机构管理员
            // 验证userBo是否是否属于同一家机构
            List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), courseBo.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (isSameGroup == false) {
                throw new ManagerException("cannot query other partner's course");
            }
            CourseEntityExt course = CourseConverter.fromBo(courseBo);
            List<CourseBo> convertered = new ArrayList<>();
            try {
                List<CourseEntityExt> result = courseMapper.list(course, PaginationConverter.fromBo(paginationBo));
                if (result != null) {
                    for (CourseEntityExt c : result) {
                        CourseBo b = CourseConverter.toBo(c);
                        List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, b.getStatus());
                        b.setActionList(actions);
                        convertered.add(b);
                    }
                }
            } catch (Exception e) {
                throw new ManagerException("query course failed");
            }
            return convertered;
        } else if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName)) {
            CourseEntityExt course = CourseConverter.fromBo(courseBo);
            List<CourseBo> convertered = new ArrayList<>();
            try {
                List<CourseEntityExt> result = courseMapper.list(course, PaginationConverter.fromBo(paginationBo));
                if (result != null) {
                    for (CourseEntityExt c : result) {
                        CourseBo b = CourseConverter.toBo(c);
                        List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, b.getStatus());
                        b.setActionList(actions);
                        convertered.add(b);
                    }
                }
            } catch (Exception e) {
                throw new ManagerException("query course failed");
            }
            return convertered;
        }
        return null;
    }

    @Override
    public List<CourseBo> queryCourseByFilter(CourseBo courseBo, PaginationBo paginationBo) {
        // to do use memcached
        List<CourseBo> convertered = new ArrayList<>();
        // 只能搜索已上线的课程
        courseBo.setStatus(Constant.COURSESTATUSONLINED);
        try {
            List<CourseEntityExt> result = courseMapper.list(CourseConverter.fromBo(courseBo), PaginationConverter.fromBo(paginationBo));
            if (result != null) {
                for (CourseEntityExt c : result) {
                    convertered.add(CourseConverter.toBo(c));
                }
            }
        } catch (Exception e) {
            throw new ManagerException("query course failed", e);
        }
        return convertered;
    }

    @Override
    public CourseBo queryById(CourseBo courseBo, UserBo userBo) {
        CourseBo convertered = new CourseBo();
        CourseEntityExt course = null;
        try {
            course = courseMapper.getInfoById(courseBo.getId());
        } catch (Exception e) {
            throw new ManagerException("query course failed");
        }
        if (course == null) {
            throw new ManagerException("cannot found");
        }
        convertered = CourseConverter.toBo(course);
        if (userBo != null && IdChecker.notNull(userBo.getId())) {
            String roleName = authManager.getRole(userBo.getId());
            if (Constant.ROLESYSTEMADMIN.equals(roleName)) {
                // 判断此coursetemplate是否属于此user所在的partner
                List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
                if (groupList == null) {
                    throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
                }
                boolean isSameGroup = false;
                for (GroupEntityExt g : groupList) {
                    if (IdChecker.isEqual(g.getPartnerId(), convertered.getPartnerId())) {
                        isSameGroup = true;
                        break;
                    }
                    if (isSameGroup) {
                        // 如果属于此partner，则此展示可以对课程进行的操作
                        List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, convertered.getStatus());
                        convertered.setActionList(actions);
                    }
                }
            } else if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLEPARTNERADMIN.equals(roleName) || Constant.ROLEPARTNERWENYUAN.equals(roleName)) {
                // 展示可以对课程进行的操作
                List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, convertered.getStatus());
                convertered.setActionList(actions);
            }
        }
        return convertered;
    }

    @Override
    public CourseBo transformCourseStatus(CourseBo courseBo, int operation, UserBo userBo) {
        CourseEntityExt courseEntity = courseMapper.getInfoById(courseBo.getId());
        CourseEntityExt courseEntityModify = CourseConverter.fromBo(courseBo);
        String roleName = authManager.getRole(userBo.getId());
        List<Operation> operationList = transformManager.getOperationByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, courseEntity.getStatus());
        Operation op = null;
        if (operationList != null) {
            for (Operation o : operationList) {
                if (o.getOperateCode() == operation) {
                    op = o;
                }
            }
        }
        if (Constant.ROLEPARTNERADMIN.equals(roleName) || Constant.ROLEPARTNERWENYUAN.equals(roleName)) {
            List<GroupEntityExt> groupList = groupEntityExtMapper.listGroupsByUserId(userBo.getId());
            if (groupList == null) {
                throw new ManagerException("对不起，用户权限搜索失败，请稍后再试");
            }
            boolean isSameGroup = false;
            for (GroupEntityExt g : groupList) {
                if (IdChecker.isEqual(g.getPartnerId(), courseEntity.getPartnerId())) {
                    isSameGroup = true;
                    break;
                }
            }
            if (isSameGroup == false) {
                throw new ManagerException("cannot query other partner's course");
            }
            // 按照业务流程修改courseTemplate
            if (op == null) {
                throw new ManagerException("cannot modify current course status");
            }
            // 如果是更新操作转，调用update方法
            if (op.getOperateCode() == Constant.COURSEOPERATIONSUBMITUPDATED) {
                // 不会被立刻上线
                CourseBo result = this.updateCourse(courseEntityModify, courseEntity, false);
                List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, op.getNextStatus());
                result.setActionList(actions);
                return result;
            }
            // 如果是删除操作
            if (op.getOperateCode() == Constant.COURSEOPERATIONDELETE) {
                LOGGER.warn(String.format("[transform course template status] partner admin [%d] is deleteing course [%d]", userBo.getId(), courseEntity.getId()));
                courseEntity.setStatus(Constant.COURSESTATUSOFFLINED);
                try {
                    courseTemplateMapper.deleteById(courseEntity.getId());
                    return CourseConverter.toBo(courseEntity);
                } catch (Exception e) {
                    throw new ManagerException("delete failed");
                }
            }
            // 修改lastmodifytime
            courseEntity.setLastModifyTime(DateUtility.getCurTimeInstance());
            courseEntity.setStatus(op.getNextStatus());
            courseMapper.update(courseEntity);
            // 插入可以进行的下一步操作
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, op.getNextStatus());
            CourseBo result = CourseConverter.toBo(courseMapper.getInfoById(courseEntity.getId()));
            result.setActionList(actions);
            return result;
        } else if (Constant.ROLEADMIN.equals(roleName) || Constant.ROLESYSTEMADMIN.equals(roleName)) {
            if (op == null) {
                throw new ManagerException("cannot modify current course tempalte status");
            }
            courseEntity.setStatus(op.getNextStatus());
            courseMapper.update(courseEntity);

            // 如果是更新操作,则直接上线
            if (op.getOperateCode() == Constant.COURSEOPERATIONSUBMITUPDATED) {
                CourseBo result = this.updateCourse(courseEntityModify, courseEntity, true);
                LOGGER.warn(String.format("[transform course status] ishangke admin [%d] edit course and online [%d]", userBo.getId(), courseEntity.getId()));
                List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, op.getNextStatus());
                result.setActionList(actions);
                return result;
            }

            // 如果是删除操作
            if (op.getOperateCode() == Constant.COURSEOPERATIONDELETE) {
                LOGGER.warn(String.format("[transform course status] ishangke admin [%d] is deleteing course [%d]", userBo.getId(), courseEntity.getId()));
                courseEntity.setStatus(Constant.COURSESTATUSOFFLINED);
                try {
                    courseMapper.deleteById(courseEntity.getId());
                    return CourseConverter.toBo(courseEntity);
                } catch (Exception e) {
                    throw new ManagerException("delete failed");
                }
            }
            courseEntity.setStatus(op.getNextStatus());
            courseMapper.update(courseEntity);
            LOGGER.warn(String.format("[Booking]system admin [%d] [%s] course status to [%d] at" + new Date(), userBo.getId(), op.getName(), op.getNextStatus()));
            List<ActionBo> actions = transformManager.getActionByRoleName(roleName, Constant.STATUSTRANSFORMCOURSE, op.getNextStatus());
            CourseBo result = CourseConverter.toBo(courseMapper.getInfoById(courseBo.getId()));
            result.setActionList(actions);
            return result;
        }
        return null;
    }

    private CourseBo updateCourse(CourseEntityExt courseEntityModify, CourseEntityExt oldCourseEntity, boolean isOnline) {
        if (!isOnline) {
            if ((courseEntityModify.getPrice() != null && !courseEntityModify.getPrice().equals(oldCourseEntity.getPrice()))
                    || (courseEntityModify.getCourseName() != null && !courseEntityModify.getCourseName().equals(oldCourseEntity.getCourseName()))
                    || (courseEntityModify.getOriginalPrice() != null && !courseEntityModify.getOriginalPrice().equals(oldCourseEntity.getOriginalPrice()))) {
                throw new ManagerException("cannot modify price , name , origin price");
            }
            List<ClassPhotoEntityExt> classPhotos = null;
            List<TeacherEntityExt> teachers = null;
            // 验证教师信息和classphoto信息是否属于本机构
            if (courseEntityModify.getClassPhotoList() != null) {
                classPhotos = courseEntityModify.getClassPhotoList();
                if (classPhotos != null) {
                    for (ClassPhotoEntityExt photo : classPhotos) {
                        ClassPhotoEntityExt photoEntity = null;
                        try {
                            photoEntity = photoMapper.getById(photo.getId());
                        } catch (Exception e) {
                            throw new ManagerException("failed when query photo in partner repository");
                        }
                        if (photoEntity == null || IdChecker.notEqual(photoEntity.getPartnerId(), oldCourseEntity.getPartnerId())) {
                            throw new ManagerException("classphoto cannot found in partner photo repository");
                        }
                    }
                }
            }

            if (courseEntityModify.getTeacherList() != null) {
                teachers = courseEntityModify.getTeacherList();
                if (teachers != null) {
                    for (TeacherEntityExt teacher : teachers) {
                        TeacherEntityExt teacherEntity = null;
                        try {
                            teacherEntity = teacherMapper.getById(teacher.getId());
                        } catch (Exception e) {
                            throw new ManagerException("failed when query teacher in partner repository");
                        }
                        if (teacherEntity == null || IdChecker.notEqual(teacherEntity.getPartnerId(), oldCourseEntity.getPartnerId())) {
                            throw new ManagerException("teacher cannot found in partner teacher repository");
                        }
                    }
                }
            }
            // 删除原有的教师信息/classphoto与classtemplate的关联
            List<TeacherEntityExt> oldTeachers = teacherMapper.listTeacherByCourseId(courseEntityModify.getId());
            if (oldTeachers != null && oldTeachers.size() != 0) {
                for (TeacherEntityExt t : oldTeachers) {
                    courseTeacherMapper.deleteByCourseIdTeacherId(courseEntityModify.getId(), t.getId());
                }
            }
            List<ClassPhotoEntityExt> oldPhotos = photoMapper.listClassPhotoByCourseTempleteId(courseEntityModify.getId());
            if (oldPhotos != null && oldPhotos.size() != 0) {
                for (ClassPhotoEntityExt p : oldPhotos) {
                    coursePhotoMapper.deleteByCourseIdClassPhotoId(courseEntityModify.getId(), p.getId());
                }
            }
            // 建立新的教师信息/classphoto与classtemplate的关联
            // 插入classphoto关联
            if (classPhotos != null) {
                for (ClassPhotoEntityExt photo : classPhotos) {
                    try {
                        CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
                        courseClassPhotoEntityExt.setClassPhotoId(photo.getId());
                        courseClassPhotoEntityExt.setCourseId(courseEntityModify.getId());
                        courseClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                        coursePhotoMapper.add(courseClassPhotoEntityExt);
                    } catch (Exception e) {
                        throw new ManagerException("failed when add photo course template relationship");
                    }
                }
            }
            // 插入teacher关联
            if (teachers != null) {
                for (TeacherEntityExt teacher : teachers) {
                    try {
                        CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
                        courseTeacherEntityExt.setTeacherId(teacher.getId());
                        courseTeacherEntityExt.setCourseId(courseEntityModify.getId());
                        courseTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                        courseTeacherMapper.add(courseTeacherEntityExt);
                    } catch (Exception e) {
                        throw new ManagerException("failed when add teacher course tempalte relationship");
                    }
                }
            }
            // 修改lastmodifytime
            courseEntityModify.setLastModifyTime(DateUtility.getCurTimeInstance());
            // 状态设置为待审核
            courseEntityModify.setStatus(Constant.COURSESTATUSPENDINGREVIEW);
            // 不能修改partner id
            courseEntityModify.setPartnerId(oldCourseEntity.getPartnerId());
            // 不能修改course template id
            courseEntityModify.setCourseTemplateId(oldCourseEntity.getCourseTemplateId());
            courseMapper.update(courseEntityModify);
        } else {
            List<ClassPhotoEntityExt> classPhotos = courseEntityModify.getClassPhotoList();
            List<TeacherEntityExt> teachers = courseEntityModify.getTeacherList();
            if (classPhotos != null) {
                List<ClassPhotoEntityExt> oldPhotos = photoMapper.listClassPhotoByCourseTempleteId(courseEntityModify.getId());
                if (oldPhotos != null && oldPhotos.size() != 0) {
                    for (ClassPhotoEntityExt p : oldPhotos) {
                        coursePhotoMapper.deleteByCourseIdClassPhotoId(courseEntityModify.getId(), p.getId());
                    }
                }
            }
            if (teachers != null) {
                // 删除原有的教师信息/classphoto与classtemplate的关联
                List<TeacherEntityExt> oldTeachers = teacherMapper.listTeacherByCourseId(courseEntityModify.getId());
                if (oldTeachers != null && oldTeachers.size() != 0) {
                    for (TeacherEntityExt t : oldTeachers) {
                        courseTeacherMapper.deleteByCourseIdTeacherId(courseEntityModify.getId(), t.getId());
                    }
                }
            }

            // 建立新的教师信息/classphoto与classtemplate的关联
            // 插入classphoto关联
            if (classPhotos != null) {
                for (ClassPhotoEntityExt photo : classPhotos) {
                    try {
                        CourseClassPhotoEntityExt courseClassPhotoEntityExt = new CourseClassPhotoEntityExt();
                        courseClassPhotoEntityExt.setClassPhotoId(photo.getId());
                        courseClassPhotoEntityExt.setCourseId(courseEntityModify.getId());
                        courseClassPhotoEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                        coursePhotoMapper.add(courseClassPhotoEntityExt);
                    } catch (Exception e) {
                        throw new ManagerException("failed when add photo course template relationship");
                    }
                }
            }
            // 插入teacher关联
            if (teachers != null) {
                for (TeacherEntityExt teacher : teachers) {
                    try {
                        CourseTeacherEntityExt courseTeacherEntityExt = new CourseTeacherEntityExt();
                        courseTeacherEntityExt.setTeacherId(teacher.getId());
                        courseTeacherEntityExt.setCourseId(courseEntityModify.getId());
                        courseTeacherEntityExt.setCreateTime(DateUtility.getCurTimeInstance());
                        courseTeacherMapper.add(courseTeacherEntityExt);
                    } catch (Exception e) {
                        throw new ManagerException("failed when add teacher course tempalte relationship");
                    }
                }
            }
            // 不能修改partner
            courseEntityModify.setPartnerId(oldCourseEntity.getPartnerId());
            // 修改lastmodifytime
            courseEntityModify.setLastModifyTime(DateUtility.getCurTimeInstance());
            // 状态直接设置为已上线
            courseEntityModify.setStatus(Constant.COURSESTATUSONLINED);
            courseMapper.update(courseEntityModify);
        }
        return CourseConverter.toBo(courseMapper.getInfoById(courseEntityModify.getId()));
    }

    @Override
    public int queryCommentByCourseIdTotal(CourseBo courseBo) {
        return courseMapper.getListCount(CourseConverter.fromBo(courseBo));
    }

    @Override
    public int queryCourseTotal(CourseBo courseBo, UserBo userBo) {
        return courseMapper.getListCount(CourseConverter.fromBo(courseBo));
    }

    @Override
    public int queryCourseByFilterTotal(CourseBo courseBo) {
        return courseMapper.getListCount(CourseConverter.fromBo(courseBo));
    }

}
