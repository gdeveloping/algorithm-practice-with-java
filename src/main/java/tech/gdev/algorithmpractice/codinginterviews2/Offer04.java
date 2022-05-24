package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 04
 * Medium
 *
 * @author gdev
 * @date 2022/5/24 17:38
 */
public class Offer04 {

    private static class Solution1 {
        /**
         * time: O(M+N), M:len(matrix), N:len(matrix[0])
         * space: O(1)
         *
         * start from corner matrix[0][columnSize-1]
         * exclude row by row and column by column
         *
         * traverse matrix as a tree
         * -----
         * 1 4 7
         * 2 5 8
         * 3 6 9
         * -----
         *     7
         *   4   8
         * 1   5   9
         *   2   6
         *     3
         *
         * @param matrix -
         * @param target -
         * @return -
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int row = 0;
            int column = matrix[0].length - 1;
            while (row < matrix.length && column >= 0) {
                if (matrix[row][column] == target) {
                    return true;
                }
                if (matrix[row][column] > target) {
                    column--;
                } else {
                    row++;
                }
            }
            return false;
        }
    }
}
