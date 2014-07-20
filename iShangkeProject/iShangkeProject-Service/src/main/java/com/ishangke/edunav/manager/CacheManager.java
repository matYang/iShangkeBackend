package com.ishangke.edunav.manager;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

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

    public Future<?> set(String key, Object obj);

    /**
     * Memcache does not support setBulk by its nature, memcache client does so
     * by launching multiple requests, could easily lead to time outs
     * 
     * DO NOT SET MORE THAN 10 Keys at a time!
     * 
     * @param keys
     * @return
     */
    public Map<String, Future<?>> setBulk(Map<String, Object> kvps);

}
