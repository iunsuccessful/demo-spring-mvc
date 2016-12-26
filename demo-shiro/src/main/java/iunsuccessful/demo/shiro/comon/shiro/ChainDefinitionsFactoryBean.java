package iunsuccessful.demo.shiro.comon.shiro;

import com.google.common.base.Splitter;
import iunsuccessful.demo.shiro.common.utils.RequestMappingUtils;
import iunsuccessful.demo.shiro.common.utils.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Consumer;


/**
 *    <bean name="filterChainDefinitions" class="iunsuccessful.demo.shiro.comon.shiro.ChainDefinitionsFactoryBean">
         <constructor-arg>
             <value>
                 /static/** = anon
                 /login = authc
                 /logout = logout
                 /** = user
             </value>
         </constructor-arg>
     </bean>
 */
public class ChainDefinitionsFactoryBean implements FactoryBean<String>, ApplicationContextAware, InitializingBean {

    private final Map<String /* bean name*/,Object /*bean instance*/> serviceBeanMap = new HashMap<>();

    private StringBuilder val = new StringBuilder();

    public ChainDefinitionsFactoryBean() {
    }

    public ChainDefinitionsFactoryBean(String val) {
        this.val.append(val);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (Object bean: serviceBeanMap.values()) {
            Annotation classAnnotation = bean.getClass().getAnnotation(Anonymous.class);
            // TODO 判断 Annotation 等不等于 null

            Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
            for(Method method : methods){
                // 如果 类 与 方法都没有就跳过
                if (classAnnotation == null) {
                    Annotation methodAnnotation = method.getAnnotation(Anonymous.class);
                    if (methodAnnotation == null) continue;
                }
                RequestMapping methodRequestMappingAnno = method.getAnnotation(RequestMapping.class);
                if(methodRequestMappingAnno == null) continue;
                RequestMapping classRequestMappingAnno = bean.getClass().getAnnotation(RequestMapping.class);
                // 获取链接
                String[] paths = RequestMappingUtils.getPath(classRequestMappingAnno, methodRequestMappingAnno);
                // TODO 处理链接 {id} -> *
                // 增加忽略
                if (ArrayUtils.isNotEmpty(paths)) {
                    Arrays.stream(paths).forEach(new Consumer<String>() {
                        @Override
                        public void accept(String s) {
                            val.append(s).append("=").append("anon").append("\n");
                        }
                    });
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        serviceBeanMap.putAll(applicationContext.getBeansWithAnnotation(Controller.class));
        serviceBeanMap.putAll(applicationContext.getBeansWithAnnotation(RestController.class));
    }

    /**
     * 按照第一个出现 * 的地方算权重
     */
    @Override
    public String getObject() throws Exception {

        if (val.length() < 3) {
            return StringUtils.EMPTY;
        }

        Splitter lineSplitter = Splitter.on("\n").trimResults().omitEmptyStrings();
        List<String> rows = lineSplitter.splitToList(StringUtils.remove(val.toString(), ' '));
        Map<String, String> sortMap = new TreeMap<>();
        rows.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                sortMap.put(getSort(s)+s, s);
            }
        });

        StringBuilder newVal = new StringBuilder();
        sortMap.values().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                newVal.append(s).append("\n");
            }
        });

        System.err.println(newVal);

        return newVal.toString();
    }

    /**
     * 打分
     * @param url
     * @return
     */
    private int getSort(String url) {
        int position = url.indexOf("*");
        if (position < 0) return 0;
        return 100 - position;
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
