package com.ishangke.edunav.web.partner.controller.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CourseCommentPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.CourseFacade;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CourseConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.CourseCommentPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CourseCommentVo;
import com.ishangke.edunav.web.model.CourseVo;
import com.ishangke.edunav.web.model.pageview.CourseCommentPageViewVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;
import com.ishangke.edunav.web.response.JsonResponse;


@Controller
@RequestMapping("/p-api/v2/comment")

public class CommentController extends AbstractController{

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    CourseFacade courseFacade;
    
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryCourseComment(CourseCommentVo courseCommentVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        
        CourseCommentPageViewBo pageViewBo = null;
        CourseCommentPageViewVo pageViewVo = null;
        
        CourseVo courseVo = new CourseVo();
        courseVo.setCourseTemplateId(courseCommentVo.getCourseTemplateId());
        CourseBo targetCourse = CourseConverter.fromModel(courseVo);
        try {
            int partnerId = userFacade.getPartnerIdByUserId(curId);
            targetCourse.setPartnerId(partnerId);
            pageViewBo = courseFacade.queryCommentByCourseId(targetCourse, PaginationConverter.toBo(paginationVo), permissionTag);    
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = CourseCommentPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
}
