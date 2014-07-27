package com.ishangke.edunav.web.user.common;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.OrderByBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.facade.course.CourseFacade;
import com.ishangke.edunav.web.converter.CourseConverter;
import com.ishangke.edunav.web.model.CourseVo;

public class Test {
    public static void main(String[] args) throws TException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath*:applicationContext-*.xml");
        CourseFacade c = new CourseFacade();
        PaginationBo p = new PaginationBo();
        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
        p.setSize(-1);
        p.setOffset(-1);
        CourseVo ccc= new CourseVo();
        ccc.setCategoryValue("00");
        List<CourseBo> course = c.queryCourseByFilter(CourseConverter.fromModel(ccc), p, "");
        System.out.println(course);
        System.out.println(course.size());
        System.out.println("********************************");
        for (CourseBo cc : course) {
            System.out.println(cc);
        }
    }
}
