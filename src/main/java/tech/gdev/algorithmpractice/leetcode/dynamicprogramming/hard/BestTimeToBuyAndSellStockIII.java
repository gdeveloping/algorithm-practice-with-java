package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.hard;

/**
 * 123.
 * Hard
 *
 * @author gdev
 * @date 2022/5/11 22:48
 */
public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int res = solution1.maxProfit(prices);
        System.out.println(res);
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 2 ms, faster than 97.06% of Java online submissions for Best Time to Buy and Sell Stock III.
         * Memory Usage: 58.6 MB, less than 82.18% of Java online submissions for Best Time to Buy and Sell Stock III.
         *
         * @param prices -
         * @return -
         */
        public int maxProfit(int[] prices) {
            int oneBuy = Integer.MAX_VALUE;
            int twoBuy = Integer.MAX_VALUE;
            int oneBuyOneSell = 0;
            int twoBuyTwoSell = 0;
            for (int i = 0; i < prices.length; i++) {
                int p = prices[i];
                oneBuy = Math.min(oneBuy, p);
                oneBuyOneSell = Math.max(oneBuyOneSell, p - oneBuy);
                twoBuy = Math.min(twoBuy, p - oneBuyOneSell);
                twoBuyTwoSell = Math.max(twoBuyTwoSell, p - twoBuy);
            }
            return twoBuyTwoSell;
        }
    }
}
