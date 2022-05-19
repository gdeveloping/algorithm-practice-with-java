package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 309.
 * Medium
 *
 * @author gdev
 * @date 2022/5/19 10:31
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 1 ms, faster than 86.89% of Java online submissions for Best Time to Buy and Sell Stock with Cooldown.
         * Memory Usage: 42.2 MB, less than 49.90% of Java online submissions for Best Time to Buy and Sell Stock with Cooldown.
         *
         * buy[i]: Max profit till index i. The series of transaction is ending with a buy.
         * sell[i]: Max profit till index i. The series of transaction is ending with a sell.
         * Till index i, the buy / sell action must happen and must be the last action.
         * It may not happen at index i. It may happen at i - 1, i - 2, ... 0.
         *
         * buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
         * sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
         *
         * Optimize to O(1) Space
         * b0 = Math.max(b1, s2 - prices[i]);
         * s0 = Math.max(s1, b1 + prices[i]);
         *
         * @param prices -
         * @return -
         */
        public int maxProfit(int[] prices) {
            int b1 = -prices[0];  // buy[i-1]
            int b0 = b1; // buy[i]
            int s2 = 0; // sell[i-2]
            int s1 = 0; // sell[i-1]
            int s0 = 0; // sell[i]

            for (int i = 1; i < prices.length; i++) {
                b0 = Math.max(b1, s2 - prices[i]);
                s0 = Math.max(s1, b1 + prices[i]);
                b1 = b0;
                s2 = s1;
                s1 = s0;
            }
            return s0;
        }
    }
}
