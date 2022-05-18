package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * 494.
 * Medium
 *
 * @author gdev
 * @date 2022/5/18 21:18
 */
public class TargetSum {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        int output = 5;
        System.out.println("nums: " + Arrays.toString(nums));
        int res = solution1.findTargetSumWays(nums, target);
        System.out.println("res: " + res + "\toutput: " + (res == output));
    }

    private static class Solution1 {
        /**
         * time: O(MN), N:len(nums), M:(sum(nums)+Math.abs(target))/2
         * space: O(M)
         *
         * Runtime: 2 ms, faster than 99.75% of Java online submissions for Target Sum.
         * Memory Usage: 40 MB, less than 91.88% of Java online submissions for Target Sum.
         *
         * s1 + s2 = sum
         * s1 - s2 = Math.abs(s0)
         * s1 = s2 + Math.abs(s0)
         *    = sum - s1 + Math.abs(s0)
         *    = (sum + Math.abs(s0)) / 2
         *
         * @param nums -
         * @param target -
         * @return -
         */
        public int findTargetSumWays(int[] nums, int target) {
            final int size = nums.length;
            target = Math.abs(target);
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < target || (sum + target) % 2 != 0) {
                return 0;
            }
            int s = (int) ((sum + target) / 2);
            int[] dp = new int[s+1];
            dp[0] = 1;
//            System.out.println("s: " + s);
            for (int i = 0; i < size; i++) {
                for (int j = s; j >= nums[i]; j--) {
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
//                System.out.println(Arrays.toString(dp));
            }
            return dp[s];
        }
    }
}
