package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 47
 * Medium
 *
 * @author gdev
 * @date 2022/6/11 21:03
 */
public class Offer47 {

    private static class Solution1 {
        /**
         * time: O(MN), N:len(grid), M:len(grid[0])
         * space: O(M)
         *
         * @param grid -
         * @return -
         */
        public int maxValue(int[][] grid) {
            if (grid == null || grid.length == 0) {return 0;}
            int row = grid.length;
            int col = grid[0].length;
            int[] dp = new int[col+1];
            for (int i = 0; i < row; i++) {
                for (int j = 1; j <= col; j++) {
                    dp[j] = Math.max(dp[j-1], dp[j]) + grid[i][j-1];
                }
            }
            return dp[col];
        }
    }
}
