package com.ishangke.edunav.manager.impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.ishangke.edunav.common.BaseTest;
import com.ishangke.edunav.manager.CacheManager;

@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, CacheManagerImplTest.class })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-serviceUT.xml" })
@Transactional
public class CacheManagerImplTest extends BaseTest {
    
    @Autowired
    private CacheManager cache;

    @Test
    public void testSet() throws InterruptedException, ExecutionException {
        Future<Boolean> setResult = cache.set("test-myKey", 0, "123");
        Assert.assertTrue(setResult.get());
        setResult = cache.del("test-myKey");
        Assert.assertTrue(setResult.get());
    }

    @Test
    public void testGetAndGetBulk() throws InterruptedException, ExecutionException {

        // get null
        String vat = (String) cache.get("test-myKey");
        Assert.assertNull(vat);

        Future<Boolean> setResult = cache.set("test-myKey", 0, "123");
        Assert.assertTrue(setResult.get());

        // get single
        vat = (String) cache.get("test-myKey");
        Assert.assertEquals(vat, "123");

        ArrayList<Future<Boolean>> setResultList = new ArrayList<Future<Boolean>>();
        ArrayList<String> keyList = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            keyList.add("test-myKey-" + i);
        }
        setResultList.add(cache.set(keyList.get(0), 0, "a"));
        setResultList.add(cache.set(keyList.get(1), 0, "bb"));
        setResultList.add(cache.set(keyList.get(2), 0, "ccc"));
        setResultList.add(cache.set(keyList.get(3), 0, "dddd"));
        setResultList.add(cache.set(keyList.get(4), 0, "eeeee"));
        setResultList.add(cache.set(keyList.get(5), 0, "ffffff"));
        setResultList.add(cache.set(keyList.get(6), 0, "ggggggg"));
        setResultList.add(cache.set(keyList.get(7), 0, "hhhhhhhh"));
        setResultList.add(cache.set(keyList.get(8), 0, "iiiiiiiii"));
        setResultList.add(cache.set(keyList.get(9), 0, "jjjjjjjjjj"));

        for (Future<Boolean> ret : setResultList) {
            Assert.assertTrue(ret.get());
        }

        // get bulk
        Map<String, Object> setResultMap = cache.getBulk(keyList);

        for (String key : keyList) {
            Assert.assertEquals(((String) (setResultMap.get(key))).length(), Integer.parseInt(key.split("-")[2]));
        }

        // get expire in 1 sec
        setResult = cache.set("test-myKey", 1, "123");
        Assert.assertTrue(setResult.get());
        vat = (String) cache.get("test-myKey");
        Assert.assertEquals(vat, "123");
//        Thread.sleep(1100);
//        vat = (String) cache.get("test-myKey");
//        Assert.assertNull(vat);

        for (String key : keyList) {
            Assert.assertTrue(cache.del(key).get());
        }
        
        setResult = cache.set("test-myKey", 1, "123");
        Assert.assertTrue(setResult.get());
        Assert.assertTrue(cache.del("test-myKey").get());
    }

}
