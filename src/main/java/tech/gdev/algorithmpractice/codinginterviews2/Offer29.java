package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 29
 * Easy
 *
 * @author gdev
 * @date 2022/5/29 16:31
 */
public class Offer29 {

    private static class Solution1 {
        /**
         * time: O(MN), M:len(matrix), N:len(matrix[0])
         * space: O(1)
         *
         * @param matrix -
         * @return -
         */
        public int[] spiralOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[0];
            }
            int rowStart = 0, rowEnd = matrix.length;
            int columnStart = 0, columnEnd = matrix[0].length;
            int[] res = new int[rowEnd * columnEnd];
            int index = 0;
            while (true) {
                if (index >= res.length) {break;}
                for (int i = columnStart; i < columnEnd; i++) {
                    res[index++] = matrix[rowStart][i];
                }
                rowStart++;
                if (index >= res.length) {break;}
                for (int i = rowStart; i < rowEnd; i++) {
                    res[index++] = matrix[i][columnEnd-1];
                }
                columnEnd--;
                if (index >= res.length) {break;}
                for (int i = columnEnd-1; i >= columnStart; i--) {
                    res[index++] = matrix[rowEnd-1][i];
                }
                rowEnd--;
                if (index >= res.length) {break;}
                for (int i = rowEnd-1; i >= rowStart; i--) {
                    res[index++] = matrix[i][columnStart];
                }
                columnStart++;
            }
            return res;
        }
    }
}
