package iunsuccessful.demo.spring.transaction;

import java.lang.annotation.*;

/**
 * 事务注解 支持多数据源事务
 * @see ImsTransactionInterceptor
 *
 * 注意 嵌套事务 如果在上层事务冲将下层事务的异常catch掉 下层事务将不会回滚
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ImsTransaction {

    String[] transactionNames() default {"transactionManagerSub", "transactionManager"};
}
