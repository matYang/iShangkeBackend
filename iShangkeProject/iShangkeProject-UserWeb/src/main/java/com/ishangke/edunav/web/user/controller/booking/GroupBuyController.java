package com.ishangke.edunav.web.user.controller.booking;

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

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyActivityPageViewBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingBo;
import com.ishangke.edunav.commoncontract.model.GroupBuyBookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.AlipayFacade;
import com.ishangke.edunav.facade.user.BookingFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.GroupBuyActivityConverter;
import com.ishangke.edunav.web.converter.GroupBuyBookingConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.GroupBuyActivityPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.GroupBuyBookingPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.map.GroupBuyActivityMap;
import com.ishangke.edunav.web.map.GroupBuyBookingMap;
import com.ishangke.edunav.web.model.GroupBuyActivityVo;
import com.ishangke.edunav.web.model.GroupBuyBookingVo;
import com.ishangke.edunav.web.model.pageview.GroupBuyActivityPageViewVo;
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
    
    @Autowired
    private AlipayFacade alipayFacade;

    @RequestMapping(value = "/booking", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
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
    public @ResponseBody JsonResponse queryGroupBuyActivity(GroupBuyActivityVo groupBuyActivityVo,
    		PaginationVo paginationVo,
    		HttpServletRequest req,
    		HttpServletResponse resp) {

        GroupBuyActivityPageViewBo pageViewBo = null;
        GroupBuyActivityPageViewVo pageViewVo = null;
        paginationVo.setColumnKey(GroupBuyActivityMap.GROUPBUYACTIVITY_MAP.get(paginationVo.getColumnKey()));
        paginationVo.setOrder(GroupBuyActivityMap.GROUPBUYACTIVITY_MAP.get(paginationVo.getOrder()));
        groupBuyActivityVo.setStatus(Constant.GROUPBUYACTIVITYONLINE);
        try {
            pageViewBo = bookingFacade.queryGroupBuyActivity(GroupBuyActivityConverter.fromModel(groupBuyActivityVo), PaginationConverter.toBo(paginationVo));
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = GroupBuyActivityPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryGroupBuyActivityById(@PathVariable int id, 
    		HttpServletRequest req, HttpServletResponse resp) {

        GroupBuyActivityBo groupBuyActivityBo = null;
        try {
            groupBuyActivityBo = bookingFacade.queryGroupBuyActivityById(id);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        GroupBuyActivityVo groupBuyActivityVo = GroupBuyActivityConverter.toModel(groupBuyActivityBo);
        return groupBuyActivityVo;
    }
    
    @RequestMapping(value="/booking",method = RequestMethod.GET, produces = "application/json")
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
        paginationVo.setColumnKey(GroupBuyBookingMap.GROUPBUYBOOKING_MAP.get(paginationVo.getColumnKey()));
        paginationVo.setOrder(GroupBuyBookingMap.GROUPBUYBOOKING_MAP.get(paginationVo.getOrder()));
        try {
            pageViewBo = bookingFacade.queryGroupBuyBooking(GroupBuyBookingConverter.fromModel(groupBuyBookingVo), curUser, PaginationConverter.toBo(paginationVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        pageViewVo = GroupBuyBookingPageViewConverter.toModel(pageViewBo);

        return pageViewVo;
    }
    
    @RequestMapping(value = "/booking/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse queryGroupBuyBookingById(@PathVariable int id, HttpServletRequest req, HttpServletResponse resp) {
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

        GroupBuyBookingBo groupBuyBookingBo = null;
        try {
            groupBuyBookingBo = bookingFacade.queryGroupBuyBookingById(id, currentUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        GroupBuyBookingVo groupBuyBookingVo = GroupBuyBookingConverter.toModel(groupBuyBookingBo);
        return groupBuyBookingVo;
    }
    
    @RequestMapping(value = "/{bookingId}/pay", method = RequestMethod.GET, produces = { "text/html;charset=UTF-8" })
    public @ResponseBody String buildForm(@PathVariable int bookingId, @RequestParam(defaultValue = "alipay") String type, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = null;
        try {
            currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            resp.setStatus(511);
            return "服务器发生异常，不能验证当前用户的身份";
        }
        int curId = currentUser.getId();
        boolean loggedIn = curId > 0;
        if (!loggedIn) {
            return "对不起，您尚未登录";
        }

        GroupBuyBookingBo booking = bookingFacade.queryGroupBuyBookingById(bookingId, currentUser, permissionTag);
        GroupBuyActivityBo activity = bookingFacade.queryGroupBuyActivityById(booking.getGroupBuyActivityId());

        String result = alipayFacade.buildFormForGet(booking.getReference(), activity.getTitle(), String.valueOf(booking.getGroupBuyPrice()), type);
        return result;
    } 
}
