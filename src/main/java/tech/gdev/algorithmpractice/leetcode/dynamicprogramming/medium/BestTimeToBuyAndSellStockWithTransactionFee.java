package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 714.
 * Medium
 *
 * @author gdev
 * @date 2022/5/19 14:20
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 3 ms, faster than 99.49% of Java online submissions for Best Time to Buy and Sell Stock with Transaction Fee.
         * Memory Usage: 50.9 MB, less than 81.86% of Java online submissions for Best Time to Buy and Sell Stock with Transaction Fee.
         *
         * @param prices -
         * @param fee -
         * @return -
         */
        public int maxProfit(int[] prices, int fee) {
            int cash = 0;
            int hold = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                cash = Math.max(cash, hold + prices[i] - fee);
                hold = Math.max(hold, cash - prices[i]);
            }
            return cash;
        }
    }
}
