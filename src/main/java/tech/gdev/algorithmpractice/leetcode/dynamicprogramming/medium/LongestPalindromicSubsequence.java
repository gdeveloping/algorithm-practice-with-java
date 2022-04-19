package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 516.
 * Medium
 *
 * @author gdev
 * @date 2022/4/19 23:28
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "aecda";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.longestPalindromeSubseq(s));
    }

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N^2)
         *
         * Runtime: 78 ms, faster than 50.33% of Java online submissions for Longest Palindromic Subsequence.
         * Memory Usage: 70.6 MB, less than 38.51% of Java online submissions for Longest Palindromic Subsequence.
         *
         * @param s -
         * @return =
         */
        public int longestPalindromeSubseq(String s) {
            final int size = s.length();
            int[][] dp = new int[size][size];
            for (int i = 0; i < size; i++) {
                dp[i][i] = 1;
            }
            for (int i = size-2; i >= 0; i--) {
                for (int j = i+1; j < size; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[0][size-1];
        }
    }
}
