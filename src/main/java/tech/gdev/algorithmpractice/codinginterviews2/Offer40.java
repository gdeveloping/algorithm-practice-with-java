package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 40
 * Easy
 *
 * @author gdev
 * @date 2022/6/1 20:59
 */
public class Offer40 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source data
         *
         * @param arr -
         * @param k -
         * @return -
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {return new int[0];}
            if (k >= arr.length) {return arr;}
            k--;
            int low = 0;
            int high = arr.length - 1;
            int pivot = partition(arr, low, high);
            while (pivot != k) {
                if (pivot < k) {
                    low = pivot + 1;
                } else {
                    high = pivot - 1;
                }
                pivot = partition(arr, low, high);
            }
            return Arrays.copyOf(arr, k+1);
        }

        private int partition(int[] arr, int low, int high) {
            int value = arr[low];
            int i = low;
            int j = high + 1;
            while (true) {
                while (i < high && arr[++i] <= value);
                while (j > low && arr[--j] > value);
                if (i >= j) {break;}
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if (low != j) {
                arr[low] = arr[j];
                arr[j] = value;
            }
            return j;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N*log(K))
         * space: O(K)
         *
         * @param arr -
         * @param k -
         * @return -
         */
        public int[] getLeastNumbers(int[] arr, int k) {
            if (k == 0) {return new int[0];}
            if (k >= arr.length) {return arr;}
            PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            for (int num : arr) {
                if (queue.size() < k) {
                    queue.offer(num);
                } else if (queue.peek() > num) {
                    queue.offer(num);
                    queue.poll();
                }
            }
            int[] res = new int[queue.size()];
            int i = 0;
            while (!queue.isEmpty()) {
                res[i++] = queue.poll();
            }
            return res;
        }
    }
}
