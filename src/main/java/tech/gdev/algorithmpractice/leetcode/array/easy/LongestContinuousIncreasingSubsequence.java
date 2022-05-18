package tech.gdev.algorithmpractice.leetcode.array.easy;

/**
 * 674.
 * Easy
 *
 * @author gdev
 * @date 2022/5/18 22:32
 */
public class LongestContinuousIncreasingSubsequence {

    private static class Solution {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 2 ms, faster than 33.24% of Java online submissions for Longest Continuous Increasing Subsequence.
         * Memory Usage: 45.3 MB, less than 66.82% of Java online submissions for Longest Continuous Increasing Subsequence.
         *
         * @param nums -
         * @return -
         */
        public int findLengthOfLCIS(int[] nums) {
            int count = 1;
            int res = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i-1]) {
                    count++;
                } else {
                    res = Math.max(res, count);
                    count = 1;
                }
            }
            res = Math.max(res, count);
            return res;
        }
    }
}
