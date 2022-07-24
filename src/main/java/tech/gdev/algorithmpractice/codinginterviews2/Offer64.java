package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 64
 * Medium
 *
 * @author gdev
 * @date 2022/7/24 19:04
 */
public class Offer64 {
    private static class Solution1 {
        private static int quickMulti(int A, int B) {
            int ans = 0;
            for ( ;B > 0; B >>= 1) {
                if ((B & 1) == 1) {
                    ans += A;
                }
                A <<= 1;
            }
            return ans;
        }

        /**
         * time: O(1)
         * space: O(1)
         * modify source: N
         *
         * sum = (1 + n) * n / 2
         * 1 <= n <= 10000
         * A: n
         * B: n + 1
         * count of bits of B is less or equals than 14
         *
         * @param n -
         * @return -
         */
        public int sumNums(int n) {
            int ans = 0, A = n, B = n + 1;
            boolean flag;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            flag = ((B & 1) > 0) && (ans += A) > 0;
            A <<= 1;
            B >>= 1;

            return ans >> 1;
        }
    }
}
