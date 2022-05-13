package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.hard;

/**
 * 188.
 * Hard
 *
 * @author gdev
 * @date 2022/5/13 09:23
 */
public class BestTimeToBuyAndSellStockIV {

    private static class Solution1 {
        /**
         * time: O(NK)
         * space: O(NK)
         *
         * Runtime: 10 ms, faster than 34.58% of Java online submissions for Best Time to Buy and Sell Stock IV.
         * Memory Usage: 45.5 MB, less than 22.30% of Java online submissions for Best Time to Buy and Sell Stock IV.
         *
         * @param k -
         * @param prices -
         * @return -
         */
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0 || k == 0) {
                return 0;
            }
            if (k >= prices.length / 2) {
                return quickSolve(prices);
            }

            final int length = prices.length;
            // dp[day][max transaction times][if hold]
            int[][][] dp = new int[length][k+1][2];
            for (int j = 1; j <= k; j++) {
                dp[0][j][0] = 0;
                dp[0][j][1] = -prices[0];
            }

            for (int i = 1; i < length; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
                }
            }
            return dp[length-1][k][0];
        }

        private int quickSolve(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                // as long as there is a price gap, we gain a profit.
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
    }

    private static class Solution2 {
        /**
         * time: O(NK)
         * space: O(NK)
         *
         * Runtime: 3 ms, faster than 71.04% of Java online submissions for Best Time to Buy and Sell Stock IV.
         * Memory Usage: 42.9 MB, less than 43.41% of Java online submissions for Best Time to Buy and Sell Stock IV.
         *
         * @param k -
         * @param prices -
         * @return -
         */
        public int maxProfit(int k, int[] prices) {
            if (prices == null || prices.length == 0 || k == 0) {
                return 0;
            }
            if (k >= prices.length / 2) {
                return quickSolve(prices);
            }

            final int length = prices.length;
            int[][] dp = new int[k+1][length];
            for (int i = 1; i <= k; i++) {
                int localMax = dp[i-1][0] - prices[0];
                for (int j = 1; j < length; j++) {
                    dp[i][j] = Math.max(dp[i][j-1], prices[j] + localMax);
                    localMax = Math.max(dp[i-1][j] - prices[j], localMax);
                }
            }
            return dp[k][length-1];
        }

        private int quickSolve(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                // as long as there is a price gap, we gain a profit.
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
    }
}
