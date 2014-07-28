package com.ishangke.edunav.manager.async.dispatcher;

import java.text.DecimalFormat;

import com.ishangke.edunav.common.enums.SMSEnums.Event;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.manager.async.ExecutorProvider;
import com.ishangke.edunav.manager.async.task.SMSTask;

public class SMSDispatcher {
    // user sms
    public static void sendUserCellVerificationSMS(final String cellNum, final String authCode) {
        String payload = "您申请注册爱上课会员的验证码为：" + authCode + "（如非本人操作请忽略）。爱上课，专注培训课程预订~";
        SMSTask task = new SMSTask(Event.USER_CELLVERIFICATION, cellNum, payload);
        ExecutorProvider.executeRelay(task);
    }

    public static void sendUserForgetPasswordSMS(final String cellNum, final String authCode) {
        String payload = "尊敬的爱会员，您请求更改密码的验证码为：" + authCode + "。请妥善保管~";
        SMSTask task = new SMSTask(Event.USER_FORGETPASSWORD, cellNum, payload);
        ExecutorProvider.executeRelay(task);
    }

    public static void sendBookingAwaitingSMS(final BookingEntityExt booking, final CourseEntityExt course) {
        String payload = "您预订的" + course.getInstName() + "课程订单已提交，我们将尽量于半小时内通知您确认结果,请您耐心等待~";
        SMSTask sms = new SMSTask(Event.USER_BOOKINGAWAITING, booking.getPhone(), payload);
        ExecutorProvider.executeRelay(sms);
    }

    public static void sendBookingConfirmedSMS(final BookingEntityExt booking, final CourseEntityExt course) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        String payload = "确认：" + booking.getName() + DateUtility.formatReadableDate(booking.getScheduledTime()) + "前完成"
                + course.getInstName() + "报到，" + course.getCourseName() + "独享￥" + formatter.format(course.getPrice())
                + "(原价￥" + formatter.format(course.getOriginalPrice()) + ", 优惠"
                + formatter.format(course.getOriginalPrice() - course.getPrice()) + "元)；地址：" + course.getRegLocation()
                + "；订单查询变更取消，请登录官网iShangke.CN" + "；告知机构您的爱上课用户名（注册手机号）才能享受折扣哦~";
        SMSTask sms = new SMSTask(Event.USER_BOOKINGCONFIRMED, booking.getPhone(), payload);
        ExecutorProvider.executeRelay(sms);
    }

    public static void sendBookingFailedSMS(final BookingEntityExt booking,
            final String comment, final CourseEntityExt course) {
        String payload = "很抱歉，您预订的" + course.getInstName() + "课程由于" + comment + "被拒绝，请前往官网查看其他课程吧~";
        SMSTask sms = new SMSTask(Event.USER_BOOKINGFAILED, booking.getPhone(), payload);
        ExecutorProvider.executeRelay(sms);
    }

    public static void sendUserRegistraterSMS(final String cellNum, final double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        String payload = "恭喜您成为爱上课会员，获得" + formatter.format(amount) + "元现金抵扣券已到账，快去官网选课吧~";
        SMSTask sms = new SMSTask(Event.USER_REGISTER, cellNum, payload);
        ExecutorProvider.executeRelay(sms);
    }

    public static void sendInviteeSMS(final String cellNum, final double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        String payload = "您的邀请码验证成功，您和小伙伴额外获得的" + formatter.format(amount) + "元现金抵扣券已到账，快去通知其他小伙伴吧~";
        SMSTask sms = new SMSTask(Event.USER_INVITEE, cellNum, payload);
        ExecutorProvider.executeRelay(sms);
    }

    public static void sendInviterSMS(final String cellNum, final double amount) {
        DecimalFormat formatter = new DecimalFormat("#.##");
        String payload = "感谢您邀请好友成为会员，额外获得" + formatter.format(amount) + "元现金抵扣券已到账，快去官网选课吧~";
        SMSTask sms = new SMSTask(Event.USER_INVITER, cellNum, payload);
        ExecutorProvider.executeRelay(sms);
    }

    //TODO
    public static void sendInviterConsolidationSMS(final String cellNum, final int amount) {
        String payload = "您邀请的好友已通过爱上课报名课程，您额外获得的" + amount + "元现金已到账，不是券，是现金哦~";
        SMSTask sms = new SMSTask(Event.USER_INVITERCONSOLIDATION, cellNum, payload);
        ExecutorProvider.executeRelay(sms);
    }

}
