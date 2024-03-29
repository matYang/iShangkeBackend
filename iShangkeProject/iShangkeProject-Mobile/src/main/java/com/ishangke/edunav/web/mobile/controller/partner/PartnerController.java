package com.ishangke.edunav.web.mobile.controller.partner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.PartnerBo;
import com.ishangke.edunav.facade.user.PartnerFacade;
import com.ishangke.edunav.web.converter.PartnerConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.PartnerVo;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.mobile.controller.AbstractController;


@Controller
@RequestMapping("/api/v2/partner")

public class PartnerController extends AbstractController{
    
    @Autowired
    PartnerFacade partnerFacade;
    
    //get partner by id is open data
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryPartnerById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        
        PartnerVo partnerVo = new PartnerVo();
        partnerVo.setId(id);
        PartnerBo responseBo = null;
        PartnerVo responseVo = null;
        try {
            responseBo = partnerFacade.queryPartnerById(PartnerConverter.fromModel(partnerVo), UserConverter.fromModel(new UserVo()), permissionTag);            
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        responseVo = PartnerConverter.toModel(responseBo);
        
        return responseVo;
    }

}
