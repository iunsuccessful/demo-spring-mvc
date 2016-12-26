package iunsuccessful.demo.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 *
 *<pre>
 *      get-if-absent-compute
 *      if cached, return; otherwise create, cache and return
 *
 * 缓存的三种过期方式：
 *
 *      size-based eviction:      基于大小
 *      time-based eviction:      基于时间
 *      reference-based eviction: 基于引用
 *
 * 显式清除
 *
 * 任何时候，你都可以显式地清除缓存项，而不是等到它被回收：
 *
 *      个别清除：     Cache.invalidate(key)
 *      批量清除：     Cache.invalidateAll(keys)
 *      清除所有缓存项：Cache.invalidateAll()
 *
 * </pre>
 *
 * @author LiQZ on 2016/3/12.
 */
public class CacheUseDemo {

    public Integer getFrequentUserID(Integer id) {
        sleep();
        return id;
    }

    LoadingCache<Integer, Integer> localCache = CacheBuilder.newBuilder()
        .maximumSize(100)
        .refreshAfterWrite(1, TimeUnit.MILLISECONDS)
        .build(new CacheLoader<Integer, Integer>() {

            @Override
            public Integer load(Integer key) throws Exception {
                return getFrequentUserID(key);
            }

        });

    public Integer getFrequentUserIDByCache(Integer id) {
        try {
            return localCache.get(id);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void sleep() {
        try {
            Thread.sleep(5000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
