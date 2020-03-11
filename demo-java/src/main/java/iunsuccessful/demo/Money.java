package iunsuccessful.demo;

/**
 * 依韵 2019-08-23
 */
public class Money {

    public static void main(String[] args) {
        doCalculate(10_0000.0, 0.05, 22);
    }

    public static void doCalculate(double money, double add, int year) {
        // 转换成月利率
        add = add / 12;
        double newMoney = 60000;
        for (int i = 1; i <= year; i++) {
            for (int j = 1; j <= 12; j++) {
                // 加上这个月存的钱
                newMoney += money;
                // 加上这个月的利息
                newMoney += newMoney * add;
            }
        }
        System.out.println(newMoney/10000);
    }


}
