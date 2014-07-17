include "model/fault.thrift"
include "model/common.thrift"
include "model/courseTemplate.thrift"
include "model/user.thrift"
include "model/courseComment.thrift"

namespace java com.ishangke.edunav.commoncontract.service

service CourseCommentService {

	/**
     *  创建课程评论。<br>
     *  用户可以创建课程评论
     *
     *  @param  courseCommentBo    需要创建的课程评论
     *  @param  courseTemplateBo   评论相关的课程模板
     *  @param  userBo             发起创建的用户信息
     *
     *  @return 创建完成的课程评论
     *
     */
    courseComment.CourseCommentBo createCourseComment(1: courseComment.CourseCommentBo courseCommentBo, 2: courseTemplate.CourseTemplateBo courseTemplateBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  删除课程评论。<br>
     *  用户可以删除课程评论
     *
     *  @param  courseCommentBo    需要删除的课程评论
     *  @param  courseTemplateBo   评论相关的课程模板
     *  @param  userBo             发起删除的用户信息
     *
     *  @return 
     *
     */
    courseComment.CourseCommentBo deleteCourseComment(1: courseComment.CourseCommentBo courseCommentBo, 2: courseTemplate.CourseTemplateBo courseTemplateBo, 3: user.UserBo userBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
    
    /**
     *  查询课程评论。<br>
     *  用户可以查询课程评论
     *
     *  @param  courseCommentBo    需要查询的课程评论
     *  @param  courseTemplateBo   评论相关的课程模板
     *  @param  userBo             发起查询的用户信息
     *  @param  paginationBo       分页信息
     *
     *  @return  CourseComment 列表
     *
     */
    list<courseComment.CourseCommentBo> query(1: courseComment.CourseCommentBo courseCommentBo, 2: courseTemplate.CourseTemplateBo courseTemplateBo, 3: user.UserBo userBo, 4: common.PaginationBo paginationBo) throws (1: fault.BusinessExceptionBo businessExceptionBo)
	


}