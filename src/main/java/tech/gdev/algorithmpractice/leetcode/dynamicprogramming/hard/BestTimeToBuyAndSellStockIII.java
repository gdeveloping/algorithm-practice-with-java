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
        Solution1 s1 = new Solution1();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        int res = s1.maxProfit(prices);
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

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 9 ms, faster than 40.03% of Java online submissions for Best Time to Buy and Sell Stock III.
         * Memory Usage: 78.2 MB, less than 57.44% of Java online submissions for Best Time to Buy and Sell Stock III.
         *
         * action: [buy, sell, rest]
         * status: dp[i][max k transactions][if hold]
         * k = 2 --> i10, i11, i20, i21
         *
         * @param prices -
         * @return -
         */
        public int maxProfit(int[] prices) {
            int i10 = 0, i11 = Integer.MIN_VALUE;
            int i20 = 0, i21 = Integer.MIN_VALUE;
            for (int price : prices) {
                i20 = Math.max(i20, i21 + price);
                i21 = Math.max(i21, i10 - price);
                i10 = Math.max(i10, i11 + price);
                i11 = Math.max(i11, -price);
            }
            return i20;
        }
    }
}
