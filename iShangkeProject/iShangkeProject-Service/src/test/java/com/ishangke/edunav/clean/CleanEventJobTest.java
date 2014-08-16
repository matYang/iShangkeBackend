package com.ishangke.edunav.clean;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.common.constant.Constant;
import com.ishangke.edunav.common.enums.CoursePromotionEnums;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.dataaccess.common.PaginationEntity;
import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CoursePromotionEntityExtMapper;
import com.ishangke.edunav.dataaccess.model.BookingEntityExt;
import com.ishangke.edunav.dataaccess.model.CourseEntityExt;
import com.ishangke.edunav.dataaccess.model.CoursePromotionEntityExt;
 
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CleanEventJobTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-dataaccessUT.xml", "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class CleanEventJobTest extends BaseTest {
private static final Logger LOGGER = LoggerFactory.getLogger(CleanEventJobTest.class);
    
    private static Vector<String> panicContactList;
    
    static {
        panicContactList = new Vector<String>();
        panicContactList.add("18662241356");
    }

    @Autowired
    CourseEntityExtMapper courseMapper;

    @Autowired
    BookingEntityExtMapper bookingMapper;
    
    @Autowired
    CoursePromotionEntityExtMapper coursePromotionMapper;
    
    @Test
    public void clean() {
        LOGGER.info("Clean called at:" + new Date().toString());

        LOGGER.info("Clean:cleanCourse started at:" + new Date().toString());
        cleanCourse();
        LOGGER.info("Clean:stageCoursePromotion started at:" + new Date().toString());
        stageCoursePromotion();
        LOGGER.info("Clean:cleanCoursePromotion started at:" + new Date().toString());
        cleanCoursePromotion();
        LOGGER.info("Clean:cleanBooking started at:" + new Date().toString());
        cleanBooking();

        LOGGER.info("Clean finished at:" + new Date().toString());
    }

    private void cleanCourse() {
        boolean hasError = false;

        CourseEntityExt course = new CourseEntityExt();
        // online courses that and a cutoff date time <= current time
        course.setStatus(Constant.COURSESTATUSONLINED);
        course.setCutoffDateEnd(DateUtility.getCurTimeInstance());
        try {
            List<CourseEntityExt> results = courseMapper.list(course, getDefaultPagination());
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
        boolean hasError = false;
        
        //find whatever booking established target state 24 hours ago or earlier
        Calendar cal = DateUtility.getCurTimeInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);

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
        //panicing!!
    }
    
    private PaginationEntity getDefaultPagination() {
        // pagination that will search all
        PaginationEntity pagination = new PaginationEntity();
        pagination.setOffset(0);
        pagination.setSize(Integer.MAX_VALUE);
        
        return pagination;
    }
}