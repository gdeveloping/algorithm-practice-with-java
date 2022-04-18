package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * 300.
 * Medium
 *
 * @author gdev
 * @date 2022/4/18 21:19
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums1 = new int[]{10,9,2,5,3,7,101,18}; // 4
        int[] nums2 = new int[]{0,1,0,3,2,3}; // 4
        int[] nums3 = new int[]{7,7,7,7,7,7,7}; // 1

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.lengthOfLIS(nums1));
        System.out.println(solution1.lengthOfLIS(nums2));
        System.out.println(solution1.lengthOfLIS(nums3));
    }

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N)
         *
         * Runtime: 62 ms, faster than 58.90% of Java online submissions for Longest Increasing Subsequence.
         * Memory Usage: 41.7 MB, less than 89.30% of Java online submissions for Longest Increasing Subsequence.
         *
         * @param nums -
         * @return -
         */
        public int lengthOfLIS(int[] nums) {
            final int size = nums.length;
            int[] dp = new int[size];
            Arrays.fill(dp, 1);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < size; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
