package com.ishangke.edunav.web.user.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ishangke.edunav.facade.user.BookingFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/order")

public class OrderController extends AbstractController{

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    BookingFacade  bookingFacade;
    
    //saving for alipay
    
}
