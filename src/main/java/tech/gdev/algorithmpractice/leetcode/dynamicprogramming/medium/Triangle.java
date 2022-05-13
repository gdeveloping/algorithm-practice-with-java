package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

import java.util.List;

/**
 * 120.
 * Medium
 *
 * @author gdev
 * @date 2022/5/13 15:55
 */
public class Triangle {

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N)
         *
         * Runtime: 2 ms, faster than 92.47% of Java online submissions for Triangle.
         * Memory Usage: 44.6 MB, less than 22.14% of Java online submissions for Triangle.
         *
         * @param triangle -
         * @return -
         */
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n+1];
            for (int i = n-1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
                }
            }
            return dp[0];
        }
    }
}
