package tech.gdev.algorithmpractice.leetcode.binarysearch.hard;

import java.util.Objects;

/**
 * 4.
 * Hard
 *
 * @author gdev
 * @date 2022/5/2 10:31
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        test1(new int[]{1,3}, new int[]{2}, 2);
        test1(new int[]{1,2}, new int[]{3, 4}, 2.5);

        System.out.println();
        test1b(new int[]{1,3}, new int[]{2}, 2);
        test1b(new int[]{1,2}, new int[]{3, 4}, 2.5);
    }

    private static void test1(int[] nums1, int[] nums2, double output) {
        Solution1 solution1 = new Solution1();
        double res = solution1.findMedianSortedArrays(nums1, nums2);
        System.out.println("res: " + res + "\tsuccess: " + (Objects.equals(res, output)));
    }

    private static void test1b(int[] nums1, int[] nums2, double output) {
        Solution1b solution1b = new Solution1b();
        double res = solution1b.findMedianSortedArrays(nums1, nums2);
        System.out.println("res: " + res + "\tsuccess: " + (Objects.equals(res, output)));
    }

    private static class Solution1 {
        /**
         * time: O(log(m+n))
         * space: O(1)
         *
         * Runtime: 5 ms, faster than 38.26% of Java online submissions for Median of Two Sorted Arrays.
         * Memory Usage: 49.8 MB, less than 49.87% of Java online submissions for Median of Two Sorted Arrays.
         *
         * @param nums1 -
         * @param nums2 -
         * @return -
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            if (len % 2 == 0) {
                double left = findKthHelper(nums1, 0, nums2, 0, len/2);
                double right = findKthHelper(nums1, 0, nums2, 0, len/2+1);
                return left + (right - left) / 2;
            } else {
                return findKthHelper(nums1, 0, nums2, 0, len/2+1);
            }
        }

        private static int findKthHelper(int[] A, int aStart, int[] B, int bStart, int k) {
            if (aStart >= A.length) {
                return B[bStart+k-1];
            }
            if (bStart >= B.length) {
                return A[aStart+k-1];
            }
            if (k == 1) {
                return Math.min(A[aStart], B[bStart]);
            }
            // length of A[aStart, aMid] == k / 2
            int aMid = aStart + k / 2 - 1;
            int bMid = bStart + k / 2 - 1;
            int aVal = (aMid >= A.length) ? Integer.MAX_VALUE : A[aMid];
            int bVal = (bMid >= B.length) ? Integer.MAX_VALUE : B[bMid];
            // a.left, a[mid], a.right
            // b.left, b[mid], b.right
            if (aVal <= bVal) {
                // a.left < all[k]
                // a.right + b
                return findKthHelper(A, aMid+1, B, bStart, k-k/2);
            } else {
                // a + b.right
                // b.left < all[k]
                return findKthHelper(A, aStart, B, bMid+1, k-k/2);
            }
        }
    }

    private static class Solution1b {
        /**
         * time: O(log(m+n))
         * space: O(1)
         *
         * Runtime: 4 ms, faster than 58.18% of Java online submissions for Median of Two Sorted Arrays.
         * Memory Usage: 48.3 MB, less than 72.40% of Java online submissions for Median of Two Sorted Arrays.
         *
         * @param nums1 -
         * @param nums2 -
         * @return -
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            if (len % 2 == 0) {
                double left = findKthHelper(nums1, 0, nums2, 0, len/2);
                double right = findKthHelper(nums1, 0, nums2, 0, len/2+1);
                return left + (right - left) / 2;
            } else {
                return findKthHelper(nums1, 0, nums2, 0, len/2+1);
            }
        }

        private static int findKthHelper(int[] A, int aStart, int[] B, int bStart, int k) {
            while (true) {
                if (aStart >= A.length) {
                    return B[bStart + k - 1];
                }
                if (bStart >= B.length) {
                    return A[aStart + k - 1];
                }
                if (k == 1) {
                    return Math.min(A[aStart], B[bStart]);
                }
                // length of A[aStart, aMid] == k / 2
                int aMid = aStart + k / 2 - 1;
                int bMid = bStart + k / 2 - 1;
                int aVal = (aMid >= A.length) ? Integer.MAX_VALUE : A[aMid];
                int bVal = (bMid >= B.length) ? Integer.MAX_VALUE : B[bMid];
                // a.left, a[mid], a.right
                // b.left, b[mid], b.right
                if (aVal <= bVal) {
                    // a.left < all[k]
                    // a.right + b
                    aStart = aMid + 1;
                    k -= k / 2;
                } else {
                    // a + b.right
                    // b.left < all[k]
                    bStart = bMid + 1;
                    k -= k / 2;
                }
            }
        }
    }
}
