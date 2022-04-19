package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.hard;

/**
 * 72.
 * Hard
 *
 * @author gdev
 * @date 2022/4/19 22:46
 */
public class EditDistance {
    public static void main(String[] args) {
        String word1, word2;
        word1 = "intention";
        word2 = "execution";
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.minDistance(word1, word2));
    }

    private static class Solution1 {
        /**
         * time: O(MN)
         * space: O(MN)
         *
         * Runtime: 8 ms, faster than 60.15% of Java online submissions for Edit Distance.
         * Memory Usage: 45.5 MB, less than 11.45% of Java online submissions for Edit Distance.
         *
         * @param word1 -
         * @param word2 -
         * @return -
         */
        public int minDistance(String word1, String word2) {
            final int m = word1.length();
            final int n = word2.length();
            int[][] dp = new int[m+1][n+1];
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int i = 0; i <= n; i++) {
                dp[0][i] = i;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = min(dp[i-1][j]+1
                                , dp[i][j-1]+1
                                , dp[i-1][j-1]+1
                        );
                    }
                }

            }
            return dp[m][n];
        }

        private static int min(int a, int b, int c) {
            int res = Math.min(a, b);
            res = Math.min(res, c);
            return res;
        }
    }
}
