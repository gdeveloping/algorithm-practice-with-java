package tech.gdev.algorithmpractice.leetcode.binarysearch.medium;

import java.util.Arrays;

/**
 * 33.
 * Medium
 *
 * @author gdev
 * @date 2022/5/1 20:09
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        test1(new int[]{4,5,6,7,0,1,2}, 0, 4);
        test1(new int[]{4,5,6,7,0,1,2}, 3, -1);
    }

    private static void test1(int[] nums, int target, int output) {
        Solution1 solution1 = new Solution1();
        int res = solution1.search(nums, target);
        System.out.println(res + "\t" + (res == output) + "\t" + Arrays.toString(nums));
    }

    private static class Solution1 {
        /**
         * time: O(logN)
         * space: O(1)
         *
         * Runtime: 1 ms, faster than 61.57% of Java online submissions for Search in Rotated Sorted Array.
         * Memory Usage: 42.3 MB, less than 62.51% of Java online submissions for Search in Rotated Sorted
         *
         * A: left, ..., max, min, ..., right
         * B: min, ..., max
         *
         * @param nums -
         * @param target -
         * @return -
         */
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                // A: left, ...(mid)..., max, min, ..., right
                // B: min, ...(mid)..., max
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        // left, ...(target)...(mid)..., max, min, ..., right
                        right = mid - 1;
                    } else {
                        // target < nums[left] || target > nums[mid]
                        // left, ...(mid)...(target)..., max, min, ..., right
                        // left, ...(mid)..., max, min, ...(target)..., right
                        left = mid + 1;
                    }
                }
                // A: left, ..., max, min, ...(mid)..., right
                // B: min, ...(mid)..., max
                // if (nums[mid] <= nums[right])
                else {
                    if (nums[mid] <= target && target <= nums[right]) {
                        // left, ..., max, min, ...(mid)...(target)..., right
                        left = mid + 1;
                    } else {
                        // target < nums[mid] || target > nums[right]
                        // left, ...(target)..., max, min, ...(mid)..., right
                        // left, ..., max, min, ...(target)...(mid)..., right
                        right = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
