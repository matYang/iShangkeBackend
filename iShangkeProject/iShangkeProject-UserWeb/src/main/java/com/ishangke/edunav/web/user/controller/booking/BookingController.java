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
import com.ishangke.edunav.commoncontract.model.BookingPageViewBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.BookingFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.common.OrderByVo;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.BookingConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.converter.pageview.BookingPageViewConverter;
import com.ishangke.edunav.web.model.BookingVo;
import com.ishangke.edunav.web.model.pageview.BookingPageViewVo;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/booking")
public class BookingController  extends AbstractController {
    @Autowired
    private BookingFacade bookingFacade;
    
    @Autowired
    private UserFacade userFacade;
    
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody BookingVo createBooking(@RequestBody BookingVo booking, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        
        BookingBo bookingBo = bookingFacade.createBookingByUser(BookingConverter.fromModel(booking), currentUser, permissionTag);
        BookingVo bookingVo = BookingConverter.toModel(bookingBo); 
        return bookingVo;
    }
    
    @RequestMapping(value = "/{id}/{operate}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public @ResponseBody BookingVo transformBooking(@RequestBody BookingVo booking, HttpServletRequest req, HttpServletResponse resp, @PathVariable String operate) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        int operation = Constant.BOOKINGOPERATEMAP.get(operate);
        BookingBo bookingBo = bookingFacade.transformBookingStatus(BookingConverter.fromModel(booking), operation, currentUser, permissionTag);
        BookingVo bookingVo = BookingConverter.toModel(bookingBo);
        return bookingVo;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody BookingVo getBookingById(HttpServletRequest req, HttpServletResponse resp, @PathVariable int id) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        BookingVo bookingVo = new BookingVo();
        bookingVo.setId(id);
        BookingPageViewBo bookingBos = bookingFacade.queryBooking(BookingConverter.fromModel(bookingVo), currentUser, null, permissionTag);
        BookingBo bookingBo = bookingBos.getData().get(0);
        BookingVo booking = BookingConverter.toModel(bookingBo);
        return booking;
    }
    
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody BookingPageViewVo getBooking(HttpServletRequest req, HttpServletResponse resp, PaginationVo pageVo, BookingVo bookingVo, OrderByVo orderByVo) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        pageVo.addOrderByEntity(orderByVo);
        BookingPageViewBo bookingBos = bookingFacade.queryBooking(BookingConverter.fromModel(bookingVo), currentUser, PaginationConverter.toBo(pageVo), permissionTag);
        BookingPageViewVo bookingVos = BookingPageViewConverter.toModel(bookingBos);
        return bookingVos;
    }
}
