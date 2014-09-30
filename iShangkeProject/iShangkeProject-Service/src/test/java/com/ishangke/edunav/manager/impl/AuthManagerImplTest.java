package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.common.utilities.DateUtility;
import com.ishangke.edunav.manager.AuthManager;
import com.ishangke.edunav.manager.CacheManager;
import com.ishangke.edunav.manager.common.SessionConfig.ACConfig;
import com.ishangke.edunav.manager.common.SessionConfig.CellVerificationConfig;
import com.ishangke.edunav.manager.common.SessionConfig.ForgetPasswordConfig;
import com.ishangke.edunav.manager.exception.ManagerException;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, AuthManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-serviceUT.xml" })
public class AuthManagerImplTest extends BaseTest {

    @Autowired
    private AuthManager auth;
    @Autowired
    private CacheManager cache;

    @Test
    public void testAccessControl() throws InterruptedException, ExecutionException {
        boolean wait = false;
        final String identifier = "testAccessControl-18662241356";
        final String identifier2 = "testAccessControl-1f2c82jd92";
        Assert.assertTrue(auth.isAbleToLogin(identifier));
        Assert.assertTrue(auth.isAbleToLogin(identifier2));

        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.isAbleToLogin(identifier));

        Assert.assertTrue(auth.fail(identifier2).get());
        Assert.assertTrue(auth.fail(identifier2).get());
        Assert.assertTrue(auth.isAbleToLogin(identifier2));

        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertFalse(auth.isAbleToLogin(identifier));
        Assert.assertTrue(auth.isAbleToLogin(identifier2));

        Assert.assertTrue(auth.fail(identifier2).get());
        Assert.assertTrue(auth.fail(identifier2).get());
        Assert.assertTrue(auth.fail(identifier2).get());
        Assert.assertTrue(auth.fail(identifier2).get());
        Assert.assertFalse(auth.isAbleToLogin(identifier2));
        Assert.assertFalse(auth.isAbleToLogin(identifier));

        Assert.assertTrue(auth.success(identifier).get());
        Assert.assertTrue(auth.isAbleToLogin(identifier));
        Assert.assertFalse(auth.isAbleToLogin(identifier2));

        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.success(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.fail(identifier).get());
        Assert.assertTrue(auth.isAbleToLogin(identifier));

