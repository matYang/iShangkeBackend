package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateApproveBo;
import com.ishangke.edunav.commoncontract.model.CommentCourseTemplateRejectBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.manager.CourseTemplateManager;

public class CourseTemplateManagerImpl implements CourseTemplateManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseTemplateManagerImpl.class);

    @Override
    public CourseTemplateBo createCourseTemplateBo(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseTemplateBo submitCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseTemplateBo approveCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, CommentCourseTemplateApproveBo commentCourseTemplateApproveBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseTemplateBo rejectCourseTemplate(CourseTemplateBo courseTemplateBo, CommentCourseTemplateRejectBo commentCourseTemplateRejectBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseTemplateBo cancelCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseTemplateBo resubmitCourserTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseTemplateBo deleteCourseTempalte(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseTemplateBo updateCourseTemplate(CourseTemplateBo courseTemplateBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CourseTemplateBo> queryCourseTempalte(CourseTemplateBo courseTemplateBo, UserBo userBo, PartnerBo partnerBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CourseTemplateBo> queryCourseTempalteById(CourseTemplateBo courseTemplateBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

}
