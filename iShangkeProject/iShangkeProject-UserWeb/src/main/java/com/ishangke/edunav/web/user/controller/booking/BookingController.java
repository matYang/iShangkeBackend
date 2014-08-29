package com.ishangke.edunav.web.user.controller.booking;

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
import com.ishangke.edunav.facade.user.BookingFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.BookingConverter;
import com.ishangke.edunav.web.converter.BookingHistoryConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.BookingHistoryPageViewConverter;
import com.ishangke.edunav.web.converter.pageview.BookingPageViewConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.map.BookingMap;
import com.ishangke.edunav.web.model.BookingHistoryVo;
import com.ishangke.edunav.web.model.BookingVo;
import com.ishangke.edunav.web.model.pageview.BookingHistoryPageViewVo;
import com.ishangke.edunav.web.model.pageview.BookingPageViewVo;
import com.ishangke.edunav.web.response.JsonResponse;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/booking")
public class BookingController extends AbstractController {
    @Autowired
    private BookingFacade bookingFacade;

    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody JsonResponse createBooking(@RequestBody BookingVo booking, HttpServletRequest req, HttpServletResponse resp) {
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
            BookingBo anonymousBo = null; 
            try {
                anonymousBo = bookingFacade.createBookingByAnonymousUser(BookingConverter.fromModel(booking));
            } catch (ControllerException c) {
                return this.handleWebException(c, resp);
            }
            BookingVo anonymousVo = BookingConverter.toModel(anonymousBo);
            return anonymousVo;
        }

        booking.setUserId(curId);
        BookingBo bookingBo = null;
        try {
            bookingBo = bookingFacade.createBookingByUser(BookingConverter.fromModel(booking), currentUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        BookingVo bookingVo = BookingConverter.toModel(bookingBo);
        return bookingVo;
    }

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
        booking.setUserId(curId);
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

        BookingBo bookingBo = null;
        try {
            bookingBo = bookingFacade.queryBookingById(id, currentUser, permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
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
        
        bookingVo.setUserId(curId);
        BookingPageViewBo bookingBos = null;
        pageVo.setColumnKey(BookingMap.BOOKING_MAP.get(pageVo.getColumnKey()));
        pageVo.setOrder(BookingMap.BOOKING_MAP.get(pageVo.getOrder()));
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
            
            bookingHistoryVo.setUserId(curId);
            bookingHistoryBos = bookingFacade.queryHistory(BookingHistoryConverter.fromModel(bookingHistoryVo), currentUser, PaginationConverter.toBo(pageVo), permissionTag);
        } catch (ControllerException c) {
            return this.handleWebException(c, resp);
        }
        BookingHistoryPageViewVo bookingHistoryVos = BookingHistoryPageViewConverter.toModel(bookingHistoryBos);
        return bookingHistoryVos;
    }
}
