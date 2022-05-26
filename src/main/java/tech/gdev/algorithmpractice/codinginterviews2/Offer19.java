package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 19
 * Hard
 *
 * like leetcode 10 RegularExpressionMatching
 *
 * @author gdev
 * @date 2022/5/26 23:00
 */
public class Offer19 {
    private static class Solution1 {
        /**
         * time: O(MN), M:len(s), N:len(p)
         * space: O(MN)
         *
         * @param s -
         * @param p -
         * @return -
         */
        public boolean isMatch(String s, String p) {
            if (s == null || p == null) {
                return false;
            }
            final char symbolStar = '*';
            final char symbolComma = '.';
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (p.charAt(j-1) != symbolStar) {
                        if (i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == symbolComma)) {
                            dp[i][j] = dp[i-1][j-1];
                        }
                    } else {
                        // * match 0 times
                        if (j >= 2) {
                            dp[i][j] = dp[i][j] || dp[i][j-2];
                        }
                        // * match many times
                        if (i >= 1 && j >= 2 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == symbolComma)) {
                            dp[i][j] = dp[i][j] || dp[i-1][j];
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}
