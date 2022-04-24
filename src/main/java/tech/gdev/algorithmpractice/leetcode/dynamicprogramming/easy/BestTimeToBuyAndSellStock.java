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

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(nums1));
        System.out.println(solution.maxProfit(nums2));
    }


    private static class Solution {
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
}
