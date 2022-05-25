package tech.gdev.algorithmpractice.codinginterviews2;

/**
 * 10
 * Easy
 *
 * @author gdev
 * @date 2022/5/25 21:26
 */
public class Offer10 {

    private static class Solution1 {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            int prePre = 0;
            int pre = 1;
            int cur = 1;
            for (int i = 2; i <= n; i++) {
                cur = (pre + prePre) % 1000000007;
                prePre = pre;
                pre = cur;
            }
            return cur;
        }
    }
}
