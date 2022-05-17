package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * 322.
 * Medium
 *
 * @author gdev
 * @date 2022/5/17 15:00
 */
public class CoinChange {

    private static class Solution1 {
        /**
         * time: O(MN), N:len(coins), M:amount
         * space: O(M)
         *
         * Runtime: 25 ms, faster than 55.50% of Java online submissions for Coin Change.
         * Memory Usage: 45.8 MB, less than 24.80% of Java online submissions for Coin Change.
         *
         * @param coins -
         * @param amount -
         * @return -
         */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            for (int i = 1; i <= amount; i++) {
                dp[i] = dp.length;
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j]) {
                        dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                    }
                }
            }
            return dp[amount] == dp.length ? -1 : dp[amount];
        }
    }

    private static class Solution1_2 {
        /**
         * time: O(MN), N:len(coins), M:amount
         * space: O(M)
         *
         * Runtime: 36 ms, faster than 33.62% of Java online submissions for Coin Change.
         * Memory Usage: 45.2 MB, less than 47.81% of Java online submissions for Coin Change.
         *
         * @param coins -
         * @param amount -
         * @return -
         */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    int diff = i - coin;
                    if (diff < 0 || dp[diff] < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1+dp[diff]);
                }
                dp[i] = (dp[i] == Integer.MAX_VALUE) ? -1 : dp[i];
            }
            return dp[amount];
        }
    }
}
