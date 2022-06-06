package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 44
 * Medium
 *
 * @author gdev
 * @date 2022/6/5 20:52
 */
public class Offer44 {

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int res = s1.findNthDigit(1000000000); // 1
        System.out.println(res);
    }

    private static class Solution1 {
        /**
         * time: O(log(N))
         * space: O(log(N))
         *
         * Divisor divided by divisor equals quotient
         * x % y = 0...(y-1)
         * (x - 1) % y = x % y + 1
         *             = 0...(y-1) + 1
         *             = 1...y
         * x = 16, y = 4
         * x % y = 16 % 4 = 0
         * (x - 1) % y = 15 % 4 = 3...3
         *
         * @param n -
         * @return -
         */
        public int findNthDigit(int n) {
            if (n <= 9) {return n;}
            int digit = 1;
            long base = 1;
            long count = 9;
            while (count < n) {
                n -= count;
                digit++;
                base *= 10;
                count = digit * base * 9;
            }
            long num = base + (n - 1) / digit;
            int index = (n - 1) % digit;
            return Long.toString(num).charAt(index) - '0';
        }
    }
}
