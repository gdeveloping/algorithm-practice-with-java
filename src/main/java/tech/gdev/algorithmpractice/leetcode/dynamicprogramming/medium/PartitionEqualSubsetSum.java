package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 416.
 * Medium
 *
 * @author gdev
 * @date 2022/5/18 22:43
 */
public class PartitionEqualSubsetSum {

    private static class Solution1 {
        /**
         * time: O(MN) N:len(nums) M:sum(nums)/2
         * space: O(M)
         *
         * Runtime: 28 ms, faster than 82.33% of Java online submissions for Partition Equal Subset Sum.
         * Memory Usage: 40.7 MB, less than 96.21% of Java online submissions for Partition Equal Subset Sum.
         *
         * @param nums -
         * @return -
         */
        public boolean canPartition(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0) {
                return false;
            }
            int half =  (int) (sum / 2);

            boolean[] dp = new boolean[half+1];
            dp[0] = true;
            for (int i = 0; i < nums.length; i++) {
                for (int j = half; j >= nums[i]; j--) {
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }
            return dp[half];
        }
    }
}
