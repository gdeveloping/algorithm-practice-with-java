package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 718.
 * Medium
 *
 * @author gdev
 * @date 2022/5/19 08:40
 */
public class MaximumLengthOfRepeatedSubarray {

    private static class Solution1 {
        /**
         * time: O(MN) N:len(num1) M:len(nums2)
         * space: O(MN)
         *
         * Runtime: 40 ms, faster than 87.56% of Java online submissions for Maximum Length of Repeated Subarray.
         * Memory Usage: 51 MB, less than 78.13% of Java online submissions for Maximum Length of Repeated Subarray.
         *
         * @param nums1 -
         * @param nums2 -
         * @return -
         */
        public int findLength(int[] nums1, int[] nums2) {
            int res = 0;
            int[][] dp = new int[nums1.length+1][nums2.length+1];
            for (int i = nums1.length-1; i >= 0; i--) {
                for (int j = nums2.length-1; j >= 0; j--) {
                    if (nums1[i] == nums2[j]) {
                        dp[i][j] = 1  + dp[i+1][j+1];
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
            return res;
        }
    }

    private static class Solution1_2 {
        /**
         * time: O(MN) N:len(num1) M:len(nums2)
         * space: O(MN)
         *
         * Runtime: 63 ms, faster than 65.69% of Java online submissions for Maximum Length of Repeated Subarray.
         * Memory Usage: 73.5 MB, less than 61.47% of Java online submissions for Maximum Length of Repeated Subarray.
         *
         * @param nums1 -
         * @param nums2 -
         * @return -
         */
        public int findLength(int[] nums1, int[] nums2) {
            int res = 0;
            int[][] dp = new int[nums1.length+1][nums2.length+1];
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i-1] == nums2[j-1]) {
                        dp[i][j] = 1 + dp[i-1][j-1];
                        res = Math.max(res, dp[i][j]);
                    }
                }
            }
            return res;
        }

    }
}
