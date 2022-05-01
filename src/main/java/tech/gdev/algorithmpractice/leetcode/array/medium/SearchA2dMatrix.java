package tech.gdev.algorithmpractice.leetcode.array.medium;

/**
 * 74.
 * Medium
 *
 * @author gdev
 * @date 2022/5/1 22:25
 */
public class SearchA2dMatrix {

    public static void main(String[] args) {
        test1(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3, true);
        test1(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13, false);
    }

    private static void test1(int[][] matrix, int target, boolean output) {
        Solution1 solution1 = new Solution1();
        boolean res = solution1.searchMatrix(matrix, target);
        System.out.println("res:" + res + "\tsuccess:" + (res == output));
    }

    private static class Solution1 {
        /**
         * time: O(M+N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
         * Memory Usage: 42.2 MB, less than 75.35% of Java online submissions for Search a 2D Matrix.
         *
         * @param matrix -
         * @param target -
         * @return -
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length - 1;
            int column = 0;
            while (row >= 0 && column < matrix[0].length) {
                if (matrix[row][column] == target) {
                    return true;
                } else if (matrix[row][column] > target) {
                    row--;
                } else {
                    column++;
                }
            }
            return false;
        }
    }
}
