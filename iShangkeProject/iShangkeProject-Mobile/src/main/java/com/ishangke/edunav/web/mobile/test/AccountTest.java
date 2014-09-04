//package com.ishangke.edunav.web.mobile.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.ishangke.edunav.common.utilities.DateUtility;
//import com.ishangke.edunav.commoncontract.model.AccountBo;
//import com.ishangke.edunav.commoncontract.model.AccountHistoryBo;
//import com.ishangke.edunav.commoncontract.model.AccountHistoryPageViewBo;
//import com.ishangke.edunav.commoncontract.model.AccountPageViewBo;
//import com.ishangke.edunav.commoncontract.model.ContactBo;
//import com.ishangke.edunav.commoncontract.model.ContactPageViewBo;
//import com.ishangke.edunav.commoncontract.model.CouponBo;
//import com.ishangke.edunav.commoncontract.model.CouponHistoryBo;
//import com.ishangke.edunav.commoncontract.model.CouponHistoryPageViewBo;
//import com.ishangke.edunav.commoncontract.model.CouponPageViewBo;
//import com.ishangke.edunav.commoncontract.model.CreditBo;
//import com.ishangke.edunav.commoncontract.model.CreditHistoryBo;
//import com.ishangke.edunav.commoncontract.model.CreditHistoryPageViewBo;
//import com.ishangke.edunav.commoncontract.model.CreditPageViewBo;
//import com.ishangke.edunav.commoncontract.model.OrderByBo;
//import com.ishangke.edunav.commoncontract.model.PaginationBo;
//import com.ishangke.edunav.commoncontract.model.WithdrawBo;
//import com.ishangke.edunav.commoncontract.model.WithdrawPageViewBo;
//import com.ishangke.edunav.facade.user.AccountFacade;
//import com.ishangke.edunav.web.converter.AccountConverter;
//import com.ishangke.edunav.web.converter.AccountHistoryConverter;
//import com.ishangke.edunav.web.converter.ContactConverter;
//import com.ishangke.edunav.web.converter.CouponConverter;
//import com.ishangke.edunav.web.converter.CouponHistoryConverter;
//import com.ishangke.edunav.web.converter.CreditConverter;
//import com.ishangke.edunav.web.converter.CreditHistoryConverter;
//import com.ishangke.edunav.web.converter.UserConverter;
//import com.ishangke.edunav.web.converter.WithdrawConverter;
//import com.ishangke.edunav.web.model.AccountHistoryVo;
//import com.ishangke.edunav.web.model.AccountVo;
//import com.ishangke.edunav.web.model.ContactVo;
//import com.ishangke.edunav.web.model.CouponHistoryVo;
//import com.ishangke.edunav.web.model.CouponVo;
//import com.ishangke.edunav.web.model.CreditHistoryVo;
//import com.ishangke.edunav.web.model.CreditVo;
//import com.ishangke.edunav.web.model.UserVo;
//import com.ishangke.edunav.web.model.WithdrawVo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:applicationContext-*.xml" })
//public class AccountTest {
//    @Autowired
//    private AccountFacade accountFacade;
//
//    @Test
//    public void test() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test*********");
//        AccountVo vo = new AccountVo();
//        UserVo uvo = new UserVo();
//        vo.setBalance(3.14);
//        uvo.setId(1);
//        AccountPageViewBo account = accountFacade.queryAccount(AccountConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(account);
//        System.out.println(account.getData().size());
//        for (AccountBo cc : account.getData()) {
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
//        System.out.println("*****test1*********");
//        AccountHistoryVo vo = new AccountHistoryVo();
//        UserVo uvo = new UserVo();
//        vo.setCharge(3.14);
//        uvo.setId(1);
//        AccountHistoryPageViewBo accountHistory = accountFacade.queryAccountHistory(
//                AccountHistoryConverter.fromModel(vo), UserConverter.fromModel(uvo), null,
//                "POST/api/v2/user/login/phone");
//        System.out.println(accountHistory);
//        System.out.println(accountHistory.getData().size());
//        for (AccountHistoryBo cc : accountHistory.getData()) {
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
//        System.out.println("*****test2*********");
//        CouponVo vo = new CouponVo();
//        UserVo uvo = new UserVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setExpiryTime(DateUtility.getCurTimeInstance());
//        vo.setEnabled(1);
//        vo.setUserId(1);
//        uvo.setId(1);
//        CouponBo coupon = accountFacade.createCoupon(CouponConverter.fromModel(vo), UserConverter.fromModel(uvo),
//                "POST/api/v2/user/login/phone");
//        System.out.println(coupon);
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test3() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test3*********");
//        CouponVo vo = new CouponVo();
//        UserVo uvo = new UserVo();
//        vo.setRemark("_test_remark_2_爱上课");
//        uvo.setId(1);
//        CouponPageViewBo coupon = accountFacade.queryCoupon(CouponConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(coupon);
//        System.out.println(coupon.getData().size());
//        for (CouponBo cc : coupon.getData()) {
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
//        System.out.println("*****test4*********");
//        CouponHistoryVo vo = new CouponHistoryVo();
//        UserVo uvo = new UserVo();
//        vo.setCharge(5.8);
//        uvo.setId(1);
//        CouponHistoryPageViewBo couponHistory = accountFacade.queryCouponHistory(CouponHistoryConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(couponHistory);
//        System.out.println(couponHistory.getData().size());
//        for (CouponHistoryBo cc : couponHistory.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test5() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test5*********");
//        CreditVo vo = new CreditVo();
//        UserVo uvo = new UserVo();
//        vo.setCredit(3.14);
//        uvo.setId(1);
//        CreditPageViewBo credit = accountFacade.queryCredit(CreditConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(credit);
//        System.out.println(credit.getData().size());
//        for (CreditBo cc : credit.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test6() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test5*********");
//        CreditHistoryVo vo = new CreditHistoryVo();
//        UserVo uvo = new UserVo();
//        vo.setCharge(2.0);
//        uvo.setId(1);
//        CreditHistoryPageViewBo creditHistory = accountFacade.queryCreditHistory(CreditHistoryConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(creditHistory);
//        System.out.println(creditHistory.getData().size());
//        for (CreditHistoryBo cc : creditHistory.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test7() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test5*********");
//        WithdrawVo vo = new WithdrawVo();
//        UserVo uvo = new UserVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setUserId(1);
//        vo.setPayeeId("1");
//        vo.setPayeeName("1");
//        vo.setType(1);
//        vo.setEnabled(0);
//        uvo.setId(1);
//        WithdrawBo withdraw = accountFacade.createWithdraw(WithdrawConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), "POST/api/v2/user/login/phone");
//        System.out.println(withdraw);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test8() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test8*********");
//        WithdrawVo vo = new WithdrawVo();
//        UserVo uvo = new UserVo();
//        vo.setId(1);
//        uvo.setId(1);
//        vo.setPayeeName("22");
//        WithdrawBo withdraw = accountFacade.updateWithdraw(WithdrawConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), "POST/api/v2/user/login/phone");
//        System.out.println(withdraw);
//
//        System.out.println("*******************************");
//    }
//    @Test
//    public void test9() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test8*********");
//        WithdrawVo vo = new WithdrawVo();
//        UserVo uvo = new UserVo();
//        vo.setId(2);
//        uvo.setId(1);
//        
//        WithdrawBo withdraw = accountFacade.deleteWithdraw(WithdrawConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), "POST/api/v2/user/login/phone");
//        System.out.println(withdraw);
//
//        System.out.println("*******************************");
//    }
//    
//    @Test
//    public void test10() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test10*********");
//        WithdrawVo vo = new WithdrawVo();
//        UserVo uvo = new UserVo();
//        vo.setPayeeName("_test_PN_1_爱上课");
//        uvo.setId(1);
//        WithdrawPageViewBo withdraw = accountFacade.queryWithdraw(WithdrawConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(withdraw);
//        System.out.println(withdraw.getData().size());
//        for (WithdrawBo cc : withdraw.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//    @Test
//    public void test11() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test5*********");
//        ContactVo vo = new ContactVo();
//        UserVo uvo = new UserVo();
//        vo.setCreateTime(DateUtility.getCurTimeInstance());
//        vo.setLastModifyTime(DateUtility.getCurTimeInstance());
//        vo.setUserId(1);
//        vo.setPhone("1");
//        vo.setName("1");
//        vo.setEmail("1");
//        vo.setEnabled(0);
//        uvo.setId(1);
//        ContactBo Contact = accountFacade.createContact(ContactConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), "POST/api/v2/user/login/phone");
//        System.out.println(Contact);
//
//        System.out.println("*******************************");
//    }
//
//    @Test
//    public void test12() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test8*********");
//        ContactVo vo = new ContactVo();
//        UserVo uvo = new UserVo();
//        vo.setId(1);
//        uvo.setId(1);
//        vo.setName("22");
//        ContactBo Contact = accountFacade.updateContact(ContactConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), "POST/api/v2/user/login/phone");
//        System.out.println(Contact);
//
//        System.out.println("*******************************");
//    }
//    @Test
//    public void test13() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test8*********");
//        ContactVo vo = new ContactVo();
//        UserVo uvo = new UserVo();
//        vo.setId(2);
//        uvo.setId(1);
//        
//        ContactBo Contact = accountFacade.deleteContact(ContactConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), "POST/api/v2/user/login/phone");
//        System.out.println(Contact);
//
//        System.out.println("*******************************");
//    }
//    
//    @Test
//    public void test14() {
//        PaginationBo p = new PaginationBo();
//        p.addToOrderByEntities(new OrderByBo("ID", "ASC"));
//        /* test */
//        System.out.println("*****test10*********");
//        ContactVo vo = new ContactVo();
//        UserVo uvo = new UserVo();
//        vo.setName("_test_name_2_爱上课");
//        uvo.setId(1);
//        ContactPageViewBo Contact = accountFacade.queryContact(ContactConverter.fromModel(vo),
//                UserConverter.fromModel(uvo), null, "POST/api/v2/user/login/phone");
//        System.out.println(Contact);
//        System.out.println(Contact.getData().size());
//        for (ContactBo cc : Contact.getData()) {
//            System.out.println(cc);
//        }
//        System.out.println("*******************************");
//    }
//}
