package com.ishangke.edunav.web.partner.controller.course;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
import com.ishangke.edunav.commoncontract.model.CourseTemplatePageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.CourseFacade;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CourseTemplateConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.converter.pageview.CourseTemplatePageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CourseTemplateVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.model.pageview.CourseTemplatePageViewVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/p-api/v2/courseTemplate")

public class CourseTemplateController extends AbstractController{
    
    @Autowired
    CourseFacade courseFacade;
    
    @Autowired
    UserFacade userFacade;
    

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryCourseTemplate(CourseTemplateVo courseTemplateVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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
        
        CourseTemplatePageViewBo pageViewBo = null;
        CourseTemplatePageViewVo pageViewVo = null;
        
        try {
            int partnerId = userFacade.getPartnerIdByUserId(curId);
            courseTemplateVo.setPartnerId(partnerId);
            pageViewBo = courseFacade.queryCourseTemplate (CourseTemplateConverter.fromModel(courseTemplateVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        pageViewVo = CourseTemplatePageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryCourseTemplateById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
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
        
        CourseTemplateVo courseTemplateVo = new CourseTemplateVo();
        courseTemplateVo.setId(id);
        CourseTemplateBo responseBo = null;
        CourseTemplateVo responseVo = null;
        
        try {
            int partnerId = userFacade.getPartnerIdByUserId(curId);
            courseTemplateVo.setPartnerId(partnerId);
            responseBo = courseFacade.queryCourseTemplateById(CourseTemplateConverter.fromModel(courseTemplateVo), curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        responseVo = CourseTemplateConverter.toModel(responseBo);
        
        return responseVo;
    }
    
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse create(@RequestBody CourseTemplateVo courseTemplateVo, HttpServletRequest req, HttpServletResponse resp) {
        CourseTemplateVo responseVo = null;
        
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
        
        
        CourseTemplateBo targetCourseTemplate = CourseTemplateConverter.fromModel(courseTemplateVo);
        CourseTemplateBo responseCourseTemplate = null; 
        try {
            int partnerId = userFacade.getPartnerIdByUserId(curId);
            targetCourseTemplate.setPartnerId(partnerId);
            responseCourseTemplate = courseFacade.createCourseTemplate(targetCourseTemplate, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        responseVo = CourseTemplateConverter.toModel(responseCourseTemplate);
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}/{operate}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse transformCourseTemplate(@PathVariable("id") int id, @RequestBody CourseTemplateVo courseTemplate, @PathVariable String operate, HttpServletRequest req, HttpServletResponse resp) {
        CourseTemplateVo responseVo = null;
        
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
        
        //course template operation is same as course opration
        Integer operationObj = Constant.COURSEOPERATEMAP.get(operate);
        if (operationObj == null) {
            return this.handleWebException(new ControllerException("This courseTemplate operation is not defined!"), resp);
        }

        courseTemplate.setId(id);
        int operation = operationObj;
        CourseTemplateBo courseTemplateBo = null;
        try {
            int partnerId = userFacade.getPartnerIdByUserId(curId);
            courseTemplate.setPartnerId(partnerId);
            courseTemplateBo = courseFacade.transformCourseTemplateStatus(CourseTemplateConverter.fromModel(courseTemplate), operation, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        responseVo = CourseTemplateConverter.toModel(courseTemplateBo);
        return responseVo;
    }
    
}
