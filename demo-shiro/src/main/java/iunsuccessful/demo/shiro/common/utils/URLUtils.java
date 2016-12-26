package iunsuccessful.demo.shiro.common.utils;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.IntFunction;

/**
 * @author LiQZ on 2016/7/22.
 */
public abstract class URLUtils {

    private static AntPathMatcher matcher = new AntPathMatcher();

    /**
     * 连接 URL
     */
    public static String append(String... paths) {
        List<String> pathList = Lists.newArrayList(paths);
        PeekingIterator<String> iter = Iterators.peekingIterator(pathList.iterator());
        StringBuilder urlBuilder = new StringBuilder();
        while (iter.hasNext()) {
            String current = iter.next();
            urlBuilder.append(current);
            if (!iter.hasNext()) {
                break;
            }
            if (current.endsWith("/") && iter.peek().startsWith("/")) {
                urlBuilder.deleteCharAt(urlBuilder.length() - 1);
            } else if (!current.endsWith("/") && !iter.peek().startsWith("/")) {
                urlBuilder.append("/");
            }
        }
        return urlBuilder.toString();
    }

    public static String[] toPaths(String[] paths) {
        if (ArrayUtils.isEmpty(paths)) {
            return paths;
        }
        return Arrays.stream(paths).map(URLUtils::toPath).toArray(String[]::new);
    }

    public static String toPath(String url) {
        if (url == null) {
            return null;
        }
        return url.startsWith("/") ? url : "/" + url;
    }

    /**
     * 匹配 Spring 的 url
     * @param urls
     * @param url
     * @return
     */
    public static String matcher(Set<String> urls, String url) {
        if (CollectionUtils.isEmpty(urls)) {
            return null;
        }
        for (String matchUrl : urls) {
            if (matcher(matchUrl, url)) {
                return matchUrl;
            }
        }
        return null;
    }

    public static boolean matcher(String springUrl, String url) {
        return matcher.match(springUrl, url);
    }

    /**
     * 把 URL 路径，转换成 文件路径
     */
    public static String replaceToFilePath(String url) {
        return StringUtils.replace(url, "/", File.separator);
    }

}