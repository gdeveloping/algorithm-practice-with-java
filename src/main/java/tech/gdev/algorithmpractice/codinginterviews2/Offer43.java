package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 43
 * Hard
 *
 * @author gdev
 * @date 2022/6/4 21:37
 */
public class Offer43 {

    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int res = s1.countDigitOne(1100); // 422
        System.out.println(res);
    }

    private static class Solution1 {
        /**
         * time: O(log(N))
         * space: O(1)
         *
         * 1234 = (123 + 1) * 1
         *     + (12 + 1) * 10
         *     + (1 + 1) * 100
         *     + 0 * 1000 + 234 + 1
         * 1100 = 110 * 1
         *      + 11 * 10
         *      + 1 * 100 + 1
         *      + 0 * 1000 + 100 + 1
         *
         * @param n -
         * @return -
         */
        public int countDigitOne(int n) {
            int count = 0;
            int num = n;
            int m = 1;
            while (num > 0) {
                int p = num % 10;
                if (p == 1) {
                    count += n % m + 1;
                }
                int a = p > 1 ? 1 : 0;
                num /= 10;
                count += (a + num) * m;
                m *= 10;
            }
            return count;
        }
    }
}
