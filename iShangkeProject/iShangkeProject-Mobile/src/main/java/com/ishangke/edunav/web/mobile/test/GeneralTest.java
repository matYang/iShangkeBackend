//package com.ishangke.edunav.web.mobile.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.ishangke.edunav.commoncontract.model.CareerBo;
//import com.ishangke.edunav.commoncontract.model.CareerPageViewBo;
//import com.ishangke.edunav.commoncontract.model.CategoryBo;
//import com.ishangke.edunav.commoncontract.model.CategoryPageViewBo;
//import com.ishangke.edunav.commoncontract.model.CircleBo;
//import com.ishangke.edunav.commoncontract.model.CirclePageViewBo;
//import com.ishangke.edunav.commoncontract.model.LocationBo;
//import com.ishangke.edunav.commoncontract.model.LocationPageViewBo;
//import com.ishangke.edunav.commoncontract.model.OrderByBo;
//import com.ishangke.edunav.commoncontract.model.PaginationBo;
//import com.ishangke.edunav.commoncontract.model.SchoolBo;
//import com.ishangke.edunav.commoncontract.model.SchoolPageViewBo;
//import com.ishangke.edunav.facade.user.GeneralFacade;
//import com.ishangke.edunav.web.converter.CareerConverter;
//import com.ishangke.edunav.web.converter.CategoryConverter;
//import com.ishangke.edunav.web.converter.CircleConverter;
//import com.ishangke.edunav.web.converter.LocationConverter;
//import com.ishangke.edunav.web.converter.SchoolConverter;
//import com.ishangke.edunav.web.model.CareerVo;
//import com.ishangke.edunav.web.model.CategoryVo;
//import com.ishangke.edunav.web.model.CircleVo;
//import com.ishangke.edunav.web.model.LocationVo;
//import com.ishangke.edunav.web.model.SchoolVo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
//public class GeneralTest {
//    @Autowired
//    private GeneralFacade generalFacade;
//
//    @Test
//    public void test() {
//
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        CategoryVo vo = new CategoryVo();
//        vo.setValue("00");
//        CategoryPageViewBo category = generalFacade.queryCategory(CategoryConverter.fromModel(vo), null, "");
//        System.out.println(category);
//        System.out.println(category.getData().size());
//        for (CategoryBo cc : category.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test1() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        LocationVo vo = new LocationVo();
//        vo.setValue("00000");
//        LocationPageViewBo location = generalFacade.queryLocation(LocationConverter.fromModel(vo), null, "");
//        System.out.println(location);
//        System.out.println(location.getData().size());
//        for (LocationBo cc : location.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test2() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        CircleVo vo = new CircleVo();
//        vo.setValue("00");
//        CirclePageViewBo circle = generalFacade.queryCircle(CircleConverter.fromModel(vo), null, "");
//        System.out.println(circle);
//        System.out.println(circle.getData().size());
//        for (CircleBo cc : circle.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test3() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        SchoolVo vo = new SchoolVo();
//        vo.setValue("00");
//        SchoolPageViewBo school = generalFacade.querySchool(SchoolConverter.fromModel(vo), null, "");
//        System.out.println(school);
//        System.out.println(school.getData().size());
//        for (SchoolBo cc : school.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test4() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        CareerVo vo = new CareerVo();
//        vo.setValue("03");
//        CareerPageViewBo career = generalFacade.queryCareer(CareerConverter.fromModel(vo), null, "");
//        System.out.println(career);
//        System.out.println(career.getData().size());
//        for (CareerBo cc : career.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//}
