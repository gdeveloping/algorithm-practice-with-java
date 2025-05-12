package tech.gdev.algorithmpractice.leetcode.twopointers.medium;

import java.util.Arrays;

/**
 * 167.
 * Medium
 * Two Sum II - Input Array Is Sorted
 *
 * @author gdev
 * @date 2025/5/12 23:19
 */
public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        testSolution1(new int[]{2,7,11,15}, 9); // [1,2]
        testSolution1(new int[]{2,3,4}, 6); // [1,3]
        testSolution1(new int[]{-1, 0}, -1); // [1,2]
    }

    private static void testSolution1(int[] nums, int target) {
        System.out.println("\n***");
        int[] res = new Solution1().twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }


    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * time: 1ms, 99.44%
         * space: 46.49MB, 34.89%
         *
         * 已知：仅存在一个有效答案
         */
        public int[] twoSum(int[] numbers, int target) {
            if (numbers == null || numbers.length < 2) {
                return new int[]{-1, -1};
            }
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[] {left + 1, right + 1};
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[]{-1, -1};
        }
    }
}
