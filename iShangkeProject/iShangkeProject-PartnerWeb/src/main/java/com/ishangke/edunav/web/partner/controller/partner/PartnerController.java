package com.ishangke.edunav.web.partner.controller.partner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.commoncontract.model.PartnerPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.partner.PartnerFacade;
import com.ishangke.edunav.facade.partner.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.PartnerConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.converter.pageview.PartnerPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.PartnerVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.model.pageview.PartnerPageViewVo;
import com.ishangke.edunav.web.partner.controller.AbstractController;

@Controller
@RequestMapping("/p-api/v2/partner")

public class PartnerController extends AbstractController{
    
    @Autowired
    UserFacade userFacade;

    @Autowired
    PartnerFacade partnerFacade;
    
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody PartnerPageViewVo  queryPartner(PartnerVo partnerVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }

        PartnerPageViewBo pageViewBo = null;
        PartnerPageViewVo pageViewVo = null;
        
        pageViewBo = partnerFacade.queryPartner(PartnerConverter.fromModel(partnerVo), PaginationConverter.toBo(paginationVo), curUser, permissionTag);
        pageViewVo = PartnerPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    
    //get partner by id is open data, no authentication
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody PartnerVo  queryPartnerById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        PartnerVo partnerVo = new PartnerVo();
        partnerVo.setId(id);
        PartnerBo responseBo = null;
        PartnerVo responseVo = null;
        
        responseBo = partnerFacade.queryPartnerById(PartnerConverter.fromModel(partnerVo), UserConverter.fromModel(new UserVo()), permissionTag);
        responseVo = PartnerConverter.toModel(responseBo);
        
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody PartnerVo update(@PathVariable("id") int partnerId, @RequestBody PartnerVo partnerVo, HttpServletRequest req, HttpServletResponse resp) {
        PartnerVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        PartnerBo targetPartner = PartnerConverter.fromModel(partnerVo);
        targetPartner.setId(partnerId);
        
        PartnerBo responsePartner = partnerFacade.updatePartner(targetPartner, curUser, permissionTag);
        responseVo = PartnerConverter.toModel(responsePartner);
        return responseVo;
    }
    
    
    
    @RequestMapping(value = "/{id}/logo", method = RequestMethod.PUT)
    public @ResponseBody PartnerVo uploadLogo(@RequestParam("file") MultipartFile file, HttpServletRequest req) {
        //TODO receive the image file, process it, upload to OCS, update partner with url, return the latest partner
        return new PartnerVo();
    }
    

}
