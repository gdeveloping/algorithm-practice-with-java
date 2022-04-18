package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.easy;

/**
 * 53.
 * Easy
 *
 * @author gdev
 * @date 2022/4/16 10:47
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {5,4,-1,7,8};
        System.out.println((new Solution1()).maxSubArray(nums1));
        System.out.println((new Solution1()).maxSubArray(nums2));
        System.out.println();
        System.out.println((new Solution2()).maxSubArray(nums1));
        System.out.println((new Solution2()).maxSubArray(nums2));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 2 ms, faster than 60.29% of Java online submissions for Maximum Subarray.
         * Memory Usage: 52.2 MB, less than 80.24% of Java online submissions for Maximum Subarray.
         *
         * largest sum
         *
         * @param nums -
         * @return -
         */
        public int maxSubArray(int[] nums) {
            final int size = nums.length;
            int[] dp = new int[size];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < size; i++) {
                dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
         * Memory Usage: 51.9 MB, less than 82.14% of Java online submissions for Maximum Subarray.
         *
         * @param nums -
         * @return -
         */
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int pre = nums[0];
            int cur;
            for (int i = 1; i < nums.length; i++) {
                cur = nums[i] + (pre > 0 ? pre : 0);
                pre = cur;
                max = Math.max(max, cur);
            }
            return max;
        }
    }

}
