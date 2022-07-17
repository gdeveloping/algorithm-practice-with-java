package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 56I
 * Medium
 *
 * @author gdev
 * @date 2022/7/17 09:17
 */
public class Offer56I {
    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * @param nums -
         * @return -
         */
        public int[] singleNumbers(int[] nums) {
            int k = 0;
            for (int num : nums) {
                k ^= num;
            }
            int j = 1;
            while ((j & k) == 0) {
                j <<= 1;
            }
            int a = 0;
            int b = 0;
            for (int num : nums) {
                if ((num & j) == 0) {
                    a ^= num;
                } else {
                    b ^= num;
                }
            }
            return new int[]{a, b};
        }
    }
}
