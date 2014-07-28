package com.ishangke.edunav.web.user.common;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.thrift.TException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.facade.course.CourseFacade;
import com.ishangke.edunav.web.common.OrderByVo;
import com.ishangke.edunav.web.common.PaginationVo;
import com.ishangke.edunav.web.converter.CourseConverter;
import com.ishangke.edunav.web.converter.PaginationConverter;
import com.ishangke.edunav.web.model.CourseVo;

public class Test {
    public static void main(String[] args) throws TException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:applicationContext-*.xml");
        CourseFacade c = new CourseFacade();
        PaginationVo p = new PaginationVo();
        OrderByVo ov = new OrderByVo("ID", "ASC");
        p.addOrderByEntity(ov);
        CourseVo ccc = new CourseVo();
         ccc.setCategoryValue("0100");
        // ccc.setLocationValue("00");
        // ccc.setCircleValue("02");
        // ccc.setOriginalPriceStart(1000.0);
//        Calendar ca = Calendar.getInstance();
//        ca.set(2008, 0, 22);
//        ccc.setCashbackDateStart(ca);
        List<CourseBo> course = c.queryCourseByFilter(CourseConverter.fromModel(ccc), PaginationConverter.toBo(p), "");
        System.out.println(course);
        System.out.println(course.size());
        System.out.println(DateUtility.getTimeFromLong(course.get(0).getCashbackDateStart()).getTime());
        System.out.println("********************************");
        for (CourseBo cc : course) {
            System.out.println(cc);
        }
    }
}
