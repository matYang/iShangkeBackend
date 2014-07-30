package com.ishangke.edunav.web.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.commoncontract.model.CourseBo;
import com.ishangke.edunav.commoncontract.model.CoursePageViewBo;
import com.ishangke.edunav.commoncontract.model.OrderByBo;
import com.ishangke.edunav.commoncontract.model.PaginationBo;
import com.ishangke.edunav.facade.user.CourseFacade;
import com.ishangke.edunav.web.converter.CourseConverter;
import com.ishangke.edunav.web.converter.UserConverter;
import com.ishangke.edunav.web.model.CourseVo;
import com.ishangke.edunav.web.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
public class CourseTest {
    @Autowired
    private CourseFacade courseFacade;
    
    @Test
    public void test() {
        
        PaginationBo p = new PaginationBo();
        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
        /* test */
        System.out.println("*****test*********");
        CourseVo vo = new CourseVo();
        vo.setCategoryValue("00");
        CoursePageViewBo course = courseFacade.queryCourseByFilter(CourseConverter.fromModel(vo), null, "");
        System.out.println(course);
        System.out.println(course.getData().size());
        for (CourseBo cc : course.getData()) {
            System.out.println(cc);
        }
        System.out.println("*******************************");
    }

    @Test
    public void test1() {
        System.out.println("****test1****");
        CourseVo vo1 = new CourseVo();
        vo1.setCategoryValue("0000");

        CoursePageViewBo course1 = courseFacade.queryCourseByFilter(CourseConverter.fromModel(vo1), null, "");
        System.out.println(course1);
        System.out.println(course1.getData().size());

        System.out.println(course1.getCount());
        for (CourseBo cc : course1.getData()) {
            System.out.println(cc);
        }
        System.out.println("********************************");
    }
    
    @Test
    public void test2() {
        System.out.println("****test2******");
        CourseVo vo2 = new CourseVo();
        vo2.setCourseName("雅思");
        CoursePageViewBo course2 = courseFacade.queryCourseByFilter(CourseConverter.fromModel(vo2), null, "");
        System.out.println(course2);
        System.out.println(course2.getData().size());

        System.out.println(course2.getCount());
        for (CourseBo cc : course2.getData()) {
            System.out.println(cc);
        }
        System.out.println("********************************");
    }

    @Test
    public void test3() {
        System.out.println("****test3****");
        CourseVo vo3 = new CourseVo();
        vo3.setCategoryValue("0001");
        CoursePageViewBo course3 = courseFacade.queryCourseByFilter(CourseConverter.fromModel(vo3), null, "");
        System.out.println(course3);
        System.out.println("size: " + course3.getData().size());

        System.out.println("count: " + course3.getCount());
        for (CourseBo cc : course3.getData()) {
            System.out.println(cc);
        }

        System.out.println("********************************");
    }
    
    @Test
    public void test4() {
        System.out.println("****test4****");
        CourseVo vo4 = new CourseVo();
        UserVo vo41 = new UserVo();
        vo4.setCreateTime(DateUtility.getCurTimeInstance());
        vo4.setLastModifyTime(DateUtility.getCurTimeInstance());
        vo4.setEnabled(1);
        vo4.setAddressId(1);
        vo4.setCategoryId(1);
        vo4.setCircleId(1);
        vo4.setCourseTemplateId(1);
        vo4.setLocationId(1);
        vo4.setPartnerId(1);
        vo41.setId(1);
        CourseBo course4 = courseFacade.createCourse(CourseConverter.fromModel(vo4), UserConverter.fromModel(vo41),
                "POST/api/v2/user/login/phone");
        System.out.println(course4);
        System.out.println("********************************");

    }
}
