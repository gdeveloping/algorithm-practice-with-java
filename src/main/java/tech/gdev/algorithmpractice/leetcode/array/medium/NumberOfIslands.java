package tech.gdev.algorithmpractice.leetcode.array.medium;

/**
 * 200.
 * Medium
 *
 * @author gdev
 * @date 2022/5/8 18:27
 */
public class NumberOfIslands {

    private static class Solution1 {
        /**
         * Runtime: 4 ms, faster than 66.47% of Java online submissions for Number of Islands.
         * Memory Usage: 57.5 MB, less than 39.42% of Java online submissions for Number of Islands.
         *
         * @param grid -
         * @return -
         */
        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        helper(grid, m, n, i, j);
                    }
                }
            }
            return count;
        }

        private void helper(char[][] grid, int m, int n, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
                return;
            }
            grid[i][j] = '0';
            helper(grid, m, n, i, j-1);
            helper(grid, m, n, i+1, j);
            helper(grid, m, n, i, j+1);
            helper(grid, m, n, i-1, j);
        }
    }
}
