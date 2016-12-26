package iunsuccessful.demo.shiro.common.utils;

import com.google.common.base.Splitter;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author LiQZ on 2016/7/20.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 转换 1,2,3 => List{1,2,3}
     */
    public static Set<Integer> splitIds(String ids) {
        if (isEmpty(ids)) {
            Collections.emptyList();
        }
        List<String> strIds = Splitter.on(",")
                .trimResults()
                .omitEmptyStrings()
                .splitToList(ids);
        if (org.springframework.util.CollectionUtils.isEmpty(strIds)) {
            Collections.emptyList();
        }
//        return strIds.stream().map(Integer::valueOf).collect(Collectors.toList());
        return strIds.stream().map(Integer::valueOf).collect(Collectors.toSet());
    }

}
