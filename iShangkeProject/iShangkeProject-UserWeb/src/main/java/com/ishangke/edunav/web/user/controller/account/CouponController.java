package com.ishangke.edunav.web.user.controller.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CouponPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.AccountFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CouponConverter;
import com.ishangke.edunav.web.converter.CouponHistoryConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.CouponHistoryPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.CouponPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.CouponHistoryVo;
import com.ishangke.edunav.web.model.CouponVo;
import com.ishangke.edunav.web.model.pageview.CouponHistoryPageViewVo;
import com.ishangke.edunav.web.model.pageview.CouponPageViewVo;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/coupon")

public class CouponController extends AbstractController{

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    AccountFacade accountFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryCoupon(CouponVo couponVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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
        if (couponVo.getUserId() == null || couponVo.getUserId() != curId) {
            return this.handleWebException(new ControllerException("对不起，您只能查看自己的积分信息"), resp);
        }
        
        CouponPageViewBo pageViewBo = null;
        CouponPageViewVo pageViewVo = null;
        try {
            pageViewBo = accountFacade.queryCoupon(CouponConverter.fromModel(couponVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);    
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        
        pageViewVo = CouponPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryCouponHistory(CouponHistoryVo couponHistoryVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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
        
        CouponHistoryPageViewBo pageViewBo = null;
        CouponHistoryPageViewVo pageViewVo = null;
        try {
            pageViewBo = accountFacade.queryCouponHistory(CouponHistoryConverter.fromModel(couponHistoryVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);    
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        } 
        pageViewVo = CouponHistoryPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse  queryCouponById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        
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
        
        CouponVo responseVo = null;
        CouponBo responseBo = null;
        try {
            responseBo = accountFacade.queryCouponById(id, curUser, permissionTag);   
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        
        responseVo = CouponConverter.toModel(responseBo);
        
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,  produces = "application/json")
    public @ResponseBody JsonResponse activate(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        CouponVo responseVo = null;
        
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
        
        CouponVo couponVo = new CouponVo();
        couponVo.setId(id);
        couponVo.setUserId(curId);
        CouponBo resultCoupon  = null;
        try {
            resultCoupon = accountFacade.activateCoupon(CouponConverter.fromModel(couponVo), curUser, permissionTag);    
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }  
        
        responseVo = CouponConverter.toModel(resultCoupon);
        return responseVo;
    }
}
