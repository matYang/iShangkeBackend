include "fault.thrift"
include "common.thrift"
include "course.thrift"
include "location.thrift"
include "partner.thrift"
include "user.thrift"
include "category.thrift"
include "circle.thrift"
include "teacher.thrift"
include "photo.thrift"
include "courseTemplate.thrift"

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
    common.ResponseBo createCourse(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: course.CourseBo courseBo, 3: list<teacher.TeacherBo> listTeacherBo, 4: list<photo.PhotoBo> listPhotoBo,  5: location.LocationBo locationBo, 6: partner.PartnerBo partnerBo, 7: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

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
     *  本方法为删除课程<br>
     *  合作商管理员可以通过此方法删除已经下架的课程
     *
     *  @param  courseeBo    需要被删除的课程信息
     *  @param  partnerBo           合作商信息
     *  @param  userBo              调用方法的用户的信息
     *
     *  @return  
     *
     */
    common.ResponseBo deleteCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

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
     *  本方法为根据关键字查找课程<br>
     *  通过此方法可以直接过滤搜索出按Category查找的课程
     *
     *  @param  String            CategoryBo关键字
     *
     *  @return  课程实体 CourseBo 列表
     *
     */
    common.ResponseBo queryByKeyword(1: string keyword) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     *  本方法为合作商提供查询课程的功能。<br>
     *  合作商可以查询本机构已经提交过的课程，包括新建、正在审批、已上架、已下架的所有课程。
     *
     *  @param  courseBo      需要检索和过滤的课程信息
     *  @param  partnerBo     合作商信息
     *  @param  userBo        调用方法的用户的信息
     *  @param  paginationBo  分页信息
     *
     *  @return 课程实体 CourseBo 列表
     *
     */
    common.ResponseBo queryByPartner(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

     /**
     *  本方法为用户查询课程的功能。<br>
     *  用户可以按照category，location，courseFilter查询所有课程
     *
     *  @param  courseBo        course过滤信息
     *  @param  categoryBo      category过滤信息
     *  @param  locationBo      location过滤信息
     *  @param  circleBo        circle过滤信息
     *  @param  paginationBo    分页信息
     *
     *  @return 课程实体 CourseBo 列表
     *
     */ 
    common.ResponseBo queryByFilter(1: course.CourseBo courseBo, 2: category.CategoryBo categoryBo, 3: location.LocationBo locationBo, 4: circle.CircleBo circleBo,5: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}

