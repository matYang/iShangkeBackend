package com.ishangke.edunav.manager.async.dispatcher;

import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.ishangke.edunav.common.enums.SMSEnums.Event;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.manager.async.ExecutorProvider;
import com.ishangke.edunav.manager.async.task.SMSTask;
import com.ishangke.edunav.manager.common.Flag;

public class SMSDispatcher {

    // user sms
    public static Future<Boolean> sendUserCellVerificationSMS(final String cellNum, final String authCode) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        String payload = "您申请注册爱上课会员的验证码为：" + authCode + "（如非本人操作请忽略）。爱上课，专注课程在线预订~";
        SMSTask task = new SMSTask(Event.USER_CELLVERIFICATION, cellNum, payload);
        return ExecutorProvider.executeRelay(task);
    }

    public static Future<Boolean> sendUserForgetPasswordSMS(final String cellNum, final String authCode) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        String payload = "尊敬的爱会员，您请求更改密码的验证码为：" + authCode + "。请妥善保管~";
        SMSTask task = new SMSTask(Event.USER_FORGETPASSWORD, cellNum, payload);
        return ExecutorProvider.executeRelay(task);
    }

    public static Future<Boolean> sendBookingAwaitingSMS(final BookingEntityExt booking, final CourseEntityExt course) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        String payload = "您预订的[" + course.getInstName() + "] " + course.getCourseName() + " 课程订单已提交，订单号为" + booking.getReference() + ", 我们将尽量于半小时内通知您确认结果,请您耐心等待~";
        SMSTask sms = new SMSTask(Event.USER_BOOKINGAWAITING, booking.getPhone(), payload);
        return ExecutorProvider.executeRelay(sms);
    }

    public static Future<Boolean> sendBookingConfirmedSMS(final BookingEntityExt booking, final CourseEntityExt course) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        String payload = "";
        // 有变动 之前的设计 课程中的原价和现价都不可空
        // 现在的业务是可以为空
        if (course.getPrice() != null && course.getOriginalPrice() != null) {
            payload = "确认：" + booking.getName() + DateUtility.formatReadableDate(booking.getScheduledTime()) + "前完成" + course.getInstName() + "报到，" + course.getCourseName() + "独享￥" + formatter.format(course.getPrice()) + "(原价￥"
                    + formatter.format(course.getOriginalPrice()) + ", 优惠" + formatter.format(course.getOriginalPrice() - course.getPrice()) + "元)；地址：" + course.getRegAddress() + "；订单查询变更取消，请登录官网iShangke.CN" + "；告知机构您的爱上课订单号才能享受折扣哦~";
        } else if (course.getPrice() != null) {
            payload = "确认：" + booking.getName() + DateUtility.formatReadableDate(booking.getScheduledTime()) + "前完成" + course.getInstName() + "报到，" + course.getCourseName() + "独享￥" + formatter.format(course.getPrice()) + "元)；地址："
                    + course.getRegAddress() + "；订单查询变更取消，请登录官网iShangke.CN" + "；告知机构您的爱上课订单号才能享受折扣哦~";
        } else {
            payload = "确认：" + booking.getName() + DateUtility.formatReadableDate(booking.getScheduledTime()) + "前完成" + course.getInstName() + "报到，地址：" + course.getRegAddress() + "；订单查询变更取消，请登录官网iShangke.CN" + "；告知机构您的爱上课订单号才能享受折扣哦~";
        }
        SMSTask sms = new SMSTask(Event.USER_BOOKINGCONFIRMED, booking.getPhone(), payload);
        return ExecutorProvider.executeRelay(sms);
    }

    public static Future<Boolean> sendBookingFailedSMS(final BookingEntityExt booking, final String comment, final CourseEntityExt course) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        String payload = "很抱歉，您预订的" + course.getInstName() + "课程由于" + comment + "被拒绝，请前往官网查看其他课程吧~";
        SMSTask sms = new SMSTask(Event.USER_BOOKINGFAILED, booking.getPhone(), payload);
        return ExecutorProvider.executeRelay(sms);
    }

    public static Future<Boolean> sendUserRegistraterSMS(final String cellNum, final double amount) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        String payload = "恭喜您成为爱上课会员，获得" + formatter.format(amount) + "元现金抵扣券已到账，快去官网选课吧~";
        SMSTask sms = new SMSTask(Event.USER_REGISTER, cellNum, payload);
        return ExecutorProvider.executeRelay(sms);
    }

    public static Future<Boolean> sendInviteeSMS(final String cellNum, final double amount) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        String payload = "您的邀请码验证成功，您和小伙伴额外获得的" + formatter.format(amount) + "元现金抵扣券已到账，快去通知其他小伙伴吧~";
        SMSTask sms = new SMSTask(Event.USER_INVITEE, cellNum, payload);
        return ExecutorProvider.executeRelay(sms);
    }

    public static Future<Boolean> sendInviterSMS(final String cellNum, final double amount) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        DecimalFormat formatter = new DecimalFormat("#.##");
        String payload = "感谢您邀请好友成为会员，额外获得" + formatter.format(amount) + "元现金抵扣券已到账，快去官网选课吧~";
        SMSTask sms = new SMSTask(Event.USER_INVITER, cellNum, payload);
        return ExecutorProvider.executeRelay(sms);
    }
    
    public static Future<Boolean> sendCreateAnonymousUserSMS(final String cellNum, final String password) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        String payload = "感谢您对爱上课得支持，根据您的填写信息，爱上课已自动帮您注册账户了哟～。注册手机" + cellNum + ",随机密码为" + password + "。请尽快登录并修改密码～";
        SMSTask sms = new SMSTask(Event.USER_INVITER, cellNum, payload);
        return ExecutorProvider.executeRelay(sms);
    }

    // TODO
    public static Future<Boolean> sendInviterConsolidationSMS(final String cellNum, final int amount) {
        if (!Flag.shouldSMS()) {
            return new DefaultSMSFuture();
        }
        String payload = "您邀请的好友已通过爱上课报名课程，您额外获得的" + amount + "元现金已到账，不是券，是现金哦~";
        SMSTask sms = new SMSTask(Event.USER_INVITERCONSOLIDATION, cellNum, payload);
        return ExecutorProvider.executeRelay(sms);
    }

    /**
     * hide away the fact that sms is ignored, make everything as if it
     * succeeded
     * 
     * @author Matthew
     */
    public static class DefaultSMSFuture implements Future<Boolean> {
        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return true;
        }

        @Override
        public Boolean get() throws InterruptedException, ExecutionException {
            return true;
        }

        @Override
        public Boolean get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return true;
        }
    }

}
