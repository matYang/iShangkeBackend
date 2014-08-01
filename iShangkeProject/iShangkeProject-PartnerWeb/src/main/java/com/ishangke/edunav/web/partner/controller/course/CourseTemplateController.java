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

@Controller
@RequestMapping("/p-api/v2/courseTemplateTemplate")

public class CourseTemplateController extends AbstractController{
    
    @Autowired
    CourseFacade courseFacade;
    
    @Autowired
    UserFacade userFacade;
    

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CourseTemplatePageViewVo  queryCourseTemplate(CourseTemplateVo courseTemplateVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        CourseTemplatePageViewBo pageViewBo = null;
        CourseTemplatePageViewVo pageViewVo = null;
        
        pageViewBo = courseFacade.queryCourseTemplate (CourseTemplateConverter.fromModel(courseTemplateVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = CourseTemplatePageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CourseTemplateVo  queryCourseTemplateById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        CourseTemplateVo courseTemplateVo = new CourseTemplateVo();
        courseTemplateVo.setId(id);
        CourseTemplateBo responseBo = null;
        CourseTemplateVo responseVo = null;
        
        responseBo = courseFacade.queryCourseTemplateById(CourseTemplateConverter.fromModel(courseTemplateVo), UserConverter.fromModel(new UserVo()), permissionTag);
        responseVo = CourseTemplateConverter.toModel(responseBo);
        
        return responseVo;
    }
    
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody CourseTemplateVo create(@RequestBody CourseTemplateVo courseTemplateVo, HttpServletRequest req, HttpServletResponse resp) {
        CourseTemplateVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        
        CourseTemplateBo targetCourseTemplate = CourseTemplateConverter.fromModel(courseTemplateVo);
        
        CourseTemplateBo responseCourseTemplate = courseFacade.createCourseTemplate(targetCourseTemplate, curUser, permissionTag);
        responseVo = CourseTemplateConverter.toModel(responseCourseTemplate);
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}/{operate}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody CourseTemplateVo transformCourseTemplate(@RequestBody CourseTemplateVo courseTemplate, @PathVariable String operate, HttpServletRequest req, HttpServletResponse resp) {
        CourseTemplateVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        Integer operationObj = Constant.COURSEOPERATEMAP.get(operate);
        if (operationObj == null) {
            throw new ControllerException("This courseTemplate operation is not defined!");
        }

        int operation = operationObj;
        CourseTemplateBo courseTemplateBo = courseFacade.transformCourseTemplateStatus(CourseTemplateConverter.fromModel(courseTemplate), operation, curUser, permissionTag);
        responseVo = CourseTemplateConverter.toModel(courseTemplateBo);
        return responseVo;
    }
    
}