        Thread.sleep(3000);
        Assert.assertFalse(auth.isAbleToLogin(identifier2));
        if (wait) {
            Thread.sleep(ACConfig.LOCKTHRESHOLD);
            Assert.assertTrue(auth.isAbleToLogin(identifier));
            Assert.assertTrue(auth.isAbleToLogin(identifier2));

            Assert.assertTrue(auth.fail(identifier2).get());
            Assert.assertTrue(auth.fail(identifier2).get());
            Assert.assertTrue(auth.fail(identifier2).get());
            Assert.assertTrue(auth.fail(identifier2).get());
            Assert.assertTrue(auth.isAbleToLogin(identifier2));
            Assert.assertTrue(auth.fail(identifier2).get());
            Assert.assertFalse(auth.isAbleToLogin(identifier2));
        }
        cache.getClient().delete(ACConfig.PREFIX + identifier).get();
        cache.getClient().delete(ACConfig.PREFIX + identifier2).get();
    }

    @Test
    public void testAuthentication() throws InterruptedException, ExecutionException {
        cache.getClient().flush();

        final int identifier = 1866224;
        final int identifier2 = 35;

        auth.closeAuthSession(identifier, "1231221");
        auth.closeAuthSession(identifier2, "1231221");

        String authCode1 = auth.openAuthSession(identifier);
        String authCode2 = auth.openAuthSession(identifier2);

        auth.openAuthSession(identifier);
        auth.openAuthSession(identifier);
        auth.openAuthSession(identifier);
        auth.openAuthSession(identifier);

        Assert.assertTrue(auth.validateAuthSession(identifier, authCode1));
        auth.closeAllAuthSession(identifier).get();
        Assert.assertFalse(auth.validateAuthSession(identifier, authCode1));

        authCode1 = auth.openAuthSession(identifier);

//        long startTime1 = DateUtility.getCurTime();
//        for (int i = 0; i < 1000; i++) {
//            auth.openAuthSession(identifier);
//        }
//        long diff1 = DateUtility.getCurTime() - startTime1;
//
//        // session evicted from cache
//        Assert.assertFalse(auth.validateAuthSession(identifier, authCode1));
//        Assert.assertTrue(auth.validateAuthSession(identifier2, authCode2));
//
//        authCode1 = auth.openAuthSession(identifier);
//        authCode2 = auth.openAuthSession(identifier2);
//
//        long startTime2 = DateUtility.getCurTime();
//        for (int i = 0; i < 1000; i++) {
//            auth.validateAuthSession(identifier, authCode1);
//        }
//        long diff2 = DateUtility.getCurTime() - startTime2;
//
//        long startTime3 = DateUtility.getCurTime();
//        for (int i = 0; i < 1000; i++) {
//            auth.closeAuthSession(identifier, authCode1);
//        }
//        long diff3 = DateUtility.getCurTime() - startTime3;
//
//        System.out
//                .println("==============>1000 basic cas login costs: " + diff1 / 1000 + "sec " + diff1 % 1000 + "ms");
//        System.out.println("==============>1000 basic cas validation costs: " + diff2 / 1000 + "sec " + diff2 % 1000
//                + "ms");
//        System.out.println("==============>1000 basic cas logout costs: " + diff3 / 1000 + "sec " + diff3 % 1000
//                + "ms");
//
//        Thread.sleep(5000);
    }

    @Test
    public void testCellVerification() throws InterruptedException, ExecutionException {
        boolean wait = false;
        cache.getClient().flush();

        final String identifier = "test-testCellVerification-18662241356";
        final String identifier2 = "test-testCellVerification-75985248555";

        Assert.assertFalse(auth.validateCellVerificationSession(identifier, "123456"));
        Assert.assertFalse(auth.validateCellVerificationSession(identifier2, "123456"));

        auth.closeCellVerificationSession(identifier);
        auth.closeCellVerificationSession(identifier2);
        auth.closeCellVerificationSession(identifier);
        auth.closeCellVerificationSession(identifier2);

        String authCode1 = auth.openCellVerificationSession(identifier);
        String authCode2 = auth.openCellVerificationSession(identifier2);

        Assert.assertTrue(auth.validateCellVerificationSession(identifier, authCode1));
        Assert.assertTrue(auth.validateCellVerificationSession(identifier2, authCode2));

        Assert.assertTrue(auth.closeCellVerificationSession(identifier).get());

        Assert.assertFalse(auth.validateCellVerificationSession(identifier, authCode1));
        Assert.assertTrue(auth.validateCellVerificationSession(identifier2, authCode2));

        authCode1 = auth.openCellVerificationSession(identifier);
        try {
            authCode1 = auth.openCellVerificationSession(identifier);
            Assert.fail();
        } catch (ManagerException e) {
            Assert.assertTrue(auth.validateCellVerificationSession(identifier, authCode1));
        }
        if (wait) {
            Thread.sleep(CellVerificationConfig.RESENDTHRESHOLD);
            authCode1 = auth.openCellVerificationSession(identifier);
            Assert.assertTrue(auth.validateCellVerificationSession(identifier, authCode1));
            Assert.assertTrue(auth.validateCellVerificationSession(identifier2, authCode2));
        }
    }

    @Test
    public void testForgetPassword() throws InterruptedException, ExecutionException {
        boolean wait = false;
        cache.getClient().flush();

        final int identifier = 246542;
        final int identifier2 = 35;

        Assert.assertFalse(auth.validateForgetPasswordSession(identifier, "123456"));
        Assert.assertFalse(auth.validateForgetPasswordSession(identifier2, "123456"));

        auth.closeForgetPasswordSession(identifier);
        auth.closeForgetPasswordSession(identifier2);
        auth.closeForgetPasswordSession(identifier);
        auth.closeForgetPasswordSession(identifier2);

        String authCode1 = auth.openForgetPasswordSession(identifier);
        String authCode2 = auth.openForgetPasswordSession(identifier2);

        Assert.assertTrue(auth.validateForgetPasswordSession(identifier, authCode1));
        Assert.assertTrue(auth.validateForgetPasswordSession(identifier2, authCode2));

        Assert.assertTrue(auth.closeForgetPasswordSession(identifier).get());

        Assert.assertFalse(auth.validateForgetPasswordSession(identifier, authCode1));
        Assert.assertTrue(auth.validateForgetPasswordSession(identifier2, authCode2));

        authCode1 = auth.openForgetPasswordSession(identifier);
        try {
            authCode1 = auth.openForgetPasswordSession(identifier);
            Assert.fail();
        } catch (ManagerException e) {
            Assert.assertTrue(auth.validateForgetPasswordSession(identifier, authCode1));
        }
        if (wait) {
            Thread.sleep(ForgetPasswordConfig.RESENDTHRESHOLD);
            authCode1 = auth.openForgetPasswordSession(identifier);
            Assert.assertTrue(auth.validateForgetPasswordSession(identifier, authCode1));
            Assert.assertTrue(auth.validateForgetPasswordSession(identifier2, authCode2));
        }
    }

    private static volatile int failureCount = 0;
    private static volatile int cacheEvictCount = 0;

    public static synchronized void incrFailure() {
        failureCount++;
    }
    public static synchronized void cacheEvict() {
        cacheEvictCount++;
    }

    /**
     * simulating moderate concurrency competition level simulation level: 10
     * distinct accounts, 10 active users per account, 20 interations per user,
     * 30% login, 20% logout, 50% validate
     */
    //@Test
    public void testConcurrentParallelCAS() throws InterruptedException {
        failureCount = 0;
        cacheEvictCount = 0;
        cache.getClient().flush();
        final ArrayList<Integer> idList = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            idList.add((i + 1) * 10);
        }
        final ExecutorService exe = Executors.newCachedThreadPool();
        final CountDownLatch userLatch = new CountDownLatch(100);
        final AuthManager authManager = auth;
        long startTime = DateUtility.getCurTime();
        
        //循环10个id
        for (int i = 0; i < 10; i++) {
            //对于每个id发起10条线程
            for (int j = 0; j < 10; j++) {
                //btw 设为final是的callable的inner class可以access
                final Integer id = idList.get(i);
                //推荐使用Java 8这样俺这里可以写一个lambda.......
                exe.submit(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        try {
                            //以运行纳秒数作为随机种子
                            Random random = new Random(System.nanoTime());
                            //存贮已经生成的验证码
                            ArrayList<String> authCodeList = new ArrayList<String>();
                            for (int k = 0; k < 20; k++) {
                                //随机[0, 10)
                                int opt = random.nextInt(10);
                                int index = authCodeList.size() == 0 ? -1 : random.nextInt(authCodeList.size());
                                
                                //[0, 2]
                                if (opt < 3) {
                                    String newCode = authManager.openAuthSession(id);
                                    authCodeList.add(newCode);
                                }
                                //[3, 4]
                                else if (opt < 5) {
                                    if (index >= 0) {
                                        authManager.closeAuthSession(id, authCodeList.get(index));
                                        authCodeList.remove(index);
                                    }
                                    else {
                                        authManager.closeAuthSession(id, "default");
                                    }
                                }
                                //[5, 9]
                                else {
                                    if (index >= 0) {
                                        if (authManager.validateAuthSession(id, authCodeList.get(index))) {
                                            //all good
                                        }
                                        //cache eviction took place
                                        else {
                                            authCodeList.remove(index);
                                            cacheEvict();
                                            //nothing else we can really do
                                        }
                                    }
                                    else {
                                        Assert.assertFalse(authManager.validateAuthSession(id, "default"));
                                    }
                                }
                            }
                            authManager.closeAllAuthSession(id);
                            return true;
                        } catch(Throwable t) {
                            incrFailure();
                            return false;
                        } finally {
                            userLatch.countDown();
                        }
                    }
                });
            }
        }
        
        userLatch.await();
        long finishTime = DateUtility.getCurTime();
        long diff = finishTime - startTime;
        System.out.println("Test Concurrent Parallel CAS Test finished, time cost: " + diff / 1000 + "sec " + diff
                % 1000 + "ms, failure count: " + failureCount + " cache eviction count: " + cacheEvictCount);

    }
    
    
    /**
     * simulating moderate concurrency competition level simulation level: 100
     * distinct accounts, 1 active users per account, 20 interations per user,
     * 30% login, 20% logout, 50% validate
     */
    //@Test
    public void testConcurrentUniqueCAS() throws InterruptedException {
        failureCount = 0;
        cacheEvictCount = 0;
        cache.getClient().flush();
        final ArrayList<Integer> idList = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            idList.add((i + 1) * 10);
        }
        final ExecutorService exe = Executors.newCachedThreadPool();
        final CountDownLatch userLatch = new CountDownLatch(100);
        final AuthManager authManager = auth;
        long startTime = DateUtility.getCurTime();
        
        //循环100个id
        for (int i = 0; i < 100; i++) {
            //对于每个id发起1条线程
            for (int j = 0; j < 1; j++) {
                //btw 设为final是的callable的inner class可以access
                final Integer id = idList.get(i);
                //推荐使用Java 8这样俺这里可以写一个lambda.......
                exe.submit(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        try {
                            //以运行纳秒数作为随机种子
                            Random random = new Random(System.nanoTime());
                            //存贮已经生成的验证码
                            ArrayList<String> authCodeList = new ArrayList<String>();
                            for (int k = 0; k < 20; k++) {
                                //随机[0, 10)
                                int opt = random.nextInt(10);
                                int index = authCodeList.size() == 0 ? -1 : random.nextInt(authCodeList.size());
                                
                                //[0, 2]
                                if (opt < 3) {
                                    String newCode = authManager.openAuthSession(id);
                                    authCodeList.add(newCode);
                                }
                                //[3, 4]
                                else if (opt < 5) {
                                    if (index >= 0) {
                                        authManager.closeAuthSession(id, authCodeList.get(index));
                                        authCodeList.remove(index);
                                    }
                                    else {
                                        authManager.closeAuthSession(id, "default");
                                    }
                                }
                                //[5, 9]
                                else {
                                    if (index >= 0) {
                                        if (authManager.validateAuthSession(id, authCodeList.get(index))) {
                                            //all good
                                        }
                                        //cache eviction took place
                                        else {
                                            authCodeList.remove(index);
                                            cacheEvict();
                                            //nothing else we can really do
                                        }
                                    }
                                    else {
                                        Assert.assertFalse(authManager.validateAuthSession(id, "default"));
                                    }
                                }
                            }
                            authManager.closeAllAuthSession(id);
                            return true;
                        } catch(Throwable t) {
                            incrFailure();
                            return false;
                        } finally {
                            userLatch.countDown();
                        }
                    }
                });
            }
        }
        
        userLatch.await();
        long finishTime = DateUtility.getCurTime();
        long diff = finishTime - startTime;
        System.out.println("Test Concurrent Unique CAS Test finished, time cost: " + diff / 1000 + "sec " + diff
                % 1000 + "ms, failure count: " + failureCount + " cache eviction count: " + cacheEvictCount);

    }
    
    //@Test
    public void TestIsSystemAdmin() {
        auth.isSystemAdmin(10);
    }

}
