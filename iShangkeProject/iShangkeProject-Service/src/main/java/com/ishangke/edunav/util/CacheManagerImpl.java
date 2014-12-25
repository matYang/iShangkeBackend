package com.ishangke.edunav.util;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.ConnectionFactoryBuilder.Protocol;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ishangke.edunav.manager.CacheManager;

@Component
public class CacheManagerImpl implements CacheManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheManagerImpl.class);
    
    private static volatile MemcachedClient memcached;
    
    static {
        //建立本地连接，仅供测试 
        try {
            AuthDescriptor ad = new AuthDescriptor(new String[] { "PLAIN" }, new PlainCallbackHandler(
                    "f75c78035d9b11e4", "fadfj4324AfJal"));
            memcached = new MemcachedClient(new ConnectionFactoryBuilder().setProtocol(Protocol.BINARY)
                    .setOpTimeout(500).setAuthDescriptor(ad).build(),
                    AddrUtil.getAddresses("f75c78035d9b11e4.m.cnhzaliqshpub001.ocs.aliyuncs.com:11211"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object get(String key) {
        try{
            return memcached.get(key);
        } catch (Throwable t) {
            LOGGER.debug("Get", t);
            return null;
        }
    }

    @Override
    public Map<String, Object> getBulk(List<String> keys) {
        try{
            return memcached.getBulk(keys);
        } catch (Throwable t) {
            LOGGER.debug("GetBulk", t);
            return new HashMap<String, Object>();
        }
    }

    @Override
    public Future<Boolean> set(String key, int exp, Serializable obj) {
        return memcached.set(key, exp, obj);
    }


    @Override
    public Future<Boolean> del(String key) {
        return memcached.delete(key);
    }

    @Override
    public MemcachedClient getClient() {
        return memcached;
    }

}
