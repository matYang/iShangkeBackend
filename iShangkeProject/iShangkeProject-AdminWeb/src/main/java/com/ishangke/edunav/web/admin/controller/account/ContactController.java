package com.ishangke.edunav.web.admin.controller.account;

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
import com.ishangke.edunav.facade.admin.AccountFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.ContactConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.ContactPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.ContactVo;
import com.ishangke.edunav.web.model.pageview.ContactPageViewVo;
import com.ishangke.edunav.web.response.EmptyResponse;

@Controller
@RequestMapping("/a-api/v2/contact")

public class ContactController extends AbstractController{

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    AccountFacade accountFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody ContactPageViewVo  queryContact(ContactVo contactVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        ContactPageViewBo pageViewBo = null;
        ContactPageViewVo pageViewVo = null;
        
        pageViewBo = accountFacade.queryContact(ContactConverter.fromModel(contactVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = ContactPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ContactVo create(@RequestBody ContactVo contactVo, HttpServletRequest req, HttpServletResponse resp) {
        ContactVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        
        ContactBo targetContact = ContactConverter.fromModel(contactVo);
        
        ContactBo responseContact = accountFacade.createContact(targetContact, curUser, permissionTag);
        responseVo = ContactConverter.toModel(responseContact);
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody ContactVo update(@PathVariable("id") int id, @RequestBody ContactVo contactVo, HttpServletRequest req, HttpServletResponse resp) {
        ContactVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        contactVo.setId(id);
        
        ContactBo targetContact = ContactConverter.fromModel(contactVo);
        ContactBo responseContact = accountFacade.updateContact(targetContact, curUser, permissionTag);
        responseVo = ContactConverter.toModel(responseContact);

        return responseVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,  produces = "application/json")
    public @ResponseBody EmptyResponse delete(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
          
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        ContactVo contactVo = new ContactVo();
        contactVo.setId(id);
        ContactBo targetContact = ContactConverter.fromModel(contactVo);
        
        accountFacade.deleteContact(targetContact, curUser, permissionTag);
        return new EmptyResponse();
     }
    
}
