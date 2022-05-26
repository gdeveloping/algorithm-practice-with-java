package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 14
 * Medium
 *
 * @author gdev
 * @date 2022/5/26 15:03
 */
public class Offer14 {

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N)
         *
         * @param n -
         * @return -
         */
        public int cuttingRope(int n) {
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i/2; j++) {
                    dp[i] = Math.max(dp[i],
                            Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]));
                }
            }
            return dp[n];
        }
    }


    private static class Solution2 {
        /**
         * time: O(log(N))
         * space: O(1)
         *
         * n >= 5
         * 2(n-2) > n, n > 4
         * 3(n-3) > n, n > 4.5
         * 3(n-3) >= 2(n-2), n >= 5
         *
         * n = 4
         * 4 = 2*2 > 1*3
         *
         * @param n -
         * @return -
         */
        public int cuttingRope(int n) {
            if (n == 2) {return 1;}
            if (n == 3) {return 2;}
            if (n == 4) {return 4;}
            long res = 1;
            int p = (int) 1e9 + 7;
            while (n > 4) {
                res = res * 3 % p;
                n -= 3;
            }
            res = res * n % p;
            return (int) res;
        }
    }
}
