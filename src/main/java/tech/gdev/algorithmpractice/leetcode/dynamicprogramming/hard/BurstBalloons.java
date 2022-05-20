package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.hard;

/**
 * 312.
 * Hard
 *
 * @author gdev
 * @date 2022/5/20 15:50
 */
public class BurstBalloons {

    private static class Solution1 {
        /**
         * time: O(N^3)
         * space: O(N^2)
         *
         * Runtime: 68 ms, faster than 71.35% of Java online submissions for Burst Balloons.
         * Memory Usage: 43.1 MB, less than 52.84% of Java online submissions for Burst Balloons.
         *
         * @param nums -
         * @return -
         */
        public int maxCoins(int[] nums) {
            int[] arr = new int[nums.length+2];
            for (int i = 0; i < nums.length; i++) {
                arr[i+1] = nums[i];
            }
            arr[0] = arr[arr.length-1] = 1;

            // dp[i][j]: max value after bursting balloons between i and j, excluding i and j
            // dp: max(dp[i][j], dp[i][k] + dp[k][j] + dp[i]*dp[k]*dp[j], dp: (i,j)
            int[][] dp = new int[arr.length][arr.length];
            for (int i = arr.length-2; i >= 0; i--) {
                for (int j = i+1; j < arr.length; j++) {
                    for (int k = i+1; k < j; k++) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i]*arr[k]*arr[j]);
                    }
                }
            }
            return dp[0][arr.length-1];
        }
    }
}
