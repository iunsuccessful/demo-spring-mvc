package iunsuccessful.demo.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 每分钟变换一次验证码
 * 思路：
 *     1. 设置缓存过期时间【这个不行，因为不段调用，就不会刷新，导致验证码一分钟不换】
 *     2. 定时刷新缓存【对于这个场景，这个应该是更好的选择】
 * @author LiQZ on 2016/3/12.
 */
public class CodeCache {

    public static final Logger logger = LoggerFactory.getLogger(CodeCache.class);

    /** 方法一 */
    private LoadingCache<Integer, String>firstCache = CacheBuilder.newBuilder()
            .expireAfterAccess(1, TimeUnit.MINUTES)
            .build(new CacheLoader<Integer, String>() {
                @Override
                public String load(Integer key) throws Exception {
                    logger.info("firstCache#load is run! key {}", key);
                    return getDiffrentString();
                }
            });

    public String getFirstRandom(Integer userId) {
        return firstCache.getUnchecked(userId);
    }

    /** 方法二 */
    // 线程相关信息
    ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("code-cache-reload-pool-%d").setDaemon(true).build();
    ExecutorService parentExecutor = Executors.newSingleThreadExecutor(threadFactory);
    final ListeningExecutorService executorService = MoreExecutors.listeningDecorator(parentExecutor);

    private LoadingCache<Integer, String> secondCache = CacheBuilder.newBuilder()
            .refreshAfterWrite(1, TimeUnit.MINUTES)
            .build(new CacheLoader<Integer, String>() {

                @Override
                public String load(Integer key) throws Exception {
                    logger.info("secondCache#load is run! key {}", key);
                    return getDiffrentString();
                }

                @Override
                public ListenableFuture<String> reload(Integer key, String oldValue) throws Exception {
                    logger.info("secondCache#reload is run! key {} oldValue {}", key, oldValue);
                    return executorService.submit(() -> getDiffrentString());
                }
            });

    public String getSecondRandom(Integer userId) {
        return secondCache.getUnchecked(userId);
    }

    private String getDiffrentString() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1000000));
    }

}
