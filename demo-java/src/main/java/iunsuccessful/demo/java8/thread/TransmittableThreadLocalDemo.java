package iunsuccessful.demo.java8.thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * 依韵 2020/7/7
 */
public class TransmittableThreadLocalDemo {

    public static final String DEFAULT_ENV_FLG = "DEFAULT_ENV_FLG";
    public static final String SHADOW_ENV_FLG = "SHADOW_ENV_FLG";

    private static final TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

    private static TransmittableThreadLocalDemo context;

    public static final String SHADOW_PREFIX = "test_";

    static {
        context = new TransmittableThreadLocalDemo();
    }

    public static void main(String[] args) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setMaxPoolSize(2);
        threadPoolTaskExecutor.setThreadNamePrefix("async-task-executor");
        threadPoolTaskExecutor.initialize();

//        TransmittableThreadLocalDemo demo = new TransmittableThreadLocalDemo();
//        demo.run();

        Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
                .parallelStream()
                .forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {

                if (s.equals("3")) {
                    context.setEnv(DEFAULT_ENV_FLG);
                } else {
                    context.setEnv(SHADOW_ENV_FLG);

                }

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        System.out.printf("i %s thread name %s result %s\n", s, Thread.currentThread().getName(), context.isShadow());
                        if (s.equals("2")) {
                            try {
                                Thread.sleep(1000L);
                            } catch (Exception e) {

                            }
                            System.out.printf("i %s thread name %s result %s\n", s, Thread.currentThread().getName(), context.isShadow());
                        }
                    }
                };

//                threadPoolTaskExecutor.execute(TtlRunnable.get(runnable));
                threadPoolTaskExecutor.execute(runnable);
            }
        });





    }


    public  void setEnv(String env){
        if(StringUtils.isNotBlank(env)){
            threadLocal.set(env);
        }else{
            threadLocal.set(DEFAULT_ENV_FLG);
        }
    }

    public  String getEnv(){
        return StringUtils.defaultIfBlank(getThreadLocalValue(), DEFAULT_ENV_FLG);
    }

    public  void clearEnv(){
        threadLocal.remove();
    }

    public  boolean isShadow(){
        return StringUtils.equals(SHADOW_ENV_FLG, getThreadLocalValue());
    }

    private String getThreadLocalValue(){
//        final Object capture = TransmittableThreadLocal.Transmitter.capture();
//        return TransmittableThreadLocal.Transmitter.runSupplierWithCaptured(capture, () -> threadLocal.get());
        return threadLocal.get();
    }

}
