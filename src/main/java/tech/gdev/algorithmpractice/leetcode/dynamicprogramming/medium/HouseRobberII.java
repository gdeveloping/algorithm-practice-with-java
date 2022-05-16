package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 213.
 * Medium
 *
 * @author gdev
 * @date 2022/5/16 21:20
 */
public class HouseRobberII {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
         * Memory Usage: 40.8 MB, less than 71.03% of Java online submissions for House Robber II.
         *
         * @param nums -
         * @return -
         */
        public int rob(int[] nums) {
            if (nums.length == 1) {return nums[0];}
            return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
        }

        public int rob(int[] nums, int low, int high) {
            int rob = 0;
            int notRob = 0;
            for (int i = low; i <= high; i++) {
                int curRob = notRob + nums[i];
                notRob = Math.max(notRob, rob);
                rob = curRob;
            }
            return Math.max(rob, notRob);
        }
    }
}
