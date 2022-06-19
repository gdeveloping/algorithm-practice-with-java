package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.Arrays;

/**
 * 51
 * Hard
 *
 * @author gdev
 * @date 2022/6/19 09:35
 */
public class Offer51 {

    private static class Solution1 {
        /**
         * time: O(N*log(N))
         * space: O(N)
         * modify source: Y
         *
         * @param nums -
         * @return -
         */
        public int reversePairs(int[] nums) {
            if (nums == null || nums.length == 0) {return 0;}
            return merge(nums, 0, nums.length - 1);
        }

        private int merge(int[] nums, int left, int right) {
            if (left >= right) {return 0;}
            int mid = left + ((right - left) >> 1);
            int res = 0;
            res += merge(nums, left, mid);
            res += merge(nums, mid + 1, right);
            res += merge(nums, left, mid, right);
            return res;
        }

        private int merge(int[] nums, int left, int mid, int right) {
            if (left >= right) {return 0;}
            int[] arr = new int[right - left + 1];
            int p = left;
            int q = mid + 1;
            int index = 0;
            int count = 0;
            while (p <= mid && q <= right) {
                if (nums[p] <= nums[q]) {
                    arr[index++] = nums[p++];
                } else {
                    count += (mid - p + 1);
                    arr[index++] = nums[q++];
                }
            }
            while (p <= mid) {
                arr[index++] = nums[p++];
            }
            while (q <= right) {
                arr[index++] = nums[q++];
            }
            index = left;
            for (int i = 0; i < arr.length; i++) {
                nums[index++] = arr[i];
            }
            return count;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N*log(N)), N:len(nums)
         * space: O(N)
         * modify source: Y
         *
         * @param nums -
         * @return -
         */
        public int reversePairs(int[] nums) {
            int size = nums.length;
            // discretize
            int[] arr = new int[size];
            System.arraycopy(nums, 0, arr, 0, size);
            Arrays.sort(arr);
            for (int i = 0; i < size; i++) {
                nums[i] = Arrays.binarySearch(arr, nums[i]) + 1; // guarantee nums[i] > 0
            }
            FenwickTree tree = new FenwickTree(size);
            int res = 0;
            for (int i = size - 1; i >= 0; --i) {
                res += tree.sum(nums[i] - 1);  // less then nums[i]
                tree.update(nums[i]);
            }
            return res;
        }

        private class FenwickTree {
            private int[] tree;
            private int n;

            FenwickTree(int n) {
                this.n = n;
                this.tree = new int[n + 1];
            }

            private int lowBit(int num) {
                return num & (-num);
            }

            private int sum(int num) {
                int count = 0;
                while (num > 0) {
                    count += tree[num];
                    num -= lowBit(num);
                }
                return count;
            }

            private void update(int num) {
                while (num <= n) {
                    ++tree[num];
                    num += lowBit(num);
                }
            }
        }
    }
}
