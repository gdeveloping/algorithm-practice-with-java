package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 96.
 * Medium
 *
 * @author gdev
 * @date 2022/5/16 17:05
 */
public class UniqueBinarySearchTrees {

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
         * Memory Usage: 41.1 MB, less than 27.57% of Java online submissions for Unique Binary Search Trees.
         *
         * @param n -
         * @return -
         */
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    // len(left)=j, len(root)=1, len(right)=n-j-1
                    dp[i] += dp[j] * dp[i-j-1];
                }
            }
            return dp[n];
        }
    }
}
