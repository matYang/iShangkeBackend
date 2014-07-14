include "fault.thrift"
include "common.thrift"
include "course.thrift"
include "location.thrift"
include "partner.thrift"
include "user.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service CourseService {
    /**
     *  本方法为创建新课程<br>
     *  合作商管理员可以通过此方法创建新课程
     *
     *  @param  courseTemplateBo    课程模版信息
     *  @param  courseBo            需要被创建的课程信息
     *  @param  list<TeacherBo>     教师信息列表
     *  @param  locationBo          地理位置信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return 课程实体 CourseBo 
     *
     */
    common.ResponseBo createCourse(1: course.CourseTemplateBo courseTemplateBo, 2: course.CourseBo courseBo, 3: list<partner.TeacherBo> listTeacherBo, 4: list<partner.PhotoBo> listPhotoBo,  5: location.LocationBo locationBo, 6: partner.PartnerBo partnerBo, 7: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为创建新课程模版<br>
     *  合作商管理员可以通过此方法创建新课程模版
     *
     *  @param  courseTemplateBo    需要被创建的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  UserBo              调用方法的用户的信息
     *
     *  @return 课程模版实体 CourseTemplateBo 
     *
     */
    common.ResponseBo createCourseTemplateBo(1: course.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为提交课程<br>
     *  合作商管理员可以通过此方法提交课程
     *
     *  @param  courseBo        需要被创建的课程信息
     *  @param  partnerBo       合作商信息
     *  @param  userBo          调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo submitCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为提交课程模版<br>
     *  合作商管理员可以通过此方法提交课程模版
     *
     *  @param  courseTemplateBo    需要被创建的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  UserBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo submitCourseTemplate(1: course.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为审核通过课程<br>
     *  ishangke管理员可以通过此方法审核通过课程
     *
     *  @param  courseBo                  需要被审核的课程信息
     *  @param  partnerBo                 合作商信息
     *  @param  commentCourseApproveBo    审核通过课程评论信息
     *  @param  userBo                    调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo approveCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: course.CommentCourseApproveBo commentCourseApproveBo, 4: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为审核通过课程模版<br>
     *  ishangke管理员可以通过此方法审核通过课程模版
     *
     *  @param  courseTemplateBo          需要被审核的课程模版信息
     *  @param  partnerBo                 合作商信息
     *  @param  commentTemplateApproveBo  审核通过课程模版评论信息
     *  @param  userBo                    调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo approveCourseTemplate(1: course.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: course.CommentCourseTemplateApproveBo commentCourseTemplateApproveBo, 4: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为审核不通过课程<br>
     *  ishangke管理员可以通过此方法审核不通过课程
     *
     *  @param  courseBo          需要被审核的课程信息
     *  @param  partnerBo                 合作商信息
     *  @param  commentCourseApproveBo  审核不通过课程评论信息
     *  @param  userBo                    调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo rejectCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: course.CommentCourseRejectBo commentCourseRejectBo, 4: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
 
    /**
     *  本方法为审核不通过课程模版<br>
     *  ishangke管理员可以通过此方法审核不通过课程模版
     *
     *  @param  courseTemplateBo          需要被审核的课程模版信息
     *  @param  partnerBo                 合作商信息
     *  @param  commentTemplateApproveBo  审核不通过课程模版评论信息
     *  @param  userBo                    调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo rejectCourseTemplate(1: course.CourseTemplateBo courseTemplateBo, 2: course.CommentCourseTemplateRejectBo commentCourseTemplateRejectBo, 3: partner.PartnerBo partnerBo, 4: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为下架课程<br>
     *  合作商管理员可以通过此方法下架课程
     *
     *  @param  courseBo    需要被下架的课程信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo cancelCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为下架课程模版<br>
     *  合作商管理员可以通过此方法下架课程模版
     *
     *  @param  courseTemplateBo    需要被下架的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo cancelCourseTemplate(1: course.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为重新上架课程<br>
     *  合作商管理员可以通过此方法重新上架课程
     *
     *  @param  courseBo    需要被重新上架的课程信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo resubmitCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

     /**
     *  本方法为重新上架课程模版<br>
     *  合作商管理员可以通过此方法重新上架课程模版
     *
     *  @param  courseTemplateBo    需要被重新上架的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo resubmitCourserTemplate(1: course.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为删除课程<br>
     *  合作商管理员可以通过此方法删除已经下架的课程
     *
     *  @param  courseTemplateBo    需要被删除的课程信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo deleteCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为删除课程模版<br>
     *  合作商管理员可以通过此方法删除已经下架的课程模版
     *
     *  @param  courseTemplateBo    需要被删除的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo deleteCourseTempalte(1: course.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    /**
     *  本方法为修改课程<br>
     *  合作商管理员可以通过此方法修改课程
     *
     *  @param  courseBo            需要被修改的课程信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo updateCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

     /**
     *  本方法为修改课程模版<br>
     *  合作商管理员可以通过此方法修改课程模版
     *
     *  @param  courseTemplateBo    需要被修改的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo updateCourseTemplate(1: course.CourseTemplateBo courseTemplateBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为给课程评论<br>
     *  用户可以通过此方法给课程进行评论
     *
     *  @param  courseBo            需要被评论的课程信息
     *  @param  commentCourseBo     课程评论信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  课程评论实体 CommentCourseBo
     *
     */
    common.ResponseBo commentCourse(1: course.CourseBo courseBo, 2: course.CommentCourseBo commentCourseBo, 3: partner.PartnerBo partnerBo, 4:user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为搜索课程模版<br>
     *  合作商管理员可以通过此方法查询课程模版
     *
     *  @param  courseTemplateBo    需要检索和过滤的课程模版信息
     *  @param  partnerBo           合作商信息
     *  @param  UserBo              调用方法的用户的信息
     *  @param  paginationBo        分页信息
     *
     *  @return  
     *
     */
    common.ResponseBo queryCourseTempalte(1: course.CourseTemplateBo courseTemplateBo, 2: user.UserBo userBo, 3: partner.PartnerBo partnerBo, 4: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
}

