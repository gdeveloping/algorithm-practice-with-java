package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 12
 * Medium
 *
 * @author gdev
 * @date 2022/5/26 10:38
 */
public class Offer12 {

    private static class Solution1 {
        /**
         * time: O(MNK), M:row, N:column, K:len(word)
         * space: O(MN)
         *
         * @param board -
         * @param word -
         * @return -
         */
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0 || word == null || word.length() == 0) {
                return false;
            }
            this.board = board;
            this.word = word;
            this.memo = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (hasPath(0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private char[][] board;
        private String word;
        private int[][] memo;
        private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        private boolean hasPath(int index, int row, int column) {
            if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
                return false;
            }
            if (memo[row][column] == 1 || board[row][column] != word.charAt(index)) {
                return false;
            }
            if (index == word.length()-1) {
                return true;
            }
            memo[row][column] = 1;
            index++;
            for (int[] direction : directions) {
                if (hasPath(index, row+direction[0], column+direction[1])) {
                    memo[row][column] = 0;
                    return true;
                }
            }
            memo[row][column] = 0;
            return false;
        }
    }
}
