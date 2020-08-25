package iunsuccessful.demo.interview.leetcode;

import iunsuccessful.demo.interview.PrintUtils;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/re-space-lcci/solution/hui-fu-kong-ge-by-leetcode-solution/
 * 依韵 2020/7/9
 */
public class Re_SpaceLCCI {

    public static void main(String[] args) {

        String[] dictionary = new String[]{"bt","vbtbvtvvbbvtbvvbbbvbtbbv","bvvbbbvvvbvttbtbvtvtvvbttbbbtvvvb","btttbvbbbtbbtbvvttbvbvtvbtbbttb","bt","vvbvbvbvtbvbvvvvtv","tbvvvtttvtbvbtttvvbtvvvvtvvbvvtvvbbvbbbvb","v","bvb","vvtbvtvbttbttvvbvttbt","btbtbtttvbbtbttbtvvttbvtbtvtbvvtbbbb","bttbvbbttvvbtvvvvb","bvvbvbvttbvtbvvtbttvvvvtvbtvbttbbvvtvtvv","vbtttt","btbvbbbvbtvtbvvv","b","tbtbtv","vbvbbvvbvbbvvb","vbvvtvbvbvbttvbvbtvbtbtvtbvbbtb","bvvbvvttttttbtvvvttvbvtvvbvtbtvtbvttvvtbt","bvtbttv","bbbt","vtt","ttvv","b","vbb","vtvvbtttvtbbvvbbtbb","vvv","vvvvbbbtbbbvbbbb","ttvvbtvv","v","btvbbvtbbvbvtvttvvbbbtbvvvtbtb","vv","btbttbtbbvbvvbvttbttvtbbtbvtttvbbtbbtvtvvvvbbttvtvvbbbv","ttvbbbbttbtbtb","tvvbvbvvb","vv","ttbttvtvbtbbbbv","bvvvtbbvvvbtvbvtvtvvvvbb","vtbvvbvvvvvttvbbttbbvtvt","tbvbbt","b","v","tvbbtvvtvvtbtbttvvvb","tbttbttbbbtbtvtvtvtbbbvvtbbbvbbvvvbbttvvt","bbvttvtvvtbvbbttvbbtbvvttbvbvbtbvvvbbbvbvbvbtvbtvvvtvvtbttbttbbvbbbttvvvbvvtb","vttvvbvv","tbttbvvttvbtvvtbbvvv","bvbbbbbbbb","vtbvvtbbvtt","bvttbvvbvb","tvttttbbvvvbbtttvvv"};

        var sentence = "btbvtttttbvttbvvbbtvvbvbvvbtbtbtvbtttbvbbbtbbtbvvttbvbvtvbtbbttbvvbvbtttbvttbvvbbvvv";


        Solution solution = new Solution();
        int result = solution.respace(dictionary, sentence);
        System.out.println(result);

//        Trie root = new Trie();
//        root.insert("ab");
//        System.out.println(root);

    }

}


class Solution {

    public int respace(String[] dictionary, String sentence) {

        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        // 定义 \textit{dp}[i]dp[i] 表示考虑前 ii 个字符最少的未识别的字符数量，从前往后计算 \textit{dp}dp 值。
        int[] dp = new int[n + 1];
        // 填充数组
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // 到第 i 个字符，共有多少个不在字典里的呢
        for (int i = 1; i <= n; ++i) {
            // 比前一个，又多了一个不认识的了
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {

                int t = sentence.charAt(j - 1) - 'a';

                /* 这块是结束标志 */
                // 没有以这个字符结尾的，直接结束，不认识 + 1
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    // 这单词刚好是一个词结尾，看看用这个词划算，还是用上面那个词划算
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }

                if (dp[i] == 0) {
                    break;
                }
                /* end sign */
                // 下个字符
                curPos = curPos.next[t];
            }
        }
        PrintUtils.print(dp);
        return dp[n];
    }
}

class Trie {

    public Trie[] next;
    public boolean isEnd;

    public Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String s) {
        Trie curPos = this;

        for (int i = s.length() - 1; i >= 0; --i) {
            int t = s.charAt(i) - 'a';
            if (curPos.next[t] == null) {
                curPos.next[t] = new Trie();
            }
            curPos = curPos.next[t];
        }
        curPos.isEnd = true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trie{");
        sb.append("next=").append(Arrays.toString(next));
        sb.append(", isEnd=").append(isEnd);
        sb.append('}');
        return sb.toString();
    }
}