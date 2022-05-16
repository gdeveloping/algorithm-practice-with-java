package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 63.
 * Medium
 *
 * @author gdev
 * @date 2022/5/16 15:48
 */
public class UniquePathsII {

    private static class Solution1 {
        /**
         * time: O(MN)
         * space: O(N)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
         * Memory Usage: 42.4 MB, less than 41.89% of Java online submissions for Unique Paths II.
         *
         * @param obstacleGrid -
         * @return -
         */
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int row = obstacleGrid.length;
            int col = obstacleGrid[0].length;
            int[] dp = new int[col];
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[0][j] == 1) {
                    dp[j] = 0;
                    break;
                } else {
                    dp[j] = 1;
                }
            }
            for (int i = 1; i < row; i++) {
                if (obstacleGrid[i][0] == 1) {
                    dp[0] = 0;
                }
                for (int j = 1; j < col; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[j] = 0;
                    } else {
                        dp[j] += dp[j-1];
                    }
                }
            }
            return dp[col-1];
        }
    }
}
