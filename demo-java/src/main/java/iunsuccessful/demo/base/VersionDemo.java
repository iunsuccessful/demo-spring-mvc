package iunsuccessful.demo.base;

/**
 * 版本比较
 * Created by LiQZ on 2017/2/22.
 */
public class VersionDemo {

    public static void main(String[] args) {
        // 这种版本计较遇到两位数就出问题
        System.out.println("5.4.1".compareTo("5.4.0"));
        System.out.println("12.4.1".compareTo("5.4.0"));
        // TODO 其他版本的看看
        System.out.println(compareVersion("5.4.1", "5.4.0"));
        System.out.println(compareVersion("12.4.1", "5.4.0"));
        System.out.println(compareVersion("5.4", "5.4.0"));
        System.out.println(compareVersion("5.4.0000000000", "5.4.0"));
        System.out.println(compareVersion("5", "5.4.0"));
    }

    public static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int index = 0;
        //获取最小长度值
        int minLen = Math.min(version1Array.length, version2Array.length);
        int diff = 0;
        //循环判断每位的大小
        while (index < minLen && (diff = Integer.parseInt(version1Array[index]) - Integer.parseInt(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            //如果位数不一致，比较多余位数
            for (int i = index; i < version1Array.length; i++) {
                if (Integer.parseInt(version1Array[i]) > 0) {
                    return 1;
                }
            }

            for (int i = index; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

}
