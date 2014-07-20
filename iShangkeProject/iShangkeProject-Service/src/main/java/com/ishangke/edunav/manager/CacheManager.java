package com.ishangke.edunav.manager;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

public interface CacheManager {

    public Object get(String key);

    /**
     * Memcache does not support getBulk by its nature, memcache client does so
     * by launching multiple requests, could easily lead to time outs
     * 
     * DO NOT GET MORE THAN 10 Keys at a time!
     * 
     * @param keys
     * @return
     */
    public List<Object> getBulk(List<String> keys);

    /**
     * @param key 
     * @param expt
     * @param obj
     * @return
     */
    public Future<Boolean> set(String key, long expt, Serializable obj);

    /**
     * Memcache does not support setBulk by its nature, memcache client does so
     * by launching multiple requests, could easily lead to time outs
     * 
     * DO NOT SET MORE THAN 10 Keys at a time!
     * 
     * @param keys
     * @return
     */
    public Map<String, Future<Boolean>> setBulk(Map<String, Serializable> kvps);
    
    public Future<Boolean> del(String key);
    
    /**
     * @return Memcached client 实例
     */
    public MemcachedClient getClient();

}
