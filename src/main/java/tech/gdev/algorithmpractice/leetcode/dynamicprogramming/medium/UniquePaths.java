package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 62.
 * Medium
 *
 * @author gdev
 * @date 2022/5/16 14:34
 */
public class UniquePaths {

    private static class Solution1 {
        /**
         * time: O(MN)
         * space: O(MN)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
         * Memory Usage: 39.9 MB, less than 73.06% of Java online submissions for Unique Paths.
         *
         * @param m -
         * @param n -
         * @return -
         */
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < n; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
            return dp[m-1][n-1];
        }
    }


    private static class Solution2 {
        /**
         * time: O(MN)
         * space: O(N)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
         * Memory Usage: 40.5 MB, less than 68.69% of Java online submissions for Unique Paths.
         *
         * @param m -
         * @param n -
         * @return -
         */
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j] + dp[j-1];
                }
            }
            return dp[n-1];
        }
    }


    private static class Solution3 {
        /**
         * time: O(M+N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
         * Memory Usage: 38.6 MB, less than 99.12% of Java online submissions for Unique Paths.
         *
         * for example:
         * 3x7 matrix.
         * C(10,3) = 10! / (7! * 3!) => (m+n)! / (m!*n!)
         *
         * @param m -
         * @param n -
         * @return -
         */
        public int uniquePaths(int m, int n) {
            if (m == 1 || n == 1) {
                return 1;
            }
            // path, excluding start and target point
            m--;
            n--;
            // swap, guarantee m >= n
            if (m < n) {
                int temp = m;
                m = n;
                n = temp;
            }
            long res = 1;
            // (m+n)! / (m!*n!)  ==>  [m+1,m+n]! / [1,n]!
            // len() = n
            for (int i = m+1, j = 1; i <= m+n; i++, j++) {
                res *= i;
                res /= j;
            }
            return (int) res;
        }
    }
}
