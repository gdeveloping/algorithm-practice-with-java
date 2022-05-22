package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 518.
 * Medium
 *
 * @author gdev
 * @date 2022/5/22 16:44
 */
public class CoinChange2 {

    private static class Solution1 {
        /**
         * time: O(MN) N:amount, M:len(coins)
         * space: O(N)
         *
         * Runtime: 8 ms, faster than 47.78% of Java online submissions for Coin Change 2.
         * Memory Usage: 41.6 MB, less than 75.01% of Java online submissions for Coin Change 2.
         *
         * @param amount -
         * @param coins -
         * @return -
         */
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount+1];
            dp[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j >= coins[i]) {
                        dp[j] += dp[j-coins[i]];
                    }
                }
            }
            return dp[amount];
        }
    }
}
