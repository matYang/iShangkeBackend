package com.ishangke.edunav.manager;

import java.util.List;

import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateApproveBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateRejectBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;

public interface CourseTemplateManager {
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
    CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为提交课程模版<br>
     * 合作商管理员可以通过此方法提交课程模版
     * 
     * @param courseTemplateBo
     *            需要被创建的课程模版信息
     * @param partnerBo
     *            合作商信息
     * @param UserBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseTemplateBo
     * @param partnerBo
     * @param userBo
     */
    CourseTemplateBo submitCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为审核通过课程模版<br>
     * ishangke管理员可以通过此方法审核通过课程模版
     * 
     * @param courseTemplateBo
     *            需要被审核的课程模版信息
     * @param partnerBo
     *            合作商信息
     * @param commentTemplateApproveBo   $
     *            审核通过课程模版评论信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseTemplateBo
     * @param partnerBo
     * @param commentCourseTemplateApproveBo
     * @param userBo
     */
    CourseTemplateBo approveCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, CommentCourseTemplateApproveBo commentCourseTemplateApproveBo, UserBo userBo)
           ;

    /**
     * 本方法为审核不通过课程模版<br>
     * ishangke管理员可以通过此方法审核不通过课程模版
     * 
     * @param courseTemplateBo
     *            需要被审核的课程模版信息
     * @param partnerBo
     *            合作商信息
     * @param commentTemplateApproveBo   $
     *            审核不通过课程模版评论信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseTemplateBo
     * @param commentCourseTemplateRejectBo
     * @param partnerBo
     * @param userBo
     */
    CourseTemplateBo rejectCourseTemplate(CourseTemplateBo courseTemplateBo, CommentCourseTemplateRejectBo commentCourseTemplateRejectBo, PartnerBo partnerBo, UserBo userBo)
           ;

    /**
     * 本方法为下架课程模版<br>
     * 合作商管理员可以通过此方法下架课程模版
     * 
     * @param courseTemplateBo
     *            需要被下架的课程模版信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseTemplateBo
     * @param partnerBo
     * @param userBo
     */
    CourseTemplateBo cancelCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为重新上架课程模版<br>
     * 合作商管理员可以通过此方法重新上架课程模版
     * 
     * @param courseTemplateBo
     *            需要被重新上架的课程模版信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseTemplateBo
     * @param partnerBo
     * @param userBo
     */
    CourseTemplateBo resubmitCourserTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为删除课程模版<br>
     * 合作商管理员可以通过此方法删除已经下架的课程模版
     * 
     * @param courseTemplateBo
     *            需要被删除的课程模版信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseTemplateBo
     * @param partnerBo
     * @param userBo
     */
    CourseTemplateBo deleteCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo);

    /**
     * 本方法为修改课程模版<br>
     * 合作商管理员可以通过此方法修改课程模版
     * 
     * @param courseTemplateBo
     *            需要被修改的课程模版信息
     * @param partnerBo
     *            合作商信息
     * @param userBo
     *            调用方法的用户的信息
     * 
     * @return
     * 
     * 
     * @param courseTemplateBo
     * @param partnerBo
     * @param userBo
     */
    CourseTemplateBo updateCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo);

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
    List<CourseTemplateBo> queryCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo, PartnerBo partnerBo, PaginationBo paginationBo);

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
    List<CourseTemplateBo> queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo);

}
