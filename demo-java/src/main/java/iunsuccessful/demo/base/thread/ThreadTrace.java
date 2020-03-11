//package iunsuccessful.demo.base.thread;
//
//import com.google.common.util.concurrent.ThreadFactoryBuilder;
//
//import javax.annotation.Resource;
//import java.util.concurrent.*;
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * qps 统计
// * <p/>
// *
// * @author Created by 依韵 on 2019/4/28 .
// */
//public class ThreadTrace {
//
//    public static final AtomicInteger all = new AtomicInteger();
//    public static final AtomicInteger success = new AtomicInteger();
//    public static final AtomicInteger fail = new AtomicInteger();
//
//    // Spring boot 中线程池用法
////    @Bean(value = "consumerQueueThreadPool")
////    public ExecutorService buildConsumerQueueThreadPool(){
////        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
////                .setNameFormat("consumer-queue-thread-%d").build();
////
////        ExecutorService pool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
////                new ArrayBlockingQueue<Runnable>(5),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
////
////        return pool ;
////    }
////    @Resource(name = "consumerQueueThreadPool")
////    private ExecutorService consumerQueueThreadPool;
//
//    public ThreadTrace() {
//        run();
//    }
//
//    private void run() {
//
//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
//                .setNameFormat("consumer-queue-thread-%d").build();
//
//        ExecutorService singleThreadExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<Runnable>(5),namedThreadFactory,new ThreadPoolExecutor.AbortPolicy());
//    }
//
//}
