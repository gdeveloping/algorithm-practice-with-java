package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 13
 * Medium
 *
 * @author gdev
 * @date 2022/5/26 11:12
 */
public class Offer13 {

    private static class Solution1 {
        /**
         * time: O(MN)
         * space: O(MN)
         *
         * @param m -
         * @param n -
         * @param k -
         * @return -
         */
        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            this.visited = new int[m][n];
            this.res = 0;
            helper(0, 0);
            return res;
        }

        private int m;
        private int n;
        private int k;
        private int[][] visited;
        private int res;

        private void helper(int row, int column) {
            if (!validate(row, column)) {
                return;
            }
            visited[row][column] = 1;
            res++;
            helper(row, column+1);
            helper(row+1, column);
        }

        private boolean validate(int row, int column) {
            if (row < 0 || row >= m || column < 0 || column >= n) {
                return false;
            }

            if (visited[row][column] == 1) {
                return false;
            }

            int sum = 0;
            while (row > 0) {
                sum += (row % 10);
                row /= 10;
            }
            while (column > 0) {
                sum += (column % 10);
                column /= 10;
            }
            if (sum > k) {
                return false;
            }

            return true;
        }
    }


    private static class Solution2 {
        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            this.visited = new int[m][n];

            int res = 0;
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0,0});
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int row = point[0]; int column = point[1];
                if (validate(row, column)) {
                    res++;
                    visited[row][column] =1;
                    queue.offer(new int[]{row+1, column});
                    queue.offer(new int[]{row, column+1});
                }
            }
            return res;
        }

        private int m;
        private int n;
        private int k;
        private int[][] visited;

        private boolean validate(int row, int column) {
            if (row < 0 || row >= m || column < 0 || column >= n) {
                return false;
            }

            if (visited[row][column] == 1) {
                return false;
            }

            int sum = 0;
            while (row > 0) {
                sum += (row % 10);
                row /= 10;
            }
            while (column > 0) {
                sum += (column % 10);
                column /= 10;
            }
            if (sum > k) {
                return false;
            }

            return true;
        }
    }
}
