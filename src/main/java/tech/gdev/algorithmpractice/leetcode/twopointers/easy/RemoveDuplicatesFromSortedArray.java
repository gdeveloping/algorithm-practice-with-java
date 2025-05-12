package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

import java.util.Arrays;

/**
 * 26.
 * Easy
 * Remove Duplicates from Sorted Array
 *
 * @author gdev
 * @date 2025/5/12 22:26
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        testSolution1(new int[]{1,1,2}); // 2
        testSolution1(new int[]{0,0,1,1,1,2,2,3,3,4}); // 5
    }

    private static void testSolution1(int[] nums) {
        System.out.println("\n***");
        int res = new Solution1().removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * time: 0ms, 100.00%
         * space: 44.18MB, 24.23%
         */
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int count = 1;
            int lastUnique = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    continue;
                }
                count++;
                nums[lastUnique + 1] = nums[i];
                lastUnique++;
            }
            return count;
        }
    }
}
