package com.ishangke.edunav.clean;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ishangke.edunav.dataaccess.mapper.BookingEntityExtMapper;
import com.ishangke.edunav.dataaccess.mapper.CourseEntityExtMapper;

public class CleanEventJob {
    private static final Logger LOGGER = LoggerFactory.getLogger(CleanEventJob.class);
    
    @Autowired
    CourseEntityExtMapper courseMapper;
    
    @Autowired
    BookingEntityExtMapper bookingMapper;
    
    public void clean() {
        LOGGER.info("Clean called at:" + new Date().toString());
        cleanCourse();
        cleanBooking();
    }
    
    private void cleanCourse() {
        LOGGER.info("Clean:cleanCourse started at:" + new Date().toString());
        
        
        LOGGER.info("Clean:cleanCourse finished at:" + new Date().toString());
    }
    
    private void cleanBooking() {
        LOGGER.info("Clean:cleanBooking started at:" + new Date().toString());
        
        
        LOGGER.info("Clean:cleanBooking finished at:" + new Date().toString());
    }
    
}
