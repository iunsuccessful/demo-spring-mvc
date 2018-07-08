package iunsuccessful.demo.interview.alibaba;

/**
 * Create By LiQZ 2018/7/8
 */
public class Demo3 {

    public static void main(String[] args){
//        String a = "9223372036854775807881";
        String a = "999";
//        String b = "92233720368547758088";
        String b = "11";
        // 求 a + b
        int lenA = a.length();
        int lenB = b.length();
        int bigLen = lenA > lenB? lenA: lenB;
        // 切分成 int[]
        int[] aa = toArray(a);
        int[] bb = toArray(b);
        // 保存进位
        // 保存结果
        int[] rr = new int[bigLen+1];
        // 分别计算
        for (int i = lenA-1, j = lenB-1, k = bigLen; i >= 0 || j >= 0; i--, j--, k--) {
            if (i >= 0 && j >= 0) {
                int r = rr[k] + aa[i] + bb[j];
                rr[k] = r%10;
                if (r >= 10) {
                    rr[k-1] = 1;
                }
            } else if (i >= 0) {
                int r = rr[k] + aa[i];
                rr[k] = r%10;
                if (r >= 10) {
                    rr[k-1] = 1;
                }
            } else {
                int r = rr[k] + bb[j];
                rr[k] = r%10;
                if (r >= 10) {
                    rr[k-1] = 1;
                }
            }
        }
        print(rr);

    }

    private static int[] toArray(String b) {
        int[] a = new int[b.length()];
        for (int i = 0; i < b.length(); i++) {
            a[i] = Integer.valueOf(b.substring(i, i+1));
        }
        return a;
    }

    private static void print(int[] a) {
        System.out.println("################");
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%d", a[i]);
        }
        System.out.println();
    }

}
