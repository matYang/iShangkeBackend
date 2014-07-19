package com.ishangke.edunav.manager;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public interface CacheManager {

    public Object get(String key);

    public List<Object> getBulk(List<String> keys);

    public Future<?> set(String key, Object obj);

    public Map<String, Future<?>> setBulk(Map<String, Object> kvps);

}
