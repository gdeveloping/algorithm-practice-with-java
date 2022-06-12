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
        Solution1 s1 = new Solution1();
        prices = new int[]{7,1,5,3,6,4};
        output = 7;
        res = s1.maxProfit(prices);
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

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 2 ms, faster than 32.84% of Java online submissions for Best Time to Buy and Sell Stock II.
         * Memory Usage: 43.8 MB, less than 67.20% of Java online submissions for Best Time to Buy and Sell Stock II.
         *
         * action: [buy, sell, rest]
         * status: dp[i][max k transactions][if hold]
         * k = +Infinity --> ik0, ik1
         *
         * @param prices -
         * @return -
         */
        public int maxProfit(int[] prices) {
            int ik0 = 0, ik1 = Integer.MIN_VALUE;
            for (int price : prices) {
                int ik0Old = ik0;
                ik0 = Math.max(ik0, ik1 + price);
                ik1 = Math.max(ik1, ik0Old - price);
            }
            return ik0;
        }
    }
}
