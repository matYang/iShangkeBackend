package com.ishangke.edunav.manager;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

public interface CacheManager {

    Object get(String key);

    /**
     * Memcache does not support getBulk by its nature, memcache client does so
     * by launching multiple requests, could easily lead to time outs
     * 
     * DO NOT GET MORE THAN 10 Keys at a time!
     * 
     * @param keys
     * @return
     */
    Map<String, Object> getBulk(List<String> keys);

    Future<Boolean> set(String key, int exp, Serializable obj);

    Future<Boolean> del(String key);

    /**
     * @return Memcached client 实例
     */
    MemcachedClient getClient();

}
