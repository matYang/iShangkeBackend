package com.ishangke.edunav.web.user.common;

import java.util.List;

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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath*:applicationContext-*.xml");
        CourseFacade c = new CourseFacade();
        PaginationVo p = new PaginationVo();
        OrderByVo ov = new OrderByVo("ID", "ASC");
        p.addOrderByEntity(ov);
        CourseVo ccc= new CourseVo();
        ccc.setCategoryValue("00");
        System.out.println(p.getOrderByEntities().get(0).getColumnKey() + "%%");
        System.out.println(PaginationConverter.toBo(p).getOrderByEntities().get(0).getColumnKey() + "@@");
        List<CourseBo> course = c.queryCourseByFilter(CourseConverter.fromModel(ccc), PaginationConverter.toBo(p), "");
        System.out.println(course);
        System.out.println(course.size());
        System.out.println("********************************");
        for (CourseBo cc : course) {
            System.out.println(cc);
        }
    }
}
