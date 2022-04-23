package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

/**
 * 392.
 * Easy
 *
 * @author gdev
 * @date 2022/4/23 21:57
 */
public class IsSubsequence {

    private static class Solution1 {
        /**
         * time: O(M+N)
         * space: O(1)
         *
         * Runtime: 2 ms, faster than 34.34% of Java online submissions for Is Subsequence.
         * Memory Usage: 42.5 MB, less than 16.23% of Java online submissions for Is Subsequence.
         *
         * @param s -
         * @param t -
         * @return -
         */
        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {return false;}
            int i, j;
            i = 0; j = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
                j++;
            }
            return i == s.length();
        }
    }

    private static class Solution2 {
        /**
         * time: O(MN)
         * space: O(MN)
         *
         * Runtime: 5 ms, faster than 8.35% of Java online submissions for Is Subsequence.
         * Memory Usage: 42.3 MB, less than 27.21% of Java online submissions for Is Subsequence.
         *
         * @param s -
         * @param t -
         * @return -
         */
        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {return false;}
            final int m = s.length();
            final int n = t.length();
            boolean[][] dp = new boolean[m+1][n+1];
            for (int i = 0; i <= m; i++) {
                dp[i][0] = false;
            }
            for (int i = 0; i <= n; i++) {
                dp[0][i] = true;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i-1) == t.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
            return dp[m][n];
        }
    }

    private static class Solution3 {
        /**
         * time: O(M+N)
         * space: O(M)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Subsequence.
         * Memory Usage: 40.3 MB, less than 83.69% of Java online submissions for Is Subsequence.
         *
         * @param s -
         * @param t -
         * @return -
         */
        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {return false;}
            int past = -1;
            for (char c : s.toCharArray()) {
                past = t.indexOf(c, past+1);
                if (past == -1) {
                    return false;
                }
            }
            return true;
        }
    }
}
