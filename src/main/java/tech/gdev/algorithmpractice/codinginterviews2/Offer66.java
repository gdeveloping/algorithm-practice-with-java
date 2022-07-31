package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 66
 * Medium
 *
 * @author gdev
 * @date 2022/7/31 23:46
 */
public class Offer66 {
    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         * modify source: N
         *
         * @param a -
         * @return -
         */
        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) {
                return new int[0];
            }
            int size = a.length;
            int[] left = new int[size];
            int[] right = new int[size];
            int[] res = new int[size];
            left[0] = 1;
            for (int i = 1; i < size; i++) {
                left[i] = a[i-1] * left[i-1];
            }
            right[size-1] = 1;
            for (int i = size - 2; i >= 0; i--) {
                right[i] = a[i+1] * right[i+1];
            }
            for (int i = 0; i < size; i++) {
                res[i] = left[i] * right[i];
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * @param a -
         * @return -
         */
        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) {
                return new int[0];
            }
            int size = a.length;
            int[] res = new int[size];
            res[0] = 1;
            for (int i = 1; i < size; i++) {
                res[i] = a[i-1] * res[i-1];
            }
            int right = 1;
            for (int i = size - 1; i >= 0; i--) {
                res[i] = res[i] * right;
                right *= a[i];
            }
            return res;
        }
    }
}
