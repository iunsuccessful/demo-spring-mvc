package iunsuccessful.demo.shiro.common.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Anonymous on 2016-08-28.
 */
public class RequestMappingUtils {

    public static String[] getPath(RequestMapping requestMapping) {

        if(requestMapping == null){
            return null;
        }

        String[] paths = requestMapping.path();
        if( ArrayUtils.isNotEmpty(paths)){
            return URLUtils.toPaths(paths);
        }

        String[] values = requestMapping.value();
        if( ArrayUtils.isNotEmpty(values)){
            return URLUtils.toPaths(values);
        }

        return null;

    }

    public static String getFirstPath(RequestMapping requestMapping) {
        String[] paths = getPath(requestMapping);
        if (ArrayUtils.isNotEmpty(paths)) {
            return paths[0];
        }
        return null;
    }

    public static String[] getPath(RequestMapping classMapping, RequestMapping methodMapping) {
        String[] classPaths = getPath(classMapping);
        String[] methodPaths = getPath(methodMapping);
        if (ArrayUtils.isEmpty(classPaths)) {
            return methodPaths;
        }
        if (ArrayUtils.isEmpty(methodPaths)) {
            return methodPaths;
        }
        List<String> allPaths = new ArrayList<>();
        for (String classPath: classPaths) {
            for (String methodPath: methodPaths) {
                allPaths.add(URLUtils.append(classPath, methodPath));
            }
        }
        return allPaths.toArray(new String[allPaths.size()]);
    }

}
