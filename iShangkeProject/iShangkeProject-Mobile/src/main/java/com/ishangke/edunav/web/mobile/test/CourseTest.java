//package com.ishangke.edunav.web.mobile.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.ishangke.edunav.common.utilities.DateUtility;
//import com.ishangke.edunav.commoncontract.model.CourseBo;
//import com.ishangke.edunav.commoncontract.model.CourseCommentBo;
//import com.ishangke.edunav.commoncontract.model.CourseCommentPageViewBo;
//import com.ishangke.edunav.commoncontract.model.CoursePageViewBo;
//import com.ishangke.edunav.commoncontract.model.CourseTemplateBo;
//import com.ishangke.edunav.commoncontract.model.CourseTemplatePageViewBo;
//import com.ishangke.edunav.commoncontract.model.OrderByBo;
//import com.ishangke.edunav.commoncontract.model.PaginationBo;
//import com.ishangke.edunav.facade.user.CourseFacade;
//import com.ishangke.edunav.web.converter.CourseCommentConverter;
//import com.ishangke.edunav.web.converter.CourseConverter;
//import com.ishangke.edunav.web.converter.CourseTemplateConverter;
//import com.ishangke.edunav.web.converter.UserConverter;
//import com.ishangke.edunav.web.model.CourseCommentVo;
//import com.ishangke.edunav.web.model.CourseTemplateVo;
//import com.ishangke.edunav.web.model.CourseVo;
//import com.ishangke.edunav.web.model.PartnerVo;
//import com.ishangke.edunav.web.model.UserVo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
//public class CourseTest {
//    @Autowired
//    private CourseFacade courseFacade;
//
//    @Test
//    public void test() {
//
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        CourseVo vo = new CourseVo();
//        vo.setCategoryValue("00");
//        CoursePageViewBo course = courseFacade.queryCourseByFilter(CourseConverter.fromModel(vo), null, "");
//        System.out.println(course);
//        System.out.println(course.getData().size());
//        for (CourseBo cc : course.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test1() {
//        System.out.println("****test1****");
//        CourseVo vo1 = new CourseVo();
//        vo1.setCategoryValue("0000");
//
//        CoursePageViewBo course1 = courseFacade.queryCourseByFilter(CourseConverter.fromModel(vo1), null, "");
//        System.out.println(course1);
//        System.out.println(course1.getData().size());
//
//        System.out.println(course1.getCount());
//        for (CourseBo cc : course1.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("********************************");
//    }
//
//    @Test
//    public void test2() {
//        System.out.println("****test2******");
//        CourseVo vo2 = new CourseVo();
//        vo2.setCourseName("雅思");
//        CoursePageViewBo course2 = courseFacade.queryCourseByFilter(CourseConverter.fromModel(vo2), null, "");
//        System.out.println(course2);
//        System.out.println(course2.getData().size());
//
//        System.out.println(course2.getCount());
//        for (CourseBo cc : course2.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("********************************");
//    }
//
//    @Test
//    public void test3() {
//        System.out.println("****test3****");
//        CourseVo vo3 = new CourseVo();
//        vo3.setCategoryValue("0001");
//        CoursePageViewBo course3 = courseFacade.queryCourseByFilter(CourseConverter.fromModel(vo3), null, "");
//        System.out.println(course3);
//        System.out.println("size: " + course3.getData().size());
//
//        System.out.println("count: " + course3.getCount());
//        for (CourseBo cc : course3.getData()) {
//            System.out.println(cc);
//        }
//
//        System.out.println("********************************");
//    }
//
//    @Test
//    public void test4() {
//        System.out.println("****test4****");
//        CourseVo vo4 = new CourseVo();
//        UserVo vo41 = new UserVo();
//        vo4.setCreateTime(DateUtility.getCurTimeInstance());
//        vo4.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo4.setEnabled(1);
//        vo4.setAddressId(1);
//        vo4.setCategoryId(1);
//        vo4.setCircleId(1);
//        vo4.setCourseTemplateId(1);
//        vo4.setLocationId(1);
//        vo4.setPartnerId(1);
//        vo41.setId(1);
//        CourseBo course4 = courseFacade.createCourse(CourseConverter.fromModel(vo4), UserConverter.fromModel(vo41),
//                "POST/api/v2/user/login/phone");
//        System.out.println(course4);
//        System.out.println("********************************");
//
//    }
//
//    @Test
//    public void test5() {
//
//        CourseCommentVo vo = new CourseCommentVo();
//        UserVo vo5 = new UserVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setEnabled(1);
//        vo.setCourseTemplateId(1);
//        vo.setUserId(1);
//        vo5.setId(1);
//        CourseCommentBo course = courseFacade.commentCourse(CourseCommentConverter.fromModel(vo),
//                UserConverter.fromModel(vo5), "POST/api/v2/user/login/phone");
//        System.out.println(course);
//        System.out.println("********************************");
//
//    }
//
//    @Test
//    public void test6() {
//
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        CourseVo vo = new CourseVo();
//        vo.setId(3);
//
//        CourseCommentPageViewBo course = courseFacade.queryCommentByCourseId(CourseConverter.fromModel(vo), null,
//                "POST/api/v2/user/login/phone");
//        System.out.println(course);
//        System.out.println(course.getData().size());
//
//        System.out.println("********************************");
//
//    }
//
//    @Test
//    public void test7() {
//        CourseCommentVo vo = new CourseCommentVo();
//        UserVo vo5 = new UserVo();
//        vo.setId(1);
//        vo5.setId(1);
//        CourseCommentBo course = courseFacade.deleteCommentByCommentId(CourseCommentConverter.fromModel(vo),
//                UserConverter.fromModel(vo5), "POST/api/v2/user/login/phone");
//        System.out.println(course);
//
//        System.out.println("********************************");
//
//    }
//
//    @Test
//    public void test8() {
//        System.out.println("****test8****");
//        CourseVo vo8 = new CourseVo();
//        UserVo vo81 = new UserVo();
//        vo8.setId(1);
//        vo81.setId(1);
//        CoursePageViewBo course8 = courseFacade.queryCourse(CourseConverter.fromModel(vo8),
//                UserConverter.fromModel(vo81), null, "POST/api/v2/user/login/phone");
//        System.out.println(course8);
//        System.out.println(course8.getData().size());
//        System.out.println("********************************");
//
//    }
//
//    @Test
//    public void test9() {
//        System.out.println("****test9****");
//        CourseVo vo9 = new CourseVo();
//
//        vo9.setId(2);
//
//        CoursePageViewBo course9 = courseFacade.queryCourseByFilter(CourseConverter.fromModel(vo9), null,
//                "POST/api/v2/user/login/phone");
//        System.out.println(course9);
//        System.out.println(course9);
//        System.out.println(course9.getData().size());
//        System.out.println("********************************");
//
//    }
//
//    @Test
//    public void test10() {
//        System.out.println("****test10****");
//        CourseVo vo = new CourseVo();
//        UserVo vo10 = new UserVo();
//        vo.setId(1);
//        vo10.setId(1);
//        CourseBo course = courseFacade.queryCourseById(CourseConverter.fromModel(vo), UserConverter.fromModel(vo10),
//                "POST/api/v2/user/login/phone");
//        System.out.println(course);
//
//        System.out.println("********************************");
//
//    }
//
//    @Test
//    public void test11() {
//        System.out.println("****test11****");
//        CourseTemplateVo vo = new CourseTemplateVo();
//        UserVo vo11 = new UserVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setEnabled(1);
//        vo.setAddressId(1);
//        vo.setCategoryId(1);
//        vo.setCircleId(1);
//        vo.setLocationId(1);
//        vo.setPartnerId(1);
//        vo11.setId(1);
//        CourseTemplateBo courseTemplate = courseFacade.createCourseTemplate(CourseTemplateConverter.fromModel(vo),
//                UserConverter.fromModel(vo11), "POST/api/v2/user/login/phone");
//        System.out.println(courseTemplate);
//
//        System.out.println("********************************");
//
//    }
//    @Test
//    public void test12() {
//        System.out.println("****test12****");
//        CourseTemplateVo vo = new CourseTemplateVo();
//        UserVo vo12 = new UserVo();
//        PartnerVo vo121 =new PartnerVo();
//       vo.setId(1);
//        vo12.setId(1);
//        vo121.setId(1);
//        CourseTemplatePageViewBo courseTemplate = courseFacade.queryCourseTemplate(CourseTemplateConverter.fromModel(vo),
//                 UserConverter.fromModel(vo12), null, "POST/api/v2/user/login/phone");
//        System.out.println(courseTemplate);
//        System.out.println(courseTemplate.getData().size());
//        System.out.println("********************************");
//    }
//    @Test
//    public void test13() {
//        System.out.println("****test13****");
//        CourseTemplateVo vo = new CourseTemplateVo();
//        UserVo vo13 = new UserVo();
//        vo.setId(1);
//        vo13.setId(1);
//        CourseTemplateBo courseTemplate = courseFacade.queryCourseTemplateById(CourseTemplateConverter.fromModel(vo), UserConverter.fromModel(vo13),
//                "POST/api/v2/user/login/phone");
//        System.out.println(courseTemplate);
//
//        System.out.println("********************************");
//
//    }
//
//}
