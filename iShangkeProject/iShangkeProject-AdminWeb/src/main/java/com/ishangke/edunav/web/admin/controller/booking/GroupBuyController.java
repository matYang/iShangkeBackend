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

import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.admin.BookingFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.GroupBuyActivityConverter;
import com.ishangke.edunav.web.converter.GroupBuyBookingConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.GroupBuyBookingPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.GroupBuyActivityVo;
import com.ishangke.edunav.web.model.GroupBuyBookingVo;
import com.ishangke.edunav.web.model.pageview.GroupBuyBookingPageViewVo;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/a-api/v2/groupBuy")
public class GroupBuyController extends AbstractController {
    @Autowired
    private BookingFacade bookingFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse createGroupBuyActivity(@RequestBody GroupBuyActivityVo groupBuyActivity, HttpServletRequest req, HttpServletResponse resp) {
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
        GroupBuyActivityBo tartgetGroupBuy = GroupBuyActivityConverter.fromModel(groupBuyActivity);
        GroupBuyActivityBo responseGroupBuy = null;
        GroupBuyActivityVo responseVo = null;
        try {
            responseGroupBuy = bookingFacade.createGroupBuyActivity(tartgetGroupBuy, curUser, permissionTag);
        } catch (Exception e) {
            return this.handleWebException(e, resp);
        }
        responseVo = GroupBuyActivityConverter.toModel(responseGroupBuy);
        return responseVo;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryGroupBuyBooking(GroupBuyBookingVo groupBuyBookingVo, PaginationVo paginationVo, HttpServletRequest req, HttpServletResponse resp) {
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

    @RequestMapping(value = "/{id}/online", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse online(@PathVariable("id") int id, @RequestBody GroupBuyActivityVo grouBuyActivityVo, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);

        UserBo curUser = null;
        try {
            curUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }

        grouBuyActivityVo.setId(id);
        GroupBuyActivityBo bo = null;
        GroupBuyActivityVo vo = null;
        try {
            bo = bookingFacade.online(GroupBuyActivityConverter.fromModel(grouBuyActivityVo), curUser, permissionTag);
        } catch (ControllerException e) {
            return this.handleWebException(e, resp);
        }
        vo = GroupBuyActivityConverter.toModel(bo);
        return vo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryGroupBuyActivityById(@PathVariable int id, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = null;
        try {
            currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        int curId = currentUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
        }

        GroupBuyActivityBo groupBuyActivityBo = null;
        try {
            groupBuyActivityBo = bookingFacade.queryGroupBuyActivityById(id, currentUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        GroupBuyActivityVo groupBuyActivityVo = GroupBuyActivityConverter.toModel(groupBuyActivityBo);
        return groupBuyActivityVo;
    }
}
