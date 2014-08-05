package com.ishangke.edunav.web.user.controller.booking;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.AlipayFacade;
import com.ishangke.edunav.facade.user.BookingFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.model.UserVo;
import com.ishangke.edunav.web.user.controller.AbstractController;

@Controller
@RequestMapping("/api/v2/order")
public class OrderController extends AbstractController {

    @Autowired
    UserFacade userFacade;

    @Autowired
    BookingFacade bookingFacade;

    @Autowired
    AlipayFacade alipayFacade;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    String test(HttpServletRequest request) {
        int userId = 3;
        int courseId = 1;
        double price = 0.01;

        UserVo user = new UserVo();
        user.setId(userId);
        UserBo userBo = UserConverter.fromModel(user);

        BookingBo booking = new BookingBo();
        booking.setUserId(userId);
        booking.setCourseId(courseId);
        booking.setPrice(price);
        booking.setCashbackAmount(0);
        booking.setStatus(Constant.BOOKINGOPERATIONONLINESUBMITBOOKING);
        booking.setName("bookingTest");
        booking.setPhone("18502877744");
        booking = bookingFacade.createBookingByUser(booking, userBo, "GET/api/v2/course");

        OrderBo order = new OrderBo();
        order.setBookingId(booking.getId());
        order = bookingFacade.createOrderByUser(order, userBo, "GET/api/v2/course");
        return alipayFacade.buildFormForGet("NANJINGAISHANGKETEST", order.getId() + "", price + "");
    }

}
