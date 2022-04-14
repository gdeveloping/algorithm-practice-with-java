package tech.gdev.algorithmpractice.leetcode.sort.medium;

import java.util.Arrays;

/**
 * 912.
 * Medium
 *
 * @author gdev
 * @date 2022/4/14 22:22
 */
public class SortAnArray {
    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
//        (new Solution1()).sortArray(nums);
        (new Solution2()).sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static class Solution1 {
        /**
         * time: O(NlogN)
         * space: O(1)
         *
         * Runtime: 1853 ms, faster than 7.04% of Java online submissions for Sort an Array.
         * Memory Usage: 56.2 MB, less than 80.57% of Java online submissions for Sort an Array.
         *
         * quickSort
         *
         * @param nums -
         * @return -
         */
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length-1);
            return nums;
        }

        private void quickSort(int[] nums, int left, int right) {
            if (left >= right) {return;}
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot-1);
            quickSort(nums, pivot+1, right);
        }

        private int partition(int[] arr, int left, int right) {
            int value = arr[left];
            int i = left;
            int j = right + 1;
            while (true) {
                while (i < right && arr[++i] <= value);
                while (j > left && arr[--j] > value);
                if (i >= j) {break;}
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
         * time: O(NlogN)
         * space: O(1)
         *
         * Runtime: 12 ms, faster than 77.42% of Java online submissions for Sort an Array.
         * Memory Usage: 51.2 MB, less than 93.52% of Java online submissions for Sort an Array.
         *
         * @param nums -
         * @return -
         */
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length <= 1) {return nums;}
            final int size = nums.length;
            int step = nums.length / 2;
            while (step > 0) {
                for (int i = step; i < size; i++) {
                    int value = nums[i];
                    int j = i - step;
                    while (j >= 0 && nums[j] > value) {
                        nums[j+step] = nums[j];
                        j -= step;
                    }
                    nums[j+step] = value;
                }
                step /= 2;
            }
            return nums;
        }
    }
}
