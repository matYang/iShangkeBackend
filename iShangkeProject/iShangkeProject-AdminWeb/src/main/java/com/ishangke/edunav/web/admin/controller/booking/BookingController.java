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

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.BookingHistoryPageViewBo;
import com.ishangke.edunav.commoncontract.model.BookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.admin.BookingFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.BookingConverter;
import com.ishangke.edunav.web.converter.BookingHistoryConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.BookingHistoryPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.BookingPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.BookingHistoryVo;
import com.ishangke.edunav.web.model.BookingVo;
import com.ishangke.edunav.web.model.pageview.BookingHistoryPageViewVo;
import com.ishangke.edunav.web.model.pageview.BookingPageViewVo;
import com.ishangke.edunav.web.response.JsonResponse;

@Controller
@RequestMapping("/a-api/v2/booking")
public class BookingController extends AbstractController {
    @Autowired
    private BookingFacade bookingFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/{id}/{operate}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse transformBooking(@RequestBody BookingVo booking, HttpServletRequest req, HttpServletResponse resp, @PathVariable String operate) {
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

        int operation = Constant.BOOKINGOPERATEMAP.get(operate);
        BookingBo bookingBo = null;
        try {
            bookingBo = bookingFacade.transformBookingStatus(BookingConverter.fromModel(booking), operation, currentUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        BookingVo bookingVo = BookingConverter.toModel(bookingBo);
        return bookingVo;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse getBookingById(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id) {
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

        BookingVo bookingVo = new BookingVo();
        bookingVo.setId(id);
        BookingPageViewBo bookingBos = null;
        try {
            bookingBos = bookingFacade.queryBooking(BookingConverter.fromModel(bookingVo), currentUser, null, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        BookingBo bookingBo = bookingBos.getData().get(0);
        BookingVo booking = BookingConverter.toModel(bookingBo);
        return booking;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse getBooking(HttpServletRequest req, HttpServletResponse resp, PaginationVo pageVo, BookingVo bookingVo) {
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

        BookingPageViewBo bookingBos = null;
        try {
            bookingBos = bookingFacade.queryBooking(BookingConverter.fromModel(bookingVo), currentUser, PaginationConverter.toBo(pageVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        BookingPageViewVo bookingVos = BookingPageViewConverter.toModel(bookingBos);
        return bookingVos;
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody JsonResponse getBookingHistory(HttpServletRequest req, HttpServletResponse resp, PaginationVo pageVo, BookingHistoryVo bookingHistoryVo) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = null;
        BookingHistoryPageViewBo bookingHistoryBos = null;
        try {
            currentUser = userFacade.authenticate(authSessionBo, permissionTag);
            int curId = currentUser.getId();
            boolean loggedIn = curId > 0;
            if (!loggedIn) {
                return this.handleWebException(new ControllerException("对不起，您尚未登录"), resp);
            }

            bookingHistoryBos = bookingFacade.queryHistory(BookingHistoryConverter.fromModel(bookingHistoryVo), currentUser, PaginationConverter.toBo(pageVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        BookingHistoryPageViewVo bookingHistoryVos = BookingHistoryPageViewConverter.toModel(bookingHistoryBos);
        return bookingHistoryVos;
    }
}
