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

import com.ishangke.edunav.commoncontract.model.CouponBo;
import com.ishangke.edunav.commoncontract.model.CouponHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.CouponPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.admin.AccountFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
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

@Controller
@RequestMapping("/a-api/v2/coupon")

public class CouponController extends AbstractController{

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    AccountFacade accountFacade;
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CouponPageViewVo  queryCoupon(CouponVo couponVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        CouponPageViewBo pageViewBo = null;
        CouponPageViewVo pageViewVo = null;
        
        pageViewBo = accountFacade.queryCoupon(CouponConverter.fromModel(couponVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = CouponPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    @RequestMapping(value = "/history", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CouponHistoryPageViewVo  queryCouponHistory(CouponHistoryVo couponHistoryVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        CouponHistoryPageViewBo pageViewBo = null;
        CouponHistoryPageViewVo pageViewVo = null;
        
        pageViewBo = accountFacade.queryCouponHistory(CouponHistoryConverter.fromModel(couponHistoryVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        pageViewVo = CouponHistoryPageViewConverter.toModel(pageViewBo);
        
        return pageViewVo;
    }
    
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody CouponVo  queryCouponById(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        CouponVo responseVo = null;
        CouponBo responseBo = null;
        
        responseBo = accountFacade.queryCouponById(id, curUser, permissionTag);
        responseVo = CouponConverter.toModel(responseBo);
        
        return responseVo;
    }
    
    @RequestMapping(value = "/{id}/activate", method = RequestMethod.GET,  produces = "application/json")
    public @ResponseBody CouponVo activate(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) {
        CouponVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        CouponVo couponVo = new CouponVo();
        couponVo.setId(id);
        
        CouponBo resultCoupon = accountFacade.activateCoupon(CouponConverter.fromModel(couponVo), curUser, permissionTag);
        responseVo = CouponConverter.toModel(resultCoupon);
        return responseVo;
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody CouponVo create(@RequestBody CouponVo CouponVo, HttpServletRequest req, HttpServletResponse resp) {
        CouponVo responseVo = null;
        
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        
        UserBo curUser = userFacade.authenticate(authSessionBo, permissionTag);
        int curId = curUser.getId();
        boolean loggedIn =  curId > 0;
        if (!loggedIn) {
            throw new ControllerException("对不起，您尚未登录");
        }
        
        
        CouponBo targetCoupon = CouponConverter.fromModel(CouponVo);
        CouponBo responseCoupon = accountFacade.createCoupon(targetCoupon, curUser, permissionTag);
        responseVo = CouponConverter.toModel(responseCoupon);
        return responseVo;
    }
    
}
