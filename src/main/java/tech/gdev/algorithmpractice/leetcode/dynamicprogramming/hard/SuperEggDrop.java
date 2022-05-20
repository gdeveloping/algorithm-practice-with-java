package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.hard;

/**
 * 887.
 * Hard
 *
 * @author gdev
 * @date 2022/5/20 16:38
 */
public class SuperEggDrop {

    private static class Solution1 {
        /**
         * time: O(KN^2)
         * space: O(KN)
         *
         * Time Limit Exceeded
         *
         * @param k -
         * @param n -
         * @return -
         */
        public int superEggDrop(int k, int n) {
            int[][] dp = new int[k+1][n+1];
            for (int i = 1; i <= n; i++) {
                dp[1][i] = i;
            }
            for (int i = 2; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int x = 1; x <= j; x++) {
                        dp[i][j] = Math.min(dp[i][j],
                                1 + Math.max(dp[i-1][x-1], dp[i][j-x]));
                    }
                }
            }
            return dp[k][n];
        }
    }

    private static class Solution2 {
        /**
         * time: O(KN^2)
         * space: O(KN)
         *
         * Time Limit Exceeded
         *
         * @param k -
         * @param n -
         * @return -
         */
        public int superEggDrop(int k, int n) {
            memo = new int[k+1][n+1];
            return helper(k, n);
        }

        int[][] memo;

        private int helper(int k, int n) {
            if (memo[k][n] > 0) {
                return memo[k][n];
            }
            if (k == 1) {
                return n;
            }
            if (n == 0) {
                return 0;
            }
            int res = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++) {
                res = Math.min(res,
                        1 + Math.max(helper(k-1, i-1), helper(k, n-i)));
            }
            memo[k][n] = res;
            return res;
        }
    }

    private static class Solution3 {
        /**
         * time: O(KNlog(N))
         * space: O(KN)
         *
         * Runtime: 119 ms, faster than 15.97% of Java online submissions for Super Egg Drop.
         * Memory Usage: 54.5 MB, less than 27.79% of Java online submissions for Super Egg Drop.
         *
         * @param k -
         * @param n -
         * @return -
         */
        public int superEggDrop(int k, int n) {
            int[][] dp = new int[k+1][n+1];
            for (int i = 1; i <= n; i++) {
                dp[1][i] = i;
            }
            for (int i = 2; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                    int low = 1, high = j;
                    while (low <= high) {
                        int mid = low + (high - low) / 2;
                        int broken = dp[i-1][mid-1];
                        int notBroken = dp[i][j-mid];
                        if (broken == notBroken) {
                            dp[i][j] = broken + 1;
                            break;
                        } else if (broken > notBroken) {
                            high = mid - 1;
                            dp[i][j] = Math.min(dp[i][j], broken+1);
                        } else {
                            low = mid + 1;
                            dp[i][j] = Math.min(dp[i][j], notBroken+1);
                        }
                    }
                }
            }
            return dp[k][n];
        }
    }

    private static class Solution4 {
        /**
         * time: O(KN)
         * space: O(KN)
         *
         * Runtime: 12 ms, faster than 71.05% of Java online submissions for Super Egg Drop.
         * Memory Usage: 54.1 MB, less than 38.60% of Java online submissions for Super Egg Drop.
         *
         * @param k -
         * @param n -
         * @return -
         */
        public int superEggDrop(int k, int n) {
            int[][] dp = new int[k+1][n+1];
            int j = 0;
            while (dp[k][j] < n) {
                j++;
                for (int i = 1; i <= k; i++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1] + 1;
                }
            }
            return j;
        }
    }

}
