package tech.gdev.algorithmpractice.leetcode.sort.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215.
 * Medium
 *
 * @author gdev
 * @date 2022/4/13 20:24
 */
public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int k = 2;
        int[] nums2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        Solution1 s1 = new Solution1();
        System.out.println(s1.findKthLargest(nums, k));
        System.out.println(s1.findKthLargest(nums2, k2));
        Solution2 s2 = new Solution2();
        System.out.println(s2.findKthLargest(nums, k));
        System.out.println(s2.findKthLargest(nums2, k2));
        Solution3 s3 = new Solution3();
        System.out.println(s3.findKthLargest(nums, k));
        System.out.println(s3.findKthLargest(nums2, k2));
    }

    private static class Solution1 {
        /**
         *
         * time: O(NlogN)
         * space: O(1)
         *
         * Runtime: 16 ms, faster than 17.57% of Java online submissions for Kth Largest Element in an Array.
         * Memory Usage: 42.9 MB, less than 81.39% of Java online submissions for Kth Largest Element in an Array.
         *
         * quick sort
         * quick select
         *
         * @param nums -
         * @param k -
         * @return -
         */
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int pivot = partition(nums, left, right);
                if (pivot < k) {
                    left = pivot + 1;
                } else if (pivot > k) {
                    right = pivot - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }

        private int partition(int[] arr, int left, int right) {
            int value = arr[left];
            int i = left;
            int j = right + 1;
            while (true) {
                while (i < right && arr[++i] <= value);
                while (j > left && arr[--j] > value);
                if (i >= j) {
                    break;
                }
                exchange(arr, i, j);
            }
            exchange(arr, left, j);
            return j;
        }

        private void exchange(int[] arr, int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }

    private static class Solution2 {
        /**
         * time: O(NlogK)
         * space: O(K)
         *
         * Runtime: 4 ms, faster than 78.95% of Java online submissions for Kth Largest Element in an Array.
         * Memory Usage: 42.5 MB, less than 87.30% of Java online submissions for Kth Largest Element in an Array.
         *
         * @param nums -
         * @param k -
         * @return -
         */
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.offer(num);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }

    private static class Solution3 {
        /**
         * time: O(NlogN)
         * space: O(1)
         *
         * Runtime: 2 ms, faster than 93.52% of Java online submissions for Kth Largest Element in an Array.
         * Memory Usage: 42.7 MB, less than 81.72% of Java online submissions for Kth Largest Element in an Array.
         *
         * quick sort
         *
         * @param nums -
         * @param k -
         * @return -
         */
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length-k];
        }
    }
}
