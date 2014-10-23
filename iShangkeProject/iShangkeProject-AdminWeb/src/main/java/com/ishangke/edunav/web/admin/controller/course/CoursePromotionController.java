package com.ishangke.edunav.web.admin.controller.course;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.CoursePromotionBo;
import com.ishangke.edunav.commoncontract.model.CoursePromotionPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.admin.CourseFacade;
import com.ishangke.edunav.facade.admin.PartnerFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CoursePromotionConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.CoursePromotionPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CoursePromotionVo;
import com.ishangke.edunav.web.model.pageview.CoursePromotionPageViewVo;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/a-api/v2/coursePromotion")
public class  CoursePromotionController  extends AbstractController {
    
    @Autowired
    PartnerFacade partnerFacade;

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    CourseFacade courseFacade;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryCoursePromotion(CoursePromotionVo coursePromotionVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        CoursePromotionPageViewBo pageViewBo = null;
        CoursePromotionPageViewVo pageViewVo = null;
        try {
            pageViewBo = courseFacade.queryPromotion(CoursePromotionConverter.fromModel(coursePromotionVo), PaginationConverter.toBo(paginationVo));
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = CoursePromotionPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse create(@RequestBody CoursePromotionVo coursePromotionVo, HttpServletRequest req, HttpServletResponse resp) {
        CoursePromotionVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        CoursePromotionBo targetCoursePromotion = CoursePromotionConverter.fromModel(coursePromotionVo);
        CoursePromotionBo responseCoursePromotion = null;
        try {
            responseCoursePromotion = courseFacade.createPromotion(targetCoursePromotion, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = CoursePromotionConverter.toModel(responseCoursePromotion);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse update(@PathVariable("id") int id, @RequestBody CoursePromotionVo coursePromotionVo, HttpServletRequest req, HttpServletResponse resp) {
        CoursePromotionVo responseVo = null;

        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        coursePromotionVo.setId(id);
        CoursePromotionBo targetCoursePromotion = CoursePromotionConverter.fromModel(coursePromotionVo);
        CoursePromotionBo responseCoursePromotion = null;
        try {
            responseCoursePromotion = courseFacade.updatePromotion(targetCoursePromotion, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        responseVo = CoursePromotionConverter.toModel(responseCoursePromotion);
        return responseVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody JsonResponse delete(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        CoursePromotionVo coursePromotionVo = new CoursePromotionVo();
        coursePromotionVo.setId(id);
        CoursePromotionBo targetCoursePromotion = CoursePromotionConverter.fromModel(coursePromotionVo);

        try {
            courseFacade.deletePromotion(targetCoursePromotion, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        return new EmptyResponse();
    }

}
