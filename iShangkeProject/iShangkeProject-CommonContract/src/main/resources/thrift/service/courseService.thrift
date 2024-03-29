include "model/fault.thrift"
include "model/common.thrift"
include "model/course.thrift"
include "model/courseComment.thrift"
include "model/partner.thrift"
include "model/category.thrift"
include "model/user.thrift"
include "model/courseTemplate.thrift"
include "model/coursePromotion.thrift"

namespace java com.ishangke.edunav.commoncontract.service



service CourseService {

    /**
     * 本方法为创建新课程<br>
     * 合作商管理员可以通过此方法创建新课程
     * 
     * @param courseBo
     *            需要被创建的课程信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return 课程实体 CourseBo
     * 
     * 
     * @param courseTemplateBo
     * @param courseBo
     * @param partnerBo
     * @param userBo
     */
    course.CourseBo createCourse(1: course.CourseBo courseBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 本方法为给课程评论<br>
     * 用户可以通过此方法给课程进行评论
     * 
     * @param CourseCommentBo   $
     *            课程评论信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return 课程评论实体 CourseCommentBo
     * 
     * 
     * @param courseBo
     * @param CourseCommentBo
     * @param partnerBo
     * @param userBo
     */
    courseComment.CourseCommentBo commentCourse(1: courseComment.CourseCommentBo courseCommnet, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 查询课程的评价
     * @param courseBo
     * @return
     */
    courseComment.CourseCommentPageViewBo queryCommentByCourseId(1: course.CourseBo courseBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    courseComment.CourseCommentPageViewBo queryComment(1: courseComment.CourseCommentBo courseCommentBo, 2: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     * 删除课程的评价
     * @param CourseCommentBo
     * @param userBo
     * @return
     */
    courseComment.CourseCommentBo deleteCommentByCommentId(1: courseComment.CourseCommentBo courseCommentBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    
    
    /**
     * 本方法为根据关键字查找课程<br>
     * 通过此方法可以直接过滤搜索出按Category查找的课程
     * 
     * @param String
     *            CategoryBo关键字
     * 
     * @return CategoryBo 列表
     * 
     * 
     * @param keyword
     */
    category.CategoryPageViewBo queryCategoryByKeyword(1: string keyword, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 本方法为合作商提供查询课程的功能。<br>
     * 合作商可以查询本机构已经提交过的课程，包括新建、正在审批、已上架、已下架的所有课程。
     * 
     * @param courseBo
     *            需要检索和过滤的课程信息
     * @param userBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 课程实体 course.CourseBo 列表
     * 
     * 
     * @param courseBo
     * @param partnerBo
     * @param userBo
     * @param paginationBo
     */
    course.CoursePageViewBo queryCourse(1: course.CourseBo courseBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 本方法为用户查询课程的功能。<br>
     * 用户可以按照category，location，courseFilter查询所有课程
     * 只能搜索已上线的课程
     * 
     * @param courseBo
     *            course过滤信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 课程实体 course.CourseBo 列表
     * 
     * 
     * @param courseBo
     * @param paginationBo
     */
    course.CoursePageViewBo queryCourseByFilter(1: course.CourseBo courseBo, 2: common.PaginationBo paginationBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 本方法返回课程详情<br>
     * 合作商/管理员可以通过此方法调取课程详情
     * 
     * @param courseBo
     *            课程id
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseBo
     * @param userBo
     */
    course.CourseBo queryCourseById(1: course.CourseBo courseBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     * 修改course状态
     * @param courseBo
     * @param operation
     * @param userBo
     * @return
     */
    course.CourseBo transformCourseStatus(1: course.CourseBo courseBo, 2: i32 operation, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     * 本方法为创建新课程模版<br>
     * 合作商管理员可以通过此方法创建新课程模版
     * 
     * @param courseTemplateBo
     *            需要被创建的课程模版信息
     * @param partnerBo
     *            合作商信息
     * @param UserBo
     *            调用方法的用户的信息
     * 
     * @return 课程模版实体 CourseTemplateBo
     * 
     * 
     * @param courseTemplateBo
     * @param partnerBo
     * @param userBo
     */
    courseTemplate.CourseTemplateBo createCourseTemplate(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 
     * @param courseTemplateBo
     * @param partnerBo
     * @param userBo
     * @return
     */
    courseTemplate.CourseTemplateBo transformCourseTmeplateStatus(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: i32 operation, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 本方法为搜索课程模版<br>
     * 合作商管理员可以通过此方法查询课程模版
     * 
     * @param courseTemplateBo
     *            需要检索和过滤的课程模版信息
     * @param partnerBo
     *            合作商信息
     * @param UserBo
     *            调用方法的用户的信息
     * @param paginationBo
     *            分页信息
     * 
     * @return
     * 
     * 
     * @param courseTemplateBo
     * @param userBo
     * @param partnerBo
     * @param paginationBo
     */
    courseTemplate.CourseTemplatePageViewBo queryCourseTemplate(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: user.UserBo userBo, 3: common.PaginationBo paginationBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    /**
     * 本方法返回课程模版详情<br>
     * 合作商/管理员可以通过此方法调取
     * 
     * @param courseTemplateBo
     *            课程模板id
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseTemplateBo
     * @param userBo
     */
    courseTemplate.CourseTemplateBo queryCourseTemplateById(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	
    /**
     * 本方法返回课程置顶信息<br>
     * 管理员可以通过此方法调取课程置顶信息
     * 
     * @param coursePromotionBo
     *            课程置顶查询条件
     * @param userBo
     *            调用方法的用户的信息
     * @return
     */
    coursePromotion.CoursePromotionPageViewBo queryPromotion(1: coursePromotion.CoursePromotionBo coursePromotionBo, 2: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	
    /**
     * 本方法创建课程置顶信息<br>
     * 管理员可以通过此方法创建课程置顶信息
     * 
     * @param coursePromotionBo
     *            需要创建的置顶课程对应关系
     * @param userBo
     *            调用方法的用户的信息
     * @return
     */
	coursePromotion.CoursePromotionBo createPromotion(1: coursePromotion.CoursePromotionBo coursePromotionBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	
		
    /**
     * 本方法更新课程置顶信息<br>
     * 管理员可以通过此方法更新课程置顶信息
     * 
     * @param coursePromotionBo
     *            需要更新的置顶课程对应关系
     * @param userBo
     *            调用方法的用户的信息
     * @return
     */
	coursePromotion.CoursePromotionBo updatePromotion(1: coursePromotion.CoursePromotionBo coursePromotionBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	
	
	/**
     * 本方法删除课程置顶信息<br>
     * 管理员可以通过此方法删除课程置顶信息
     * 
     * @param coursePromotionBo
     *            需要删除的置顶课程对应关系id
     * @param userBo
     *            调用方法的用户的信息
     * @return
     */
	coursePromotion.CoursePromotionBo deletePromotion(1: coursePromotion.CoursePromotionBo coursePromotionBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)
		
	

    // /**********************************************************
    // *
    // *   关于课程的 Course
    // *
    // **********************************************************/

    // /**
    //  *  本方法为创建新课程<br>
    //  *  合作商管理员可以通过此方法创建新课程
    //  *
    //  *  @param  courseTemplateBo    课程模版信息
    //  *  @param  courseBo            需要被创建的课程信息
    //  *  @param  list<TeacherBo>     教师信息列表
    //  *  @param  locationBo          地理位置信息
    //  *  @param  partnerBo           合作商信息
    //  *  @param  userBo              调用方法的用户的信息
    //  *
    //  *  @return 课程实体 CourseBo 
    //  *
    //  */
    // course.CourseBo createCourse(1: courseTemplate.CourseTemplateBo courseTemplateBo, 2: course.CourseBo courseBo,  3: partner.PartnerBo partnerBo, 4: user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为提交课程<br>
    //  *  合作商管理员可以通过此方法提交课程
    //  *
    //  *  @param  courseBo        需要被创建的课程信息
    //  *  @param  partnerBo       合作商信息
    //  *  @param  userBo          调用方法的用户的信息
    //  *
    //  *  @return  
    //  *
    //  */
    // course.CourseBo submitCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    // /**
    //  *  本方法为审核通过课程<br>
    //  *  ishangke管理员可以通过此方法审核通过课程
    //  *
    //  *  @param  courseBo                  需要被审核的课程信息
    //  *  @param  partnerBo                 合作商信息
    //  *  @param  commentCourseApproveBo    审核通过课程评论信息
    //  *  @param  userBo                    调用方法的用户的信息
    //  *
    //  *  @return  
    //  *
    //  */
    // course.CourseBo approveCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: course.CommentCourseApproveBo commentCourseApproveBo, 4: user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    // /**
    //  *  本方法为审核不通过课程<br>
    //  *  ishangke管理员可以通过此方法审核不通过课程
    //  *
    //  *  @param  courseBo          需要被审核的课程信息
    //  *  @param  partnerBo                 合作商信息
    //  *  @param  commentCourseApproveBo  审核不通过课程评论信息
    //  *  @param  userBo                    调用方法的用户的信息
    //  *
    //  *  @return  
    //  *
    //  */
    // course.CourseBo rejectCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: course.CommentCourseRejectBo commentCourseRejectBo, 4: user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为下架课程<br>
    //  *  合作商管理员可以通过此方法下架课程
    //  *
    //  *  @param  courseBo    需要被下架的课程信息
    //  *  @param  partnerBo           合作商信息
    //  *  @param  userBo              调用方法的用户的信息
    //  *
    //  *  @return  
    //  *
    //  */
    // course.CourseBo cancelCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    // /**
    //  *  本方法为重新上架课程<br>
    //  *  合作商管理员可以通过此方法重新上架课程
    //  *
    //  *  @param  courseBo    需要被重新上架的课程信息
    //  *  @param  partnerBo           合作商信息
    //  *  @param  userBo              调用方法的用户的信息
    //  *
    //  *  @return  
    //  *
    //  */
    // course.CourseBo resubmitCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    // /**
    //  *  本方法为删除课程<br>
    //  *  合作商管理员可以通过此方法删除已经下架的课程
    //  *
    //  *  @param  courseeBo    需要被删除的课程信息
    //  *  @param  partnerBo           合作商信息
    //  *  @param  userBo              调用方法的用户的信息
    //  *
    //  *  @return  
    //  *
    //  */
    // course.CourseBo deleteCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo) 

    // /**
    //  *  本方法为修改课程<br>
    //  *  合作商管理员可以通过此方法修改课程
    //  *
    //  *  @param  courseBo            需要被修改的课程信息
    //  *  @param  partnerBo           合作商信息
    //  *  @param  userBo              调用方法的用户的信息
    //  *
    //  *  @return  
    //  *
    //  */
    // course.CourseBo updateCourse(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为给课程评论<br>
    //  *  用户可以通过此方法给课程进行评论
    //  *
    //  *  @param  courseBo            需要被评论的课程信息
    //  *  @param  commentCourseBo     课程评论信息
    //  *  @param  partnerBo           合作商信息
    //  *  @param  userBo              调用方法的用户的信息
    //  *
    //  *  @return  课程评论实体 CommentCourseBo
    //  *
    //  */
    // course.CourseBo commentCourse(1: course.CourseBo courseBo, 2: course.CommentCourseBo commentCourseBo, 3: partner.PartnerBo partnerBo, 4:user.UserBo userBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为根据关键字查找课程<br>
    //  *  通过此方法可以直接过滤搜索出按Category查找的课程
    //  *
    //  *  @param  String            CategoryBo关键字
    //  *
    //  *  @return  课程实体 CourseBo 列表
    //  *
    //  */
    // course.CoursePageViewBo queryCourseByKeyword(1: string keyword, 2: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    // /**
    //  *  本方法为合作商提供查询课程的功能。<br>
    //  *  合作商可以查询本机构已经提交过的课程，包括新建、正在审批、已上架、已下架的所有课程。
    //  *
    //  *  @param  courseBo      需要检索和过滤的课程信息
    //  *  @param  partnerBo     合作商信息
    //  *  @param  userBo        调用方法的用户的信息
    //  *  @param  paginationBo  分页信息
    //  *
    //  *  @return 课程实体 CourseBo 列表
    //  *
    //  */
    // course.CoursePageViewBo queryCourseByPartner(1: course.CourseBo courseBo, 2: partner.PartnerBo partnerBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo, 5: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

    //  /**
    //  *  本方法为用户查询课程的功能。<br>
    //  *  用户可以按照category，location，courseFilter查询所有课程
    //  *
    //  *  @param  courseBo        course过滤信息
    //  *  @param  categoryBo      category过滤信息
    //  *  @param  locationBo      location过滤信息
    //  *  @param  circleBo        circle过滤信息
    //  *  @param  paginationBo    分页信息
    //  *
    //  *  @return 课程实体 CourseBo 列表
    //  *
    //  */ 
    // course.CoursePageViewBo queryCourseByFilter(1: course.CourseBo courseBo, 2: category.CategoryBo categoryBo, 3: location.LocationBo locationBo, 4: circle.CircleBo circleBo,5: common.PaginationBo paginationBo, 6: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)


    // /**
    //  *  本方法返回课程详情<br>
    //  *  合作商/管理员可以通过此方法调取课程详情
    //  *
    //  *  @param  courseBo     课程id
    //  *  @param  userBo       调用方法的用户的信息
    //  *
    //  *  @return  
    //  *
    //  */
    // course.CourseBo queryCourseById(1: course.CourseBo courseBo, 2: user.UserBo userBo, 3: string permissionTag) throws (1: fault.BusinessExceptionBo businessExceptionBo)

}

