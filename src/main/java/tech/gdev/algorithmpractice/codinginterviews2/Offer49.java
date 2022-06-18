package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 49
 * Medium
 *
 * @author gdev
 * @date 2022/6/18 22:17
 */
public class Offer49 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         * modify source: N
         *
         * @param n -
         * @return -
         */
        public int nthUglyNumber(int n) {
            if (n < 1) {return 0;}
            long[] dp = new long[n + 1];
            dp[1] = 1;
            int p2, p3, p5;
            p2 = p3 = p5 = 1;
            for (int i = 2; i <= n; i++) {
                long num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
                dp[i] = Math.min(num2, Math.min(num3, num5));
                if (num2 == dp[i]) {p2++;}
                if (num3 == dp[i]) {p3++;}
                if (num5 == dp[i]) {p5++;}
            }
            return (int) dp[n];
        }
    }

    private static class Solution2 {
        /**
         * time: O(N*log(N))
         * space: O(N)
         * modify source: N
         *
         * @param n -
         * @return -
         */
        public int nthUglyNumber(int n) {
            if (n < 1) {return 0;}
            int[] factors = {2, 3, 5};
            Set<Long> set = new HashSet<>();
            PriorityQueue<Long> queue = new PriorityQueue<>();
            queue.offer(1L);
            set.add(1L);
            long res = 0;
            while (n > 0) {
                n--;
                res = queue.poll();
                for (int factor : factors) {
                    long num = res * factor;
                    if (set.add(num)) {
                        queue.offer(num);
                    }
                }
            }
            return (int) res;
        }
    }

    private static class Solution3 {
        /**
         * timeout
         *
         * time: O(...)
         * space: O(1)
         * modify source: N
         *
         * @param n -
         * @return -
         */
        public int nthUglyNumber(int n) {
            if (n < 1) {return 0;}
            int num = 0;
            while (n > 0) {
                ++num;
                if (isUglyNumber(num)) {n--;}
            }
            return num;
        }

        private boolean isUglyNumber(int n) {
            while (n % 2 == 0) {n /= 2;}
            while (n % 3 == 0) {n /= 3;}
            while (n % 5 == 0) {n /= 5;}
            return n == 1;
        }
    }
}
