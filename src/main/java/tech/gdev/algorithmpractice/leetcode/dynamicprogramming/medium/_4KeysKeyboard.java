package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 651.
 * Medium
 *
 * @author gdev
 * @date 2022/5/20 23:08
 */
public class _4KeysKeyboard {

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N)
         *
         * @param N -
         * @return -
         */
        public int maxA(int N) {
            int[] dp = new int[N + 1];
            dp[0] = 0;
            for (int i = 1; i <= N; i++) {
                // A A A A A
                dp[i] = dp[i - 1] + 1;
                // A A A CA CV CV ... CA CV CV
                for (int j = 2; j < i; j++) {
                    dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
                }
            }
            return dp[N];
        }
    }
}
