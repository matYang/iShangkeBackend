package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.CategoryBo;
import com.ishangke.edunav.commoncontract.model.CircleBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseApproveBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseRejectBo;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.LocationBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
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
    public CourseBo createCourse(CourseTemplateBo courseTemplateBo, CourseBo courseBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为提交课程<br>
     * 合作商管理员可以通过此方法提交课程
     * 
     * @param courseBo
     *            需要被创建的课程信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseBo
     * @param partnerBo
     * @param userBo
     */
    public CourseBo submitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为审核通过课程<br>
     * ishangke管理员可以通过此方法审核通过课程
     * 
     * @param courseBo
     *            需要被审核的课程信息
     * @param partnerBo
     *            合作商信息
     * @param commentCourseApproveBo
     *            审核通过课程评论信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseBo
     * @param partnerBo
     * @param commentCourseApproveBo
     * @param userBo
     */
    public CourseBo approveCourse(CourseBo courseBo, PartnerBo partnerBo, CommentCourseApproveBo commentCourseApproveBo, UserBo userBo);

    /**
     * 本方法为审核不通过课程<br>
     * ishangke管理员可以通过此方法审核不通过课程
     * 
     * @param courseBo
     *            需要被审核的课程信息
     * @param partnerBo
     *            合作商信息
     * @param commentCourseApproveBo
     *            审核不通过课程评论信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseBo
     * @param partnerBo
     * @param commentCourseRejectBo
     * @param userBo
     */
    public CourseBo rejectCourse(CourseBo courseBo, PartnerBo partnerBo, CommentCourseRejectBo commentCourseRejectBo, UserBo userBo);

    /**
     * 本方法为下架课程<br>
     * 合作商管理员可以通过此方法下架课程
     * 
     * @param courseBo
     *            需要被下架的课程信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseBo
     * @param partnerBo
     * @param userBo
     */
    public CourseBo cancelCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为重新上架课程<br>
     * 合作商管理员可以通过此方法重新上架课程
     * 
     * @param courseBo
     *            需要被重新上架的课程信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseBo
     * @param partnerBo
     * @param userBo
     */
    public CourseBo resubmitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为删除课程<br>
     * 合作商管理员可以通过此方法删除已经下架的课程
     * 
     * @param courseeBo
     *            需要被删除的课程信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseBo
     * @param partnerBo
     * @param userBo
     */
    public CourseBo deleteCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为修改课程<br>
     * 合作商管理员可以通过此方法修改课程
     * 
     * @param courseBo
     *            需要被修改的课程信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseBo
     * @param partnerBo
     * @param userBo
     */
    public CourseBo updateCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为给课程评论<br>
     * 用户可以通过此方法给课程进行评论
     * 
     * @param courseBo
     *            需要被评论的课程信息
     * @param commentCourseBo
     *            课程评论信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return 课程评论实体 CommentCourseBo
     * 
     * 
     * @param courseBo
     * @param commentCourseBo
     * @param partnerBo
     * @param userBo
     */
    public CourseBo commentCourse(CourseBo courseBo, CommentCourseBo commentCourseBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为根据关键字查找课程<br>
     * 通过此方法可以直接过滤搜索出按Category查找的课程
     * 
     * @param String
     *            CategoryBo关键字
     * 
     * @return 课程实体 CourseBo 列表
     * 
     * 
     * @param keyword
     */
    public List<CourseBo> queryByKeyword(String keyword);

    /**
     * 本方法为合作商提供查询课程的功能。<br>
     * 合作商可以查询本机构已经提交过的课程，包括新建、正在审批、已上架、已下架的所有课程。
     * 
     * @param courseBo
     *            需要检索和过滤的课程信息
     * @param partnerBo
     *            合作商信息
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
    public List<CourseBo> queryByPartner(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo);

    /**
     * 本方法为用户查询课程的功能。<br>
     * 用户可以按照category，location，courseFilter查询所有课程
     * 
     * @param courseBo
     *            course过滤信息
     * @param categoryBo
     *            category过滤信息
     * @param locationBo
     *            location过滤信息
     * @param circleBo
     *            circle过滤信息
     * @param paginationBo
     *            分页信息
     * 
     * @return 课程实体 CourseBo 列表
     * 
     * 
     * @param courseBo
     * @param categoryBo
     * @param locationBo
     * @param circleBo
     * @param paginationBo
     */
    public List<CourseBo> queryByFilter(CourseBo courseBo, CategoryBo categoryBo, LocationBo locationBo, CircleBo circleBo, PaginationBo paginationBo);

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
    public CourseBo queryById(CourseBo courseBo, UserBo userBo);

}
