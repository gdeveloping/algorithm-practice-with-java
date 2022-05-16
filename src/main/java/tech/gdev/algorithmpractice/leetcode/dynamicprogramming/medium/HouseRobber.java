package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 198.
 * Medium
 *
 * @author gdev
 * @date 2022/5/16 17:44
 */
public class HouseRobber {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 1 ms, faster than 17.65% of Java online submissions for House Robber.
         * Memory Usage: 40.6 MB, less than 71.96% of Java online submissions for House Robber.
         *
         * @param nums -
         * @return -
         */
        public int rob(int[] nums) {
            int rob = 0;
            int notRob = 0;
            for (int i = 0; i < nums.length; i++) {
                int curRob = notRob + nums[i];
                notRob = Math.max(notRob, rob);
                rob = curRob;
            }
            return Math.max(rob, notRob);
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
         * Memory Usage: 42.1 MB, less than 15.77% of Java online submissions for House Robber.
         *
         * @param nums -
         * @return -
         */
        public int rob(int[] nums) {
            final int size = nums.length;
            if (size == 1) {return nums[0];}
            int[] dp = new int[size];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < size; i++) {
                dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            }
            return dp[size-1];
        }
    }
}
