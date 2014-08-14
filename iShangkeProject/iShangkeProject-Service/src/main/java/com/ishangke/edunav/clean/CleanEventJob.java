package com.ishangke.edunav.clean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;

//non transactional
public class CleanEventJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(CleanEventJob.class);

    @Autowired
    CourseEntityExtMapper courseMapper;

    @Autowired
    BookingEntityExtMapper bookingMapper;
    
    public void clean() {
        LOGGER.info("Clean called at:" + new Date().toString());

        LOGGER.info("Clean:cleanCourse started at:" + new Date().toString());
        cleanCourse();
        LOGGER.info("Clean:cleanCoursePromotion started at:" + new Date().toString());
        cleanCoursePromotion();
        LOGGER.info("Clean:cleanBooking started at:" + new Date().toString());
        cleanOrder();

        LOGGER.info("Clean finished at:" + new Date().toString());
    }

    private void cleanCourse() {
        boolean hasError = false;

        // pagination that will search all
        PaginationEntity pagination = new PaginationEntity();
        pagination.setOffset(0);
        pagination.setSize(Integer.MAX_VALUE);

        CourseEntityExt course = new CourseEntityExt();
        // online courses that and a cutoff date time <= current time
        course.setStatus(Constant.COURSESTATUSONLINED);
        course.setCutoffDateEnd(DateUtility.getCurTimeInstance());
        try {
            List<CourseEntityExt> results = courseMapper.list(course, pagination);
            if (results != null) {
                for (CourseEntityExt result : results) {
                    try {
                        result.setStatus(Constant.COURSESTATUSOFFLINED);
                        result.setLastModifyTime(DateUtility.getCurTimeInstance());
                        courseMapper.update(result);
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

    private void cleanCoursePromotion() {
        // TODO
    }

    private void cleanOrder() {
        boolean hasError = false;

        // pagination that will search all
        PaginationEntity pagination = new PaginationEntity();
        pagination.setOffset(0);
        pagination.setSize(Integer.MAX_VALUE);
        
        //find whatever booking established target state 24 hours ago or earlier
        Calendar cal = DateUtility.getCurTimeInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);

        BookingEntityExt booking = new BookingEntityExt();
        // online bookings that are 
        booking.setStatus(Constant.BOOKINGSTATUSONLINEPENDINGPAYMENT);
        booking.setCreateTimeEnd(cal);
        try {
            List<BookingEntityExt> results = bookingMapper.list(booking, pagination);
            if (results != null) {
                for (BookingEntityExt result : results) {
                    try {
                        result.setStatus(Constant.BOOKINGSTATUSONLINECANCELLED);
                        result.setLastModifyTime(DateUtility.getCurTimeInstance());
                        bookingMapper.update(result);
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

    }

}