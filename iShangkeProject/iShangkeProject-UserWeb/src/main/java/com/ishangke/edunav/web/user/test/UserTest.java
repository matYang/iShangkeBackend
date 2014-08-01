//package com.ishangke.edunav.web.user.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.ishangke.edunav.common.utilities.DateUtility;
//import com.ishangke.edunav.commoncontract.model.MessageBo;
//import com.ishangke.edunav.commoncontract.model.MessagePageViewBo;
//import com.ishangke.edunav.commoncontract.model.OrderByBo;
//import com.ishangke.edunav.commoncontract.model.PaginationBo;
//import com.ishangke.edunav.commoncontract.model.SpreadBo;
//import com.ishangke.edunav.commoncontract.model.SpreadPageViewBo;
//import com.ishangke.edunav.commoncontract.model.UserBo;
//import com.ishangke.edunav.commoncontract.model.UserPageViewBo;
//import com.ishangke.edunav.facade.user.UserFacade;
//import com.ishangke.edunav.web.converter.MessageConverter;
//import com.ishangke.edunav.web.converter.PartnerConverter;
//import com.ishangke.edunav.web.converter.SpreadConverter;
//import com.ishangke.edunav.web.converter.UserConverter;
//import com.ishangke.edunav.web.model.MessageVo;
//import com.ishangke.edunav.web.model.PartnerVo;
//import com.ishangke.edunav.web.model.SpreadVo;
//import com.ishangke.edunav.web.model.UserVo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
//public class UserTest {
//    @Autowired
//    private UserFacade userFacade;
//
//    @Test
//    public void test() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        UserVo vo = new UserVo();
//        UserVo uvo = new UserVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setLastLoginTime(DateUtility.getCurTimeInstance());
//        vo.setBirthday(DateUtility.getCurTimeInstance());
//        vo.setPhone("456");
//        vo.setPassword("123");
//        vo.setName("李清");
//        vo.setSchoolId(1);
//        vo.setCareerId(1);
//        vo.setLocationId(1);
//        uvo.setId(1);
//        UserBo User = userFacade.createUser(UserConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(User);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test1() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        UserVo vo = new UserVo();
//        UserVo uvo = new UserVo();
//        PartnerVo pvo = new PartnerVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setLastLoginTime(DateUtility.getCurTimeInstance());
//        vo.setBirthday(DateUtility.getCurTimeInstance());
//        vo.setPhone("666");
//        vo.setPassword("1234");
//        vo.setName("李清1");
//        vo.setSchoolId(1);
//        vo.setCareerId(1);
//        vo.setReference("ssss");
//        vo.setLocationId(1);
//        uvo.setId(1);
//        pvo.setId(1);
//        UserBo User = userFacade.createPartnerUser(UserConverter.fromModel(vo), PartnerConverter.fromModel(pvo),
//                UserConverter.fromModel(uvo), "POST/api/v2/user/login/phone");
//        System.out.println(User);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test3() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        UserVo vo = new UserVo();
//        UserVo uvo = new UserVo();
//        vo.setId(3);
//        uvo.setId(1);
//
//        UserBo User = userFacade.deleteUser(UserConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(User);
//
//        System.out.println("*******************************");
//    }
//    @Test
//  public void test4() {
//      PaginationBo p = new PaginationBo();
//      p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//      /* test */
//      System.out.println("*****test8*********");
//      UserVo vo = new UserVo();
//      UserVo uvo = new UserVo();
//      vo.setId(1);
//      uvo.setId(1);
//      vo.setEmail("22");
//      UserBo User = userFacade.updateUser(UserConverter.fromModel(vo), UserConverter.fromModel(uvo),
//              "POST/api/v2/user/login/phone");
//      System.out.println(User);
//
//      System.out.println("*******************************");
//  }
//    @Test
//    public void test5() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test8*********");
//        UserVo vo = new UserVo();
//        UserVo uvo = new UserVo();
//        vo.setId(1);
//        uvo.setId(2);
//       
//        UserBo User = userFacade.queryUserInfo(UserConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(User);
//
//        System.out.println("*******************************");
//    }
//    @Test
//    public void test6() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        UserVo vo = new UserVo();
//        UserVo uvo = new UserVo();
//        vo.setName("李清");
//        uvo.setId(1);
//        UserPageViewBo User = userFacade.queryUser(UserConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(User);
//        System.out.println(User.getData().size());
//        for (UserBo cc : User.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
////    @Test
////    public void test7() {
////        PaginationBo p = new PaginationBo();
////        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
////        /* test */
////        System.out.println("*****test8*********");
////        UserVo temp = new UserVo();
////        temp.setPhone("15295569896");
////        
////        SessionBo session = userFacade.openForgetPasswordSession(UserConverter.fromModel(temp), "GET/api/v2/user/forgetPassword");
////        PasswordVo vo = new PasswordVo();
////        vo.setAccountIdentifier("15295569896");
////        vo.setAuthCode(session.getAuthCode());
////        vo.setNewPassword("11111");
////       
////        UserBo User = userFacade.recoverPassword(PasswordConverter.fromModel(vo),
////                "POST/api/v2/user/forgetPassword");
////        System.out.println(User);
////
////        System.out.println("*******************************");
////    }
//    
//   
//}
