package com.ishangke.edunav.manager;

import java.util.List;

public interface CourseCommentManager {
    /**
     * 创建课程评论。<br>
     * 用户可以创建课程评论
     * 
     * @param  courseCommentBo    需要创建的课程评论
     * @param  courseTemplateBo   评论相关的课程模板
     * @param  userBo             发起创建的用户信息
     * 
     * @return 创建完成的课程评论
     * 
     * 
     * @param courseCommentBo
     * @param courseTemplateBo
     * @param userBo
     */
    public com.ishangke.edunav.commoncontract.model.CourseCommentBo createCourseComment(com.ishangke.edunav.commoncontract.model.CourseCommentBo courseCommentBo, com.ishangke.edunav.commoncontract.model.CourseTemplateBo courseTemplateBo, com.ishangke.edunav.commoncontract.model.UserBo userBo) throws com.ishangke.edunav.commoncontract.model.BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 删除课程评论。<br>
     * 用户可以删除课程评论
     * 
     * @param  courseCommentBo    需要删除的课程评论
     * @param  courseTemplateBo   评论相关的课程模板
     * @param  userBo             发起删除的用户信息
     * 
     * @return
     * 
     * 
     * @param courseCommentBo
     * @param courseTemplateBo
     * @param userBo
     */
    public com.ishangke.edunav.commoncontract.model.CourseCommentBo deleteCourseComment(com.ishangke.edunav.commoncontract.model.CourseCommentBo courseCommentBo, com.ishangke.edunav.commoncontract.model.CourseTemplateBo courseTemplateBo, com.ishangke.edunav.commoncontract.model.UserBo userBo) throws com.ishangke.edunav.commoncontract.model.BusinessExceptionBo, org.apache.thrift.TException;

    /**
     * 查询课程评论。<br>
     * 用户可以查询课程评论
     * 
     * @param  courseCommentBo    需要查询的课程评论
     * @param  courseTemplateBo   评论相关的课程模板
     * @param  userBo             发起查询的用户信息
     * @param  paginationBo       分页信息
     * 
     * @return  CourseComment 列表
     * 
     * 
     * @param courseCommentBo
     * @param courseTemplateBo
     * @param userBo
     * @param paginationBo
     */
    public List<com.ishangke.edunav.commoncontract.model.CourseCommentBo> query(com.ishangke.edunav.commoncontract.model.CourseCommentBo courseCommentBo, com.ishangke.edunav.commoncontract.model.CourseTemplateBo courseTemplateBo, com.ishangke.edunav.commoncontract.model.UserBo userBo, com.ishangke.edunav.commoncontract.model.PaginationBo paginationBo) throws com.ishangke.edunav.commoncontract.model.BusinessExceptionBo, org.apache.thrift.TException;

}
