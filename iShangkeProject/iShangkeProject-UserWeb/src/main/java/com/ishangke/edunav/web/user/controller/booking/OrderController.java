package com.ishangke.edunav.web.user.controller.booking;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.BookingBo;
import com.ishangke.edunav.commoncontract.model.OrderBo;
import com.ishangke.edunav.commoncontract.model.SessionBo;
import com.ishangke.edunav.commoncontract.model.UserBo;
import com.ishangke.edunav.facade.user.AlipayFacade;
import com.ishangke.edunav.facade.user.BookingFacade;
import com.ishangke.edunav.facade.user.UserFacade;
import com.ishangke.edunav.web.converter.OrderConverter;
import com.ishangke.edunav.web.exception.ControllerException;
import com.ishangke.edunav.web.model.OrderVo;
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

    @RequestMapping(value = "/{bookingId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public @ResponseBody
    String buildForm(@PathVariable int bookingId, @RequestParam(defaultValue="alipay") String type, HttpServletRequest req, HttpServletResponse resp) {
        String permissionTag = this.getUrl(req);
        SessionBo authSessionBo = this.getSession(req);
        UserBo currentUser = null;
        try {
            currentUser = userFacade.authenticate(authSessionBo, permissionTag);
        } catch (ControllerException c) {
            resp.setStatus(511);
            return "服务器发生异常，不能验证当前用户的身份。。。";
        }
        BookingBo booking = bookingFacade.queryBookingById(bookingId, currentUser, permissionTag);

        OrderVo order = new OrderVo();
        order.setBookingId(booking.getId());
        order.setCreateTime(DateUtility.getCurTimeInstance());
        order.setType(type);
        order.setPrice(booking.getPrice());
        OrderBo orderBo = OrderConverter.fromModel(order);
        try {
            orderBo = bookingFacade.createOrderByUser(orderBo, currentUser, permissionTag);
        } catch (ControllerException c) {
            resp.setStatus(511);
            return "服务器发生异常";
        }

        //我们的订单号ISK + booking id + order id
        //有问题 不能有中文 不然返回之后会乱码
        return alipayFacade.buildFormForGet(Constant.ORDERPREFIX + booking.getId() + "-" + orderBo.getId(), Constant.ORDERSUBJECTPREFIX + booking.getCourse().getCourseName(), String.valueOf(booking.getPrice()));
        //return alipayFacade.buildFormForGet(Constant.ORDERPREFIX + booking.getId() + "-" + orderBo.getId(), "pay course", String.valueOf(booking.getPrice()));
    }
    
}
