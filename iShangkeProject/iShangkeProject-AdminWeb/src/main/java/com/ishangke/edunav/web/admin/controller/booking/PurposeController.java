package com.ishangke.edunav.web.admin.controller.booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.PurposeCourseBo;
import com.ishangke.edunav.commoncontract.model.PurposeCoursePageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.admin.BookingFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.PurposeCourseConverter;
import com.ishangke.edunav.web.converter.pageview.PurposeCoursePageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.PurposeCourseVo;
import com.ishangke.edunav.web.model.pageview.PurposeCoursePageViewVo;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/a-api/v2/purpose")
public class PurposeController extends AbstractController {
    @Autowired
    private BookingFacade bookingFacade;
    
    @Autowired
    private UserFacade userFacade;
    
    @RequestMapping(value="",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody JsonResponse queryPurpose(PurposeCourseVo purposeVo,PaginationVo paginationVo,HttpServletRequest req,HttpServletResponse resp){
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = null;
        try{
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        }catch(ControllerException c){
            return this.handleWebException(c, resp);
        }
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if(!loggedIn){
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        
        PurposeCoursePageViewBo pageViewBo = null;
        PurposeCoursePageViewVo pageViewVo = null;
        try{
            pageViewBo = bookingFacade.queryPurpose(PurposeCourseConverter.fromModel(purposeVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        }catch(ControllerException c){
            return this.handleWebException(c, resp);
        }
        
        pageViewVo = PurposeCoursePageViewConverter.toModel(pageViewBo);
        return pageViewVo;
    }
    
    @RequestMapping(value="",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public @ResponseBody JsonResponse create(@RequestBody PurposeCourseVo purposeVo,HttpServletRequest req,HttpServletResponse resp){
        String permissionTag = this.getUrl(req);
        UserBo curUser = null;
        PurposeCourseBo targetPurpose = PurposeCourseConverter.fromModel(purposeVo);
        PurposeCourseBo responsePurpose = null;
        PurposeCourseVo responseVo = null;
        try {
            responsePurpose = bookingFacade.createPurpose(targetPurpose, curUser, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }
        responseVo =  PurposeCourseConverter.toModel(responsePurpose);
        return responseVo;
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.PUT,consumes="application/json",produces="application/json")
    public @ResponseBody JsonResponse update(@PathVariable("id") int id,@RequestBody PurposeCourseVo purposeVo,HttpServletRequest req,HttpServletResponse resp){
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if(!loggedIn){
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        
        purposeVo.setId(id);
        PurposeCourseBo targetPurpose= PurposeCourseConverter.fromModel(purposeVo);
        PurposeCourseBo responsePurpose = null;
        PurposeCourseVo responseVo = null;
        try {
            responsePurpose = bookingFacade.updatePurpose(targetPurpose, curUser, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }
        responseVo = PurposeCourseConverter.toModel(responsePurpose);
        return responseVo;
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE,consumes="application/json")
    public @ResponseBody JsonResponse delete(@PathVariable("id") int id,HttpServletRequest req,HttpServletResponse resp){
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }
        if(curUser.getId() <= 0){
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        
        PurposeCourseVo purposeVo = new PurposeCourseVo();
        purposeVo.setId(id);
        try {
            bookingFacade.deletePurpose(PurposeCourseConverter.fromModel(purposeVo), curUser, permissionTag);
        } catch (Exception e) {
            return this.handleWebException(e, resp);
        }
        return new EmptyResponse();
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody JsonResponse queryPurposeById(@PathVariable("id") int id,HttpServletRequest req,HttpServletResponse resp){
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }
        if(curUser.getId() <= 0){
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        PurposeCourseBo purposeCourseBo = null;
        try {
            purposeCourseBo = bookingFacade.queryPurposeById(id, curUser, permissionTag);
        } catch (Exception e) {
            return this.handleWebException(e, resp);
        }
        PurposeCourseVo purposeCourseVo = PurposeCourseConverter.toModel(purposeCourseBo);
        return purposeCourseVo;
    }

}
