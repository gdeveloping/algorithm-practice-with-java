package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 343.
 * Medium
 *
 * @author gdev
 * @date 2022/5/16 14:13
 */
public class IntegerBreak {

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N0
         *
         * Runtime: 2 ms, faster than 21.98% of Java online submissions for Integer Break.
         * Memory Usage: 41 MB, less than 35.26% of Java online submissions for Integer Break.
         *
         * @param n -
         * @return -
         */
        public int integerBreak(int n) {
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
                }
            }
            return dp[n];
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Integer Break.
         * Memory Usage: 41.1 MB, less than 35.26% of Java online submissions for Integer Break.
         *
         * @param n -
         * @return -
         */
        public int integerBreak(int n) {
            if (n == 2) {return 1;}
            if (n == 3) {return 2;}
            if (n == 4) {return 4;}
            int res = 1;
            while (n > 4) {
                res *= 3;
                n -= 3;
            }
            res *= n;
            return res;
        }
    }
}
