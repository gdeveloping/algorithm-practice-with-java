package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 122.
 * Medium
 *
 * @author gdev
 * @date 2022/5/11 22:40
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] prices;
        int res;
        int output;
        Solution1 solution1 = new Solution1();
        prices = new int[]{7,1,5,3,6,4};
        output = 7;
        res = solution1.maxProfit(prices);
        System.out.println("res: " + res + "\toutput: " + (res == output));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 2 ms, faster than 31.16% of Java online submissions for Best Time to Buy and Sell Stock II.
         * Memory Usage: 44.6 MB, less than 25.35% of Java online submissions for Best Time to Buy and Sell Stock II.
         *
         * @param prices -
         * @return -
         */
        public int maxProfit(int[] prices) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    profit += prices[i] - prices[i-1];
                }
            }
            return profit;
        }
    }
}
