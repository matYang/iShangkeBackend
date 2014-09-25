package com.ishangke.edunav.web.user.controller.booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.BookingFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.GroupBuyBookingConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.GroupBuyBookingPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.GroupBuyBookingVo;
import com.ishangke.edunav.web.model.pageview.GroupBuyBookingPageViewVo;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/groupBuy")
public class GroupBuyController extends AbstractController {
    @Autowired
    private BookingFacade bookingFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse createGroupBuyBooking(@RequestBody GroupBuyBookingVo groupBuyBooking, HttpServletRequest req, HttpServletResponse resp) {
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
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        groupBuyBooking.setUserId(curId);
        GroupBuyBookingBo targetGroupBuy = GroupBuyBookingConverter.fromModel(groupBuyBooking);
        GroupBuyBookingBo responseGroupBuy = null;
        GroupBuyBookingVo responseVo = null;
        try {
            responseGroupBuy = bookingFacade.createGroupBuyBooking(targetGroupBuy, curUser, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }
        responseVo = GroupBuyBookingConverter.toModel(responseGroupBuy);
        return responseVo;
    }
    
    @RequestMapping(value="",method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryGroupBuyBooking(HttpServletRequest req,HttpServletResponse resp,PaginationVo paginationVo,GroupBuyBookingVo groupBuyBookingVo) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        int curId = curUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        GroupBuyBookingPageViewBo pageViewBo = null;
        GroupBuyBookingPageViewVo pageViewVo = null;
        try {
            pageViewBo = bookingFacade.queryGroupBuyBooking(GroupBuyBookingConverter.fromModel(groupBuyBookingVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = GroupBuyBookingPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }
}
