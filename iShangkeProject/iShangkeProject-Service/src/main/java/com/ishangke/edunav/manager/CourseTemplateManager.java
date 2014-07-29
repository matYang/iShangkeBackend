package com.ishangke.edunav.manager;

import java.util.List;

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
    CourseTemplateBo createCourseTemplate(CourseTemplateBo courseTemplateBo, UserBo userBo);

    /**
     * 
     * @param courseTemplateBo
     * @param partnerBo
     * @param userBo
     * @return
     */
    CourseTemplateBo transformCourseTmeplateStatus(CourseTemplateBo courseTemplateBo, int operation, UserBo userBo);

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
    List<CourseTemplateBo> queryCourseTemplateByPartnerId(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo);
//    int queryCourseTemplateByPartnerIdTotal(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo);
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
    CourseTemplateBo queryCourseTemplateById(CourseTemplateBo courseTemplateBo, UserBo userBo);

}
