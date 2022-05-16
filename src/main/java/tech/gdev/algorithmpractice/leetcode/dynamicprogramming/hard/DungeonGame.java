package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.hard;

import java.util.Arrays;

/**
 * 174.
 * Hard
 *
 * @author gdev
 * @date 2022/5/16 22:37
 */
public class DungeonGame {

    private static class Solution1 {
        /**
         * time: O(MN)
         * space: O(MN)
         *
         * Runtime: 1 ms, faster than 96.23% of Java online submissions for Dungeon Game.
         * Memory Usage: 41.6 MB, less than 92.07% of Java online submissions for Dungeon Game.
         *
         * -2,-3,3
         * -5,-10,1
         * 10,30,-5
         *
         * ?,?,?
         * ?,?,?
         * ?,?,6
         *
         * ?,?,2
         * ?,?,5
         * 1,1,6
         *
         * 7,5,2
         * 6,11,5
         * 1,1,6
         *
         * @param dungeon -
         * @return -
         */
        public int calculateMinimumHP(int[][] dungeon) {
            final int row = dungeon.length;
            final int col = dungeon[0].length;
            // dummy: dp[row][...], dp[...][col]
            int[][] dp = new int[row+1][col+1];
            for (int i = 0; i <= row; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            // initial
            dp[row][col-1] = 1;
            dp[row-1][col] = 1;
            for (int i = row-1; i >= 0; i--) {
                for (int j = col-1; j >= 0; j--) {
                    // require min health in this point to arrive target
                    int min = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                    dp[i][j] = (min <= 0) ? 1 : min;
                }
            }
            return dp[0][0];
        }
    }
}
