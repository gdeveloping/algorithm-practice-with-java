package tech.gdev.algorithmpractice.leetcode.twopointers.medium;

import java.util.Arrays;

/**
 * 75.
 * Medium
 *
 * @author gdev
 * @date 2022/4/25 21:21
 */
public class SortColors {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,0,2,1,1,0};
        int[] nums2 = new int[]{2,0,1};
        Solution1 solution1 = new Solution1();
        solution1.sortColors(nums1);
        System.out.println(Arrays.toString(nums1));
        solution1.sortColors(nums2);
        System.out.println(Arrays.toString(nums2));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
         * Memory Usage: 42.4 MB, less than 58.21% of Java online submissions for Sort Colors.
         *
         * @param nums -
         */
        public void sortColors(int[] nums) {
            if (nums.length <= 1) {return;}
            int left = 0;
            int right = nums.length-1;
            int index = 0;
            while (index <= right) {
                if (nums[index] == 0) {
                    swap(nums, left, index);
                    left++;
                    index++;
                } else if (nums[index] == 1) {
                    index++;
                } else {
                    swap(nums, right, index);
                    right--;
                }
            }
        }

        private static void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

}
