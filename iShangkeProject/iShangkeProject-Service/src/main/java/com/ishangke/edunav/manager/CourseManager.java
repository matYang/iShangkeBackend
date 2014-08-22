package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface CourseManager {
    /**
     * 本方法为创建新课程<br>
     * 合作商管理员可以通过此方法创建新课程
     * 
     * @param courseTemplateBo
     *            课程模版信息
     * @param courseBo
     *            需要被创建的课程信息
     * @param list
     *            <TeacherBo> 教师信息列表
     * @param locationBo
     *            地理位置信息
     * @param partnerBo
     *            合作商信息
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
    CourseBo createCourse(CourseBo courseBo, UserBo userBo);

    /**
     * 本方法为给课程评论<br>
     * 用户可以通过此方法给课程进行评论
     * 
     * @param courseBo
     *            需要被评论的课程信息
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
    CourseCommentBo commentCourse(CourseCommentBo courseCommnet, UserBo userBo);

    /**
     * 查询课程的评价
     * @param courseBo
     * @return
     */
    List<CourseCommentBo> queryCommentByCourseId(CourseBo courseBo, PaginationBo paginationBo);
    
    /**
     * 
     * @param courseBo
     * @return
     */
    int queryCommentByCourseIdTotal(CourseBo courseBo);
    
    /**
     * 删除课程的评价
     * @param CourseCommentBo
     * @param userBo
     * @return
     */
    CourseCommentBo deleteCommentByCommentId(CourseCommentBo courseCommentBo, UserBo userBo);
    
    
    
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
    List<CategoryBo> queryCategoryByKeyword(String keyword);
   
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
     * @return 课程实体 CourseBo 列表
     * 
     * 
     * @param courseBo
     * @param partnerBo
     * @param userBo
     * @param paginationBo
     */
    List<CourseBo> queryCourse(CourseBo courseBo, UserBo userBo, PaginationBo paginationBo);
    
    /**
     * 
     * @param courseBo
     * @param userBo
     * @return
     */
    int queryCourseTotal(CourseBo courseBo, UserBo userBo);
    
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
     * @return 课程实体 CourseBo 列表
     * 
     * 
     * @param courseBo
     * @param paginationBo
     */
    List<CourseBo> queryCourseByFilter(CourseBo courseBo, PaginationBo paginationBo);
    
    /**
     * 
     * @param courseBo
     * @return
     */
    int queryCourseByFilterTotal(CourseBo courseBo);
    
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
    CourseBo queryById(CourseBo courseBo, UserBo userBo);
    
    /**
     * 修改course状态
     * @param courseBo
     * @param operation
     * @param userBo
     * @return
     */
    CourseBo transformCourseStatus(CourseBo courseBo, int operation, UserBo userBo);
    
    List<CourseBo> listPromotionByCategoryId(int categoryId, PaginationBo paginationBo);
}
