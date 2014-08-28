package com.ishangke.edunav.clean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.enums.CouponEnums;
import com.ishangke.edunav.common.enums.CoursePromotionEnums;
import com.ishangke.edunav.common.enums.SMSEnums;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CouponEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CoursePromotionEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.CouponEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CoursePromotionEntityExt;
import com.ishangke.edunav.manager.async.task.SMSTask;

//non transactional
public class CleanEventJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(CleanEventJob.class);

    private static Vector<String> panicContactList;

    static {
        panicContactList = new Vector<String>();
        panicContactList.add("18013955974");
    }

    @Autowired
    CourseEntityExtMapper courseMapper;

    @Autowired
    BookingEntityExtMapper bookingMapper;

    @Autowired
    CoursePromotionEntityExtMapper coursePromotionMapper;

    @Autowired
    CouponEntityExtMapper couponMapper;

    public void clean() {
        LOGGER.info("Clean called at:" + new Date().toString());

        LOGGER.info("Clean:cleanCourse started at:" + new Date().toString());
        cleanCourse();
        LOGGER.info("Clean:stageCoursePromotion started at:" + new Date().toString());
        stageCoursePromotion();
        LOGGER.info("Clean:cleanCoupon started at:" + new Date().toString());
        cleanCoupon();
        
        LOGGER.info("Clean finished at:" + new Date().toString());
    }

    private void cleanCoupon() {
        boolean hasError = false;
        CouponEntityExt coupon = new CouponEntityExt();
        coupon.setStatus(CouponEnums.Status.USABLE.getCode());
        // 当前时间已经超过了过期时间 also syaing expiry time <= current time 
        coupon.setExpiryTimeEnd(DateUtility.getCurTimeInstance());
        // 为null的不能删除
        Calendar c = Calendar.getInstance();
        // 公元1年1月1号
        c.set(1, 0, 1, 0, 0, 0);
        coupon.setExpiryTimeStart(c);
        try {
            List<CouponEntityExt> results = couponMapper.list(coupon, getDefaultPagination());
            if (results != null) {
                for (CouponEntityExt result : results) {
                    try {
                        result.setStatus(CouponEnums.Status.EXPIRED.getCode());
                        result.setLastModifyTime(DateUtility.getCurTimeInstance());
                        couponMapper.update(result);
                    } catch (Exception e) {
                        hasError = true;
                        LOGGER.error("[WARNING] [cleanCoupon] suffered single failure with id:" + result.getId(), e);
                    }
                }
            } else {
                LOGGER.warn("[WARNING] [cleanCoupon] search result is null");
            }
        } catch (Exception e) {
            hasError = true;
            LOGGER.error("[ERROR] [cleanCoupon] suffered unexpected errors, please check logs carefully", e);
        }
        
        if (hasError) {
            panic("[ERROR] [cleanCoupon] paniced, please check the logs");
        }
    }

    private void cleanCourse() {
        boolean hasError = false;

        CourseEntityExt course = new CourseEntityExt();
        // online courses that and a cutoff date time <= current time
        course.setStatus(Constant.COURSESTATUSONLINED);
        course.setCutoffDateEnd(DateUtility.getCurTimeInstance());
        // 为null的不能删除
        Calendar c = Calendar.getInstance();
        // 公元1年1月1号
        c.set(1, 0, 1, 0, 0, 0);
        course.setCutoffDateStart(c);
        try {
            List<CourseEntityExt> results = courseMapper.list(course, getDefaultPagination());
            if (results != null) {
                for (CourseEntityExt result : results) {
                    try {
                        result.setStatus(Constant.COURSESTATUSOFFLINED);
                        result.setLastModifyTime(DateUtility.getCurTimeInstance());
                        courseMapper.update(result);
                        LOGGER.info("[INFO] [cleanCourse] offline course " + result.getId());
                    } catch (Throwable t) {
                        hasError = true;
                        LOGGER.error("[WARNING] [cleanCourse] suffered single failure with id:" + result.getId(), t);
                    }
                }
            } else {
                LOGGER.warn("[WARNING] [cleanCourse] search result is null");
            }
        } catch (Throwable t) {
            hasError = true;
            LOGGER.error("[ERROR] [cleanCourse] suffered unexpected errors, please check logs carefully", t);
        }

        if (hasError) {
            panic("[ERROR] [cleanCourse] paniced, please check the logs");
        }
    }

    private void stageCoursePromotion() {
        boolean hasError = false;

        CoursePromotionEntityExt coursePromotion = new CoursePromotionEntityExt();
        // online coursePromotions that has start time < now and status pending
        coursePromotion.setStatus(CoursePromotionEnums.Status.PENDING.code);
        coursePromotion.setStartTimeEnd(DateUtility.getCurTimeInstance());
        try {
            List<CoursePromotionEntityExt> results = coursePromotionMapper.list(coursePromotion, getDefaultPagination());
            if (results != null) {
                for (CoursePromotionEntityExt result : results) {
                    try {
                        result.setStatus(CoursePromotionEnums.Status.ONGOING.code);
                        coursePromotionMapper.update(result);
                    } catch (Throwable t) {
                        hasError = true;
                        LOGGER.error("[WARNING] [stageCoursePromotion] suffered single failure with id:" + result.getId(), t);
                    }
                }
            } else {
                LOGGER.warn("[WARNING] [stageCoursePromotion] search result is null");
            }
        } catch (Throwable t) {
            hasError = true;
            LOGGER.error("[ERROR] [stageCoursePromotion] suffered unexpected errors, please check logs carefully", t);
        }

        if (hasError) {
            panic("[ERROR] [stageCoursePromotion] paniced, please check the logs");
        }
    }

    private void cleanCoursePromotion() {
        boolean hasError = false;

        CoursePromotionEntityExt coursePromotion = new CoursePromotionEntityExt();
        // online coursePromotions that has end time < now and status is ongoing
        coursePromotion.setStatus(CoursePromotionEnums.Status.ONGOING.code);
        coursePromotion.setEndTimeEnd(DateUtility.getCurTimeInstance());
        try {
            List<CoursePromotionEntityExt> results = coursePromotionMapper.list(coursePromotion, getDefaultPagination());
            if (results != null) {
                for (CoursePromotionEntityExt result : results) {
                    try {
                        result.setStatus(CoursePromotionEnums.Status.FINISHED.code);
                        coursePromotionMapper.update(result);
                    } catch (Throwable t) {
                        hasError = true;
                        LOGGER.error("[WARNING] [cleanCoursePromotion] suffered single failure with id:" + result.getId(), t);
                    }
                }
            } else {
                LOGGER.warn("[WARNING] [cleanCoursePromotion] search result is null");
            }
        } catch (Throwable t) {
            hasError = true;
            LOGGER.error("[ERROR] [cleanCoursePromotion] suffered unexpected errors, please check logs carefully", t);
        }

        if (hasError) {
            panic("[ERROR] [cleanCoursePromotion] paniced, please check the logs");
        }
    }

    private void cleanBooking() {
        LOGGER.info("Clean:cleanBooking started at:" + new Date().toString());
        
        boolean hasError = false;

        // find whatever booking established target state 24 hours ago or
        // earlier
        Calendar cal = DateUtility.getCurTimeInstance();
        cal.add(Calendar.MINUTE, -30);

        BookingEntityExt booking = new BookingEntityExt();
        // online bookings that are
        booking.setStatus(Constant.BOOKINGSTATUSONLINEPENDINGPAYMENT);
        booking.setLastModifyTimeEnd(cal);
        try {
            List<BookingEntityExt> results = bookingMapper.list(booking, getDefaultPagination());
            if (results != null) {
                for (BookingEntityExt result : results) {
                    try {
                        result.setStatus(Constant.BOOKINGSTATUSONLINECANCELLED);
                        result.setLastModifyTime(DateUtility.getCurTimeInstance());
                        bookingMapper.update(result);
                        LOGGER.info("[INFO] [cleanBooking] booking " + result.getId() + " exceed");
                    } catch (Throwable t) {
                        hasError = true;
                        LOGGER.error("[WARNING] [cleanBooking] suffered single failure with id:" + result.getId(), t);
                    }
                }
            } else {
                LOGGER.warn("[WARNING] [cleanBooking] search result is null");
            }
        } catch (Throwable t) {
            hasError = true;
            LOGGER.error("[ERROR] [cleanBooking] suffered unexpected errors, please check logs carefully", t);
        }

        if (hasError) {
            panic("[ERROR] [cleanBooking] paniced, please check the logs");
        }
    }

    private void panic(String payload) {
        try {
            // synchronously sending out panic sms messages
            for (String contact : panicContactList) {
                try {
                    SMSTask panicTask = new SMSTask(SMSEnums.Event.PANIC, contact, payload);
                    panicTask.execute();
                } catch (Throwable t) {
                    LOGGER.error("[CleanEventJob] [panic] error when sending sms to: " + contact, t);
                }
            }
        } catch (Throwable t) {
            LOGGER.error("[CleanEventJob] [panic] Gosh damn it can I just not get any exceptions", t);
        }

    }

    private PaginationEntity getDefaultPagination() {
        // pagination that will search all
        PaginationEntity pagination = new PaginationEntity();
        pagination.setOffset(0);
        pagination.setSize(Integer.MAX_VALUE);

        return pagination;
    }

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));
        c.add(Calendar.MINUTE, -30);
        System.out.println(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE));
    }
}
