package iunsuccessful.demo.math;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 依韵 2019-09-09
 */
public class ChooseFriend {

    /**
     * 交叉缺货商品，找到相应组合
     *    A   B   C  D  E  F  G  H ...
     * a  1   1   0  1  0  0  1  0
     *
     * b  0   1   0  1  1  1  0  1
     *
     * c  1   0   0  0  1  1  1  0
     *
     * d  0   1   1  0  0  0  1  1
     *
     * ...
     * @param args
     */
    public static void main(String[] args) {
        int A = 0b101000000; // 0
        int B = 0b110100000; // 1
        int C = 0b000100000; // 2
        int D = 0b110000000; // 3
        int E = 0b011010000; // 4
        int F = 0b011000010; // 5
        int G = 0b101100100; // 6
        int H = 0b010101000; // 7
        int I = 0b010101000; // 7
        int J = 0b010101000; // 7
        int K = 0b010101000; // 7
        int L = 0b010101000; // 7
        int M = 0b010101000; // 7
        int N = 0b010101000; // 7
        int O = 0b010101000; // 7
        int P = 0b010101000; // 7
        int Q = 0b010101000; // 7
        int R = 0b100000001; // 7

        int[] warehouses = new int[] { A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R};

        int productSize = 8;

        Long beginTime = System.currentTimeMillis();
        for (int i = 0; i <= Math.min(5, productSize); i++) {
            List<String> result = cooperate(warehouses, i);
            if (CollectionUtils.isNotEmpty(result)) {
                for (String s : result) {
                    System.out.println(s);
                }
                break;
            }
        }

        System.out.println(System.currentTimeMillis() - beginTime);
//        System.out.println(Integer.toBinaryString(A | B));
//        System.out.println(isFriend((A | B) + 1));

    }

    public static List<String> cooperate(int[] arr, int len) {
        List<String> results = new ArrayList<>();
        if (len == 1) {
            for (int i = 0; i < arr.length; i++) {
                if (isFriend(arr[i]+1)) {
                    results.add(String.valueOf(i));
                }
            }
        }

        if (len == 2) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (isFriend((arr[i] | arr[j])+1)) {
                        results.add(String.format("%d, %d", i, j));
                    }
                }
            }
        }

        if (len == 3) {
            for (int k = 0; k < arr.length; k++) {
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (isFriend((arr[i] | arr[j] | arr[k])+1)) {
                            results.add(String.format("%d, %d, %d", i, j, k));
                        }
                    }
                }
            }
        }

        if (len == 4) {
            for (int x = 0; x < arr.length; x++) {
                for (int k = 0; k < arr.length; k++) {
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr.length; j++) {
                            if (isFriend((arr[i] | arr[j] | arr[k] | arr[x])+1)) {
                                results.add(String.format("%d, %d, %d, %d", i, j, k, x));
                            }
                        }
                    }
                }
            }
        }

        if (len == 5) {
            System.out.println(len);
            for (int y = 0; y < arr.length; y++) {
                for (int x = 0; x < arr.length; x++) {
                    for (int k = 0; k < arr.length; k++) {
                        for (int i = 0; i < arr.length; i++) {
                            for (int j = 0; j < arr.length; j++) {
                                if (isFriend((arr[i] | arr[j] | arr[k] | arr[x] | arr[y])+1)) {
                                    results.add(String.format("%d, %d, %d, %d, %d", i, j, k, x, y));
                                }
                            }
                        }
                    }
                }
            }
        }
        return results;
    }

    /**
     * 判断children长度是否为2的幂
     * 惯用法
     */
    private static boolean isFriend(int val) {
        return (val & -val) == val;
    }

}
