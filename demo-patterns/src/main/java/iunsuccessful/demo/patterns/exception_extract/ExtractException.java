package iunsuccessful.demo.patterns.exception_extract;

import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.util.concurrent.Callable;

/**
 * 统一 Exception 异常处理
 * Created by LiQZ on 2018/4/25.
 */
public class ExtractException {


    private String getVersion(final Class<?> source) {
        return getValue(" v", new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return source.getPackage().getImplementationVersion();
            }
        }, "");
    }

    private String getOn() {
        return getValue(" on ", new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return InetAddress.getLocalHost().getHostName();
            }
        });
    }

    private String getPid() {
        return getValue(" with PID ", new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return System.getProperty("PID");
            }
        });
    }

    private String getValue(String prefix, Callable<Object> call) {
        return getValue(prefix, call, "");
    }

    private String getValue(String prefix, Callable<Object> call, String defaultValue) {
        try {
            Object value = call.call();
            if (value != null && StringUtils.isNotBlank(value.toString())) {
                return prefix + value;
            }
        }
        catch (Exception ex) {
            // Swallow and continue
        }
        return defaultValue;
    }
}
