package iunsuccessful.demo.spring.transaction;

import cn.hutool.extra.spring.SpringUtil;
import org.apache.commons.lang3.tuple.Pair;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class ImsTransactionInterceptor {

    @Around("@annotation(transaction)")
    public Object interceptor(ProceedingJoinPoint joinPoint, ImsTransaction transaction) throws Throwable {

        try {
            ImsTransactionThreadLocal.incrLevel();
            Class clazz = joinPoint.getTarget().getClass();

            List<String> transactionNames = new ArrayList<>();
            Arrays.stream(transaction.transactionNames()).forEach(transactionName -> {
                if (!ImsTransactionThreadLocal.existTransaction(clazz, transactionName)) {
                    transactionNames.add(transactionName);
                }
            });

            Pair<PlatformTransactionManager, TransactionStatus>[] pairs = new Pair[transactionNames.size()];


            for (int i = 0; i < transactionNames.size(); i++) {
                // 获取事务管理器
                PlatformTransactionManager transactionManager = (PlatformTransactionManager) SpringUtil.getBean(transactionNames.get(i));
                // 传入事务设置信息，同事创建看事务
                TransactionStatus transactionStatus = transactionManager.getTransaction(ImsTransactionThreadLocal.getTransactionDefinition());
                // 保存起来，后面释放
                Pair<PlatformTransactionManager, TransactionStatus> pair = Pair.of(transactionManager, transactionStatus);

                pairs[i] = pair;
            }

            Object result;

            try {
                result = joinPoint.proceed();

                // 提交事务
                if (!ImsTransactionThreadLocal.haveParent()) {
                    for (int i = 1; i <= pairs.length; i++) {
                        pairs[pairs.length - i].getLeft().commit(pairs[pairs.length - i].getRight());
                    }
                }
            } catch (Throwable e) {

                // 出现异常回滚
                if (!ImsTransactionThreadLocal.haveParent()) {
                    for (int i = 1; i <= pairs.length; i++) {
                        pairs[pairs.length - i].getLeft().rollback(pairs[pairs.length - i].getRight());
                    }
                }

                throw e;
            }

            return result;
        } finally {
            ImsTransactionThreadLocal.decline();
        }
    }
}
