package tech.gdev.algorithmpractice.leetcode.binarysearch.medium;

import java.util.Objects;

/**
 * 162.
 * Medium
 *
 * @author gdev
 * @date 2022/5/2 09:47
 */
public class FindPeakElement {

    public static void main(String[] args) {
        test1(new int[]{1,2,3,1}, 2);
        test1(new int[]{1,2,1,3,5,6,4}, 5);
    }

    private static void test1(int[] nums, int output) {
        Solution1 solution1 = new Solution1();
        int res = solution1.findPeakElement(nums);
        System.out.println("res: " + res + "\tsuccess: " + (Objects.equals(res, output)));
    }

    private static class Solution1 {
        /**
         * time: O(logN)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
         * Memory Usage: 43.1 MB, less than 36.64% of Java online submissions for Find Peak Element.
         *
         * Lets say you have a mid number at index x, nums[x]
         *
         * if (num[x+1] > nums[x]), that means a peak element HAS to exist on the right half of that array,
         * because (since every number is unique)
         * 1. the numbers keep increasing on the right side, and the peak will be the last element.
         * 2. the numbers stop increasing and there is a 'dip',
         * or there exists somewhere a number such that nums[y] < nums[y-1],
         * which means number[x] is a peak element.
         *
         * This same logic can be applied to the left hand side (nums[x] < nums[x-1]).
         *
         * @param nums -
         * @return -
         */
        public int findPeakElement(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < nums[mid+1]) {
                    // up
                    left = mid + 1;
                } else {
                    // nums[mid] > nums[mid+1]
                    // down
                    right = mid;
                }
            }
            // left == right
            return left;
        }
    }
}
