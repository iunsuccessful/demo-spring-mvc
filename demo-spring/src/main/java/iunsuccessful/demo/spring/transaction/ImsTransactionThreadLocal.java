package iunsuccessful.demo.spring.transaction;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * ims事务线程变量 用于实现多数据源嵌套事务
 * @see ImsTransactionInterceptor
 */
public class ImsTransactionThreadLocal {

    private static final ThreadLocal<Integer> transactionLevel = new ThreadLocal<>();
    private static final ThreadLocal<DefaultTransactionDefinition> transactionDefinition = new ThreadLocal<>();
    private static final ThreadLocal<Map<Class, List<String>>> existTransaction = new ThreadLocal<>();

    public static void incrLevel(){
        Integer level = transactionLevel.get();

        if (level == null) {
            level = 0;
            DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
            definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
            transactionDefinition.set(definition);
        }

        transactionLevel.set(level + 1);
    }

    public static void decline(){
        Integer level = transactionLevel.get();

        if (level == null || level == 1) {
            remove();
            return;
        }

        transactionLevel.set(level - 1);
    }

    public static DefaultTransactionDefinition getTransactionDefinition(){

        return transactionDefinition.get();
    }

    public static boolean haveParent(){
        return transactionLevel.get() > 1;
    }

    public static boolean existTransaction(Class clazz, String transactionName){
        Map<Class, List<String>> map;
        if ((map = existTransaction.get()) == null) map = new HashMap<>();

        List<String> transactionNames;
        if ((transactionNames = map.get(clazz)) == null) transactionNames = new ArrayList<>();

        if (transactionNames.stream().anyMatch(t -> t.equals(transactionName))) {
            return true;
        }

        transactionNames.add(transactionName);

        map.put(clazz, transactionNames);
        existTransaction.set(map);

        return false;
    }

    public static void remove(){
        transactionLevel.remove();
        transactionDefinition.remove();
        existTransaction.remove();
    }
}
