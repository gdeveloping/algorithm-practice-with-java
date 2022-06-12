package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.easy;

/**
 * 121.
 * Easy
 *
 * @author gdev
 * @date 2022/4/18 20:38
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] nums1 = new int[]{7,1,5,3,6,4}; // 5
        int[] nums2 = new int[]{7,6,4,3,1}; // 0

        Solution1 s1 = new Solution1();
        System.out.println(s1.maxProfit(nums1));
        System.out.println(s1.maxProfit(nums2));
    }


    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
         * Memory Usage: 59 MB, less than 85.23% of Java online submissions for Best Time to Buy and Sell Stock.
         *
         * @param prices -
         * @return -
         */
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                maxProfit = Math.max(maxProfit, prices[i]-minPrice);
            }
            return maxProfit;
        }
    }

    private static class Solution2 {
        /**
         *
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 4 ms, faster than 22.69% of Java online submissions for Best Time to Buy and Sell Stock.
         * Memory Usage: 76.8 MB, less than 64.17% of Java online submissions for Best Time to Buy and Sell Stock.
         *
         * action: [buy, sell, rest]
         * status: dp[i][max k transactions][if hold]
         * k = 1 --> i10, i11
         *
         * @param prices -
         * @return -
         */
        public int maxProfit(int[] prices) {
            int i10 = 0, i11 = Integer.MIN_VALUE;
            for (int price : prices) {
                i10 = Math.max(i10, i11 + price);
                i11 = Math.max(i11, -price);
            }
            return i10;
        }
    }
}
