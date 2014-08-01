//package com.ishangke.edunav.web.user.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.ishangke.edunav.common.utilities.DateUtility;
//import com.ishangke.edunav.commoncontract.model.ActivityBo;
//import com.ishangke.edunav.commoncontract.model.ActivityPageViewBo;
//import com.ishangke.edunav.commoncontract.model.AddressBo;
//import com.ishangke.edunav.commoncontract.model.AddressPageViewBo;
//import com.ishangke.edunav.commoncontract.model.ClassPhotoBo;
//import com.ishangke.edunav.commoncontract.model.ClassPhotoPageViewBo;
//import com.ishangke.edunav.commoncontract.model.OrderByBo;
//import com.ishangke.edunav.commoncontract.model.PaginationBo;
//import com.ishangke.edunav.commoncontract.model.PartnerBo;
//import com.ishangke.edunav.commoncontract.model.PartnerPageViewBo;
//import com.ishangke.edunav.commoncontract.model.TeacherBo;
//import com.ishangke.edunav.commoncontract.model.TeacherPageViewBo;
//import com.ishangke.edunav.facade.user.PartnerFacade;
//import com.ishangke.edunav.web.converter.ActivityConverter;
//import com.ishangke.edunav.web.converter.AddressConverter;
//import com.ishangke.edunav.web.converter.ClassPhotoConverter;
//import com.ishangke.edunav.web.converter.PartnerConverter;
//import com.ishangke.edunav.web.converter.TeacherConverter;
//import com.ishangke.edunav.web.converter.UserConverter;
//import com.ishangke.edunav.web.model.ActivityVo;
//import com.ishangke.edunav.web.model.AddressVo;
//import com.ishangke.edunav.web.model.ClassPhotoVo;
//import com.ishangke.edunav.web.model.PartnerVo;
//import com.ishangke.edunav.web.model.TeacherVo;
//import com.ishangke.edunav.web.model.UserVo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
//public class PartnerTest {
//    @Autowired
//    private PartnerFacade partnerFacade;
//
//    @Test
//    public void test() {
//
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        PartnerVo vo = new PartnerVo();
//        UserVo uvo = new UserVo();
//        vo.setInstName("爱上课");
//        uvo.setId(1);
//        PartnerPageViewBo Partner = partnerFacade.queryPartner(PartnerConverter.fromModel(vo), null,
//                UserConverter.fromModel(uvo), "POST/api/v2/user/login/phone");
//        System.out.println(Partner);
//        System.out.println(Partner.getData().size());
//        for (PartnerBo cc : Partner.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test1() {
//
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        PartnerVo vo = new PartnerVo();
//        UserVo uvo = new UserVo();
//        vo.setId(3);
//        uvo.setId(1);
//        PartnerBo Partner = partnerFacade.queryPartnerById(PartnerConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), "POST/api/v2/user/login/phone");
//        System.out.println(Partner);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test2() {
//
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        PartnerVo vo = new PartnerVo();
//        UserVo uvo = new UserVo();
//        vo.setId(1);
//        uvo.setId(1);
//        vo.setRating(4.8);
//        PartnerBo partner = partnerFacade.updatePartner(PartnerConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(partner);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test3() {
//
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        PartnerVo vo = new PartnerVo();
//        UserVo uvo = new UserVo();
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        uvo.setId(1);
//
//        PartnerBo partner = partnerFacade.createPartner(PartnerConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(partner);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test4() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        AddressVo vo = new AddressVo();
//        UserVo uvo = new UserVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setPartnerId(3);
//        vo.setDetail("_test_detail_3_爱上课");
//        uvo.setId(1);
//        AddressBo Address = partnerFacade.createAddress(AddressConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(Address);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test5() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        AddressVo vo = new AddressVo();
//        UserVo uvo = new UserVo();
//        vo.setId(1);
//        uvo.setId(1);
//        vo.setDetail("22");
//        AddressBo Address = partnerFacade.updateAddress(AddressConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(Address);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test6() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        AddressVo vo = new AddressVo();
//        UserVo uvo = new UserVo();
//        vo.setId(2);
//        uvo.setId(1);
//
//        AddressBo Address = partnerFacade.deleteAddress(AddressConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(Address);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test7() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test********");
//        AddressVo vo = new AddressVo();
//        UserVo uvo = new UserVo();
//        vo.setDetail("_test_detail_2_爱上课");
//        uvo.setId(1);
//        AddressPageViewBo Address = partnerFacade.queryAddress(AddressConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(Address);
//        System.out.println(Address.getData().size());
//        for (AddressBo cc : Address.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//    @Test
//    public void test8() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        ClassPhotoVo vo = new ClassPhotoVo();
//        UserVo uvo = new UserVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setPartnerId(3);
//        vo.setImgUrl("_test_IU_2_爱上课");
//        uvo.setId(1);
//        ClassPhotoBo ClassPhoto = partnerFacade.createClassPhoto(ClassPhotoConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(ClassPhoto);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test9() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        ClassPhotoVo vo = new ClassPhotoVo();
//        UserVo uvo = new UserVo();
//        vo.setId(1);
//        uvo.setId(1);
//        vo.setImgUrl("22");
//        ClassPhotoBo ClassPhoto = partnerFacade.updateClassPhoto(ClassPhotoConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(ClassPhoto);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test10() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        ClassPhotoVo vo = new ClassPhotoVo();
//        UserVo uvo = new UserVo();
//        vo.setId(2);
//        uvo.setId(1);
//
//        ClassPhotoBo ClassPhoto = partnerFacade.deleteClassPhoto(ClassPhotoConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(ClassPhoto);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test11() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        ClassPhotoVo vo = new ClassPhotoVo();
//        UserVo uvo = new UserVo();
//        vo.setImgUrl("_test_IU_1_爱上课");
//        uvo.setId(1);
//        ClassPhotoPageViewBo ClassPhoto = partnerFacade.queryClassPhoto(ClassPhotoConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(ClassPhoto);
//        System.out.println(ClassPhoto.getData().size());
//        for (ClassPhotoBo cc : ClassPhoto.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//    @Test
//    public void test12() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        TeacherVo vo = new TeacherVo();
//        UserVo uvo = new UserVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setPartnerId(3);
//        vo.setImgUrl("_test_IU_2_爱上课");
//        uvo.setId(1);
//        TeacherBo Teacher = partnerFacade.createTeacher(TeacherConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(Teacher);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test13() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test8*********");
//        TeacherVo vo = new TeacherVo();
//        UserVo uvo = new UserVo();
//        vo.setId(1);
//        uvo.setId(1);
//        vo.setImgUrl("22");
//        TeacherBo Teacher = partnerFacade.updateTeacher(TeacherConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(Teacher);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test14() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        TeacherVo vo = new TeacherVo();
//        UserVo uvo = new UserVo();
//        vo.setId(2);
//        uvo.setId(1);
//
//        TeacherBo Teacher = partnerFacade.deleteTeacher(TeacherConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(Teacher);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test15() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        TeacherVo vo = new TeacherVo();
//        UserVo uvo = new UserVo();
//        vo.setImgUrl("_test_url_1_爱上课");
//        uvo.setId(1);
//        TeacherPageViewBo Teacher = partnerFacade.queryTeacher(TeacherConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(Teacher);
//        System.out.println(Teacher.getData().size());
//        for (TeacherBo cc : Teacher.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//   
//}
