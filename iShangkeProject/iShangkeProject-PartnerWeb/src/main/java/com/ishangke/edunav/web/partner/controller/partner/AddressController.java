package com.ishangke.edunav.web.partner.controller.partner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.AddressBo;
import com.ishangke.edunav.commoncontract.model.AddressPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.PartnerFacade;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.AddressConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.AddressPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.AddressVo;
import com.ishangke.edunav.web.model.pageview.AddressPageViewVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;
import com.ishangke.edunav.web.response.EmptyResponse;

@Controller
@RequestMapping("/p-api/v2/address")

public class AddressController extends AbstractController{
    @Autowired
    PartnerFacade partnerFacade;
    
    @Autowired
    UserFacade userFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody AddressPageViewVo  queryAddress(AddressVo addressVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }

        
        AddressPageViewBo pageViewBo = null;
        AddressPageViewVo pageViewVo = null;
        
        pageViewBo = partnerFacade.queryAddress(AddressConverter.fromModel(addressVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = AddressPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody AddressVo create(@RequestBody AddressVo addressVo, HttpServletRequest req, HttpServletResponse resp) {
        AddressVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        
        AddressBo targetAddress = AddressConverter.fromModel(addressVo);
        
        AddressBo responseAddress = partnerFacade.createAddress(targetAddress, curUser, permissionTag);
        responseVo = AddressConverter.toModel(responseAddress);
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody AddressVo update(@RequestBody AddressVo addressVo, HttpServletRequest req, HttpServletResponse resp) {
        AddressVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        
        AddressBo targetAddress = AddressConverter.fromModel(addressVo);
        
        AddressBo responseAddress = partnerFacade.updateAddress(targetAddress, curUser, permissionTag);
        responseVo = AddressConverter.toModel(responseAddress);
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
        
        AddressVo addressVo = new AddressVo();
        addressVo.setId(id);
        AddressBo targetAddress = AddressConverter.fromModel(addressVo);
        
        partnerFacade.deleteAddress(targetAddress, curUser, permissionTag);
        return new EmptyResponse();
    }
    
}
