package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

import java.util.Arrays;

/**
 * 283.
 * Easy
 * Move Zeroes
 *
 * @author gdev
 * @date 2025/5/12 23:04
 */
public class MoveZeroes {
    public static void main(String[] args) {
        testSolution1(new int[]{0,1,0,3,12});
        testSolution1(new int[]{0});
    }

    private static void testSolution1(int[] nums) {
        System.out.println("\n***");
        new Solution1().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * time: 1ms, 100.00%
         * space: 45.00MB, 58.42%
         */
        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {}
            int lastValid = -1;
            int countZero = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    countZero++;
                    continue;
                }
                nums[lastValid + 1] = nums[i];
                lastValid++;
            }
            for (int i = 0; i < countZero; i++) {
                nums[nums.length - 1 - i] = 0;
            }
        }
    }
}
