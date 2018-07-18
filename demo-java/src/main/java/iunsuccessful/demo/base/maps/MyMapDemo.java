package iunsuccessful.demo.base.maps;

/**
 * Create By LiQZ 2018/7/12
 */
public class MyMapDemo {

    public static void main(String[] args) {
        useMyHashMap();
//        printHash();
    }

    private static void useMyHashMap() {
        MyHashMap<Object, Integer> hashMap = new MyHashMap<>(128);
        hashMap.put("0", 0);
        hashMap.put(1, 1);
//        hashMap.put("2", 2);
//        hashMap.put("3", 2);
//        hashMap.put("4", 2);
//        hashMap.put("5", 2);
//        hashMap.put("6", 2);
//        hashMap.put("7", 2);
//        hashMap.put("8", 2);
//        hashMap.put("9", 2);
        hashMap.put("10", 2);
        hashMap.put("11", 2);
//        hashMap.put("12", 2);
        System.out.println(hashMap);
        System.out.println(hashMap.get("11"));
    }

    static void printHash() {
        String i = "1";
        System.out.printf("%s hashCode: %s\n",i, i.hashCode());
        int h;
        System.out.printf("左移 16：%s hash: %s\n", i.hashCode() >>> 16, (h = i.hashCode()) ^ (h >>> 16) );

    }

}
