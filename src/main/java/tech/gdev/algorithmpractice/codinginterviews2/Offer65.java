package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 65
 * Easy
 *
 * @author gdev
 * @date 2022/7/24 19:17
 */
public class Offer65 {
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int res;
        res = s1.add(123, 456);
        System.out.println(res);
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         * modify source: N
         *
         * @param a -
         * @param b -
         * @return -
         */
        public int add(int a, int b) {
            int sum = a, carry;
            while (b != 0) {
                carry = (a & b) << 1;
                sum = a ^ b;
                a = sum;
                b = carry;
            }
            return sum;
        }
    }
}
