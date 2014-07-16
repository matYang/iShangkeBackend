package com.ishangke.edunav.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.ishangke.edunav.commoncontract.model.PhotoBo;
import com.ishangke.edunav.commoncontract.model.TeacherBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.manager.CourseManager;

public class CourseManagerImpl implements CourseManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseManagerImpl.class);
    
    @Override
    public CourseBo createCourse(CourseTemplateBo courseTemplateBo, CourseBo courseBo, List<TeacherBo> listTeacherBo, List<PhotoBo> listPhotoBo, LocationBo locationBo, PartnerBo partnerBo,
            UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo submitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo approveCourse(CourseBo courseBo, PartnerBo partnerBo, CommentCourseApproveBo commentCourseApproveBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo rejectCourse(CourseBo courseBo, PartnerBo partnerBo, CommentCourseRejectBo commentCourseRejectBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo cancelCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo resubmitCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo deleteCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo updateCourse(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo commentCourse(CourseBo courseBo, CommentCourseBo commentCourseBo, PartnerBo partnerBo, UserBo userBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo queryByKeyword(String keyword) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo queryByPartner(CourseBo courseBo, PartnerBo partnerBo, UserBo userBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseBo queryByFilter(CourseBo courseBo, CategoryBo categoryBo, LocationBo locationBo, CircleBo circleBo, PaginationBo paginationBo) {
        // TODO Auto-generated method stub
        return null;
    }

}
