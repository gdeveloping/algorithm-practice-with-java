package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1143.
 * Medium
 *
 * @author gdev
 * @date 2022/4/18 23:09
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String[] str1 = {"abcde", "ace"}; // 3
        String[] str2 = {"abc", "abc"}; // 3
        String[] str3 = {"abc", "def"}; // 0
        List<String[]> list = new ArrayList<>();
        list.add(str1);
        list.add(str2);
        list.add(str3);
        Solution1 solution1 = new Solution1();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(solution1.longestCommonSubsequence(list.get(i)[0], list.get(i)[1]));
        }
    }



    private static class Solution1 {
        /**
         * time: O(MN)
         * space: O(MN)
         *
         * Runtime: 13 ms, faster than 79.58% of Java online submissions for Longest Common Subsequence.
         * Memory Usage: 46.3 MB, less than 63.43% of Java online submissions for Longest Common Subsequence.
         *
         * @param text1 -
         * @param text2 -
         * @return -
         */
        public int longestCommonSubsequence(String text1, String text2) {
            final int m = text1.length();
            final int n = text2.length();
            int[][] dp = new int[m+1][n+1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i-1) == text2.charAt(j-1)) {
                        dp[i][j] = 1 + dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[m][n];
        }
    }


}
