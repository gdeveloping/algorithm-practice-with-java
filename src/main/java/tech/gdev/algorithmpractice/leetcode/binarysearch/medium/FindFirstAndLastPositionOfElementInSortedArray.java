package tech.gdev.algorithmpractice.leetcode.binarysearch.medium;

import java.util.Arrays;

/**
 * 34.
 * Medium
 *
 * @author gdev
 * @date 2022/5/1 18:02
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        test1(new int[]{5,7,7,8,8,10}, 8, new int[]{3,4});
        test1(new int[]{5,7,7,8,8,10}, 6, new int[]{-1,-1});
    }

    private static void test1(int[] nums, int target, int[] output) {
        Solution1 solution1 = new Solution1();
        int[] res = solution1.searchRange(nums, target);
        System.out.println(Arrays.toString(res) + "\t" + Arrays.equals(res, output));
    }

    private static class Solution1 {
        /**
         * time: O(logN)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
         * Memory Usage: 47 MB, less than 63.93% of Java online submissions for Find First and Last Position of Element in Sorted Array.
         *
         * @param nums -
         * @param target -
         * @return -
         */
        public int[] searchRange(int[] nums, int target) {
            int[] res = new int[2];
            res[0] = binarySearchLeft(nums, target, 0, nums.length-1);
            res[1] = binarySearchRight(nums, target, 0, nums.length-1);
            return res;
        }

        private static int binarySearchLeft(final int[] nums, final int target, int left, int right) {
            if (left > right) {
                return -1;
            }
            final int rightEnd = right;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    right = mid - 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left <= rightEnd && nums[left] == target) {
                return left;
            }
            return -1;
        }

        private static int binarySearchRight(int[] nums, int target, int left, int right) {
            if (left > right) {
                return -1;
            }
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (target == nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (right >= 0 && nums[right] == target) {
                return right;
            }
            return -1;
        }
    }

}
