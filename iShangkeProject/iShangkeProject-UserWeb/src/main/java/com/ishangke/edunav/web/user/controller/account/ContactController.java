package com.ishangke.edunav.web.user.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.ContactBo;
import com.ishangke.edunav.commoncontract.model.ContactPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.AccountFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.ContactConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.ContactPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.ContactVo;
import com.ishangke.edunav.web.model.pageview.ContactPageViewVo;
import com.ishangke.edunav.web.response.EmptyResponse;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/contact")

public class ContactController extends AbstractController{

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    AccountFacade accountFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryContact(ContactVo contactVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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
        //user module specific, also need to perform null check
        if (contactVo.getUserId() == null || contactVo.getUserId() != curId) {
            return this.handleWebException(new ControllerException("对不起，您只能查看自己的联系人信息"), resp);
        }
        
        ContactPageViewBo pageViewBo = null;
        ContactPageViewVo pageViewVo = null;
        try {
            pageViewBo = accountFacade.queryContact(ContactConverter.fromModel(contactVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);    
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        
        pageViewVo = ContactPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse create(@RequestBody ContactVo contactVo, HttpServletRequest req, HttpServletResponse resp) {
        ContactVo responseVo = null;
        
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
        
        if (contactVo.getUserId() == null || contactVo.getUserId() != curId) {
            return this.handleWebException(new ControllerException("对不起，您只能创建自己的联系人信息"), resp);
        }
        
        
        ContactBo targetContact = ContactConverter.fromModel(contactVo);
        
        ContactBo responseContact = null;
        try {
            responseContact = accountFacade.createContact(targetContact, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        responseVo = ContactConverter.toModel(responseContact);
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse update(@PathVariable("id") int id, @RequestBody ContactVo contactVo, HttpServletRequest req, HttpServletResponse resp) {
        ContactVo responseVo = null;
        
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
        
        contactVo.setId(id);
        if (contactVo.getUserId() == null || contactVo.getUserId() != curId) {
            return this.handleWebException(new ControllerException("对不起，您只能创建自己的联系人信息"), resp);
        }
        
        
        ContactBo targetContact = ContactConverter.fromModel(contactVo);
        
        ContactBo responseContact = null;
        try {
            responseContact = accountFacade.updateContact(targetContact, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        responseVo = ContactConverter.toModel(responseContact);
        return responseVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,  produces = "application/json")
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
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }
        
        ContactVo contactVo = new ContactVo();
        contactVo.setId(id);
        ContactBo targetContact = ContactConverter.fromModel(contactVo);
        try {
            accountFacade.deleteContact(targetContact, curUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        return new EmptyResponse();
     }
    
}
