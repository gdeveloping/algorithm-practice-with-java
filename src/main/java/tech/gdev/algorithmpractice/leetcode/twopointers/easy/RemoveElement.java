package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

import java.util.Arrays;

/**
 * 27.
 * Easy
 * Remove Element
 *
 * @author gdev
 * @date 2025/5/12 22:55
 */
public class RemoveElement {
    public static void main(String[] args) {
        testSolution1(new int[]{3,2,2,3}, 3); // 2
        testSolution1(new int[]{0,1,2,2,3,0,4,2}, 2); // 5
    }

    private static void testSolution1(int[] nums, int val) {
        System.out.println("\n***");
        int res = new Solution1().removeElement(nums, val);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * time: 0ms, 100.00%
         * space: 41.14MB, 57.64%
         */
        public int removeElement(int[] nums, int val) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int count = 0;
            int lastValid = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    continue;
                }
                count++;
                nums[lastValid + 1] = nums[i];
                lastValid++;
            }
            return count;
        }
    }
}
