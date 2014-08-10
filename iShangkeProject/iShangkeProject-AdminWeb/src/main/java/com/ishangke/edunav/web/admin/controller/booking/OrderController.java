package com.ishangke.edunav.web.admin.controller.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ishangke.edunav.facade.admin.BookingFacade;
import com.ishangke.edunav.facade.admin.UserFacade;
import com.ishangke.edunav.web.admin.controller.AbstractController;

@Controller
@RequestMapping("/a-api/v2/order")

public class OrderController extends AbstractController{

    @Autowired
    UserFacade userFacade;
    
    @Autowired
    BookingFacade  bookingFacade;
    
    // saving for alipay

}
