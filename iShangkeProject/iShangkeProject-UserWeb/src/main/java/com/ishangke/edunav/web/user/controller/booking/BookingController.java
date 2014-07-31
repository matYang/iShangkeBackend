package com.ishangke.edunav.web.user.controller.booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.BookingFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.converter.BookingConverter;
import com.ishangke.edunav.web.model.BookingVo;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/booking")
public class BookingController  extends AbstractController {
    @Autowired
    private BookingFacade bookingFacade;
    
    @Autowired
    private UserFacade userFacade;
    
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody BookingVo createBooking(@RequestBody BookingVo booking, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        
        BookingBo bookingBo = bookingFacade.createBookingByUser(BookingConverter.fromModel(booking), currentUser, permissionTag);
        BookingVo bookingVo = BookingConverter.toModel(bookingBo); 
        return bookingVo;
    }
}
