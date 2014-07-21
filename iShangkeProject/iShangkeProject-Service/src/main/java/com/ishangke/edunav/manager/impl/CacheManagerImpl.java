package com.ishangke.edunav.manager.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

import com.ishangke.edunav.manager.CacheManager;

public class CacheManagerImpl implements CacheManager {

    @Override
    public Object get(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Object> getBulk(List<String> keys) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Future<Boolean> set(String key, long expt, Serializable obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Future<Boolean>> setBulk(Map<String, Serializable> kvps) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Future<Boolean> del(String key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MemcachedClient getClient() {
        // TODO Auto-generated method stub
        return null;
    }

}
