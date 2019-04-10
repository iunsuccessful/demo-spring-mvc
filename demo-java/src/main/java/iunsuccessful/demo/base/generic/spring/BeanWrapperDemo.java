package iunsuccessful.demo.base.generic.spring;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/3/7 .
 */
public class BeanWrapperDemo {

    public static void main(String[] args) {

    }

//    private static <T> T configListToBean(List<DynamicConfig> list, Class<T> clazz) {
//
//        // 没配置参数，就返回 null
//        if (CollectionUtils.isEmpty(list)) {
//            return null;
//        }
//
//
//        T bean = null;
//
//        try {
//            bean = clazz.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        BeanWrapper beanWrapper = new BeanWrapperImpl(bean);
//
//        list.forEach(input -> {
//
//            // 命名转换一下
//            CaseFormat fromFormat = CaseFormat.LOWER_HYPHEN;
//            CaseFormat toFormat = CaseFormat.LOWER_CAMEL;
//
//            String fieldName = fromFormat.to(toFormat, input.getConfigKey());
//
//            try {
//                beanWrapper.setPropertyValue(fieldName, input.getConfigValue());
//            } catch (Exception e) {
//                try {
//                    beanWrapper.setPropertyValue(fieldName, JSONObject.parseObject(input.getConfigValue()));
//                } catch (Exception e1) {
//
//                }
//                // ignore
//            }
//
//        });
//
//        return bean;
//    }

}
