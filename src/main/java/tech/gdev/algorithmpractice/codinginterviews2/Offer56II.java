package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 56II
 * Medium
 *
 * @author gdev
 * @date 2022/7/17 10:00
 */
public class Offer56II {
    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * a bit, 3 times:
         * 00 --> 01 --> 10 --> 00
         *
         * calc one:
         *
         * if two == 0:
         *   if n == 0:
         *     one = one
         *   if n == 1:
         *     one = ~one
         * if two == 1:
         *     one = 0
         *
         * if two == 0:
         *     one = one ^ n
         * if two == 1:
         *     one = 0
         *
         * one = one ^ num & ~two
         *
         * @param nums -
         * @return -
         */
        public int singleNumber(int[] nums) {
            int one = 0, two = 0;
            for (int num : nums) {
                one = one ^ num & ~two;
                two = two ^ num & ~one;
            }
            return one;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * @param nums -
         * @return -
         */
        public int singleNumber(int[] nums) {
            int[] bits = new int[32]; // low to high
            for (int num : nums) {
                for (int i = 0; i < bits.length; i++) {
                    bits[i] += (num & (1 << i)) > 0 ? 1 : 0;
                }
            }
            int res = 0;
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] % 3 == 1) {
                    res |= (1 << i);
                }
            }
            return res;
        }
    }
}
