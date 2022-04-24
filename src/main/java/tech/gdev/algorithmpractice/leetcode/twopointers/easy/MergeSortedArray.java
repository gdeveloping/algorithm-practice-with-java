package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

import java.util.Arrays;

/**
 * 88.
 * Easy
 *
 * @author gdev
 * @date 2022/4/24 22:23
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1, nums2;
        int m, n;
        nums1 = new int[]{1,2,3,0,0,0};
        m = 3;
        nums2 = new int[]{2,5,6};
        n = 3;
        Solution1 solution1 = new Solution1();
        solution1.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
         * Memory Usage: 43.5 MB, less than 6.78% of Java online submissions for Merge Sorted Array.
         *
         * @param nums1 -
         * @param m -
         * @param nums2 -
         * @param n -
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m + n - 1;
            m--;
            n--;
            while (m >= 0 && n >= 0) {
                if (nums1[m] >= nums2[n]) {
                    nums1[i--] = nums1[m--];
                } else {
                    nums1[i--] = nums2[n--];
                }
            }
            while (n >= 0) {
                nums1[i--] = nums2[n--];
            }
        }
    }
}
