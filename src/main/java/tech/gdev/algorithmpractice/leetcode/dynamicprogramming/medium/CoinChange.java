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

    private static class Solution2 {

        /**
         * time: O(MN), N:len(coins), M:amount
         * space: O(M)
         *
         * Runtime: 29 ms, faster than 45.04% of Java online submissions for Coin Change.
         * Memory Usage: 44.8 MB, less than 61.70% of Java online submissions for Coin Change.
         *
         * @param coins -
         * @param amount -
         * @return -
         */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount+1];
            Arrays.fill(dp, dp.length);
            dp[0] = 0;
            for (int i = 0; i < coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j >= coins[i]) {
                        dp[j] = Math.min(dp[j], 1 + dp[j-coins[i]]);
                    }
                }
            }
            return dp[amount] == dp.length ? -1 : dp[amount];
        }
    }

    private static class Solution3 {
        public static void main(String[] args) {
            Solution3 solution3 = new Solution3();
            Solution1 solution1 = new Solution1();
            int[] coins = {186,419,83,408};
            int amount = 6249;
            long start, end;

            start = System.currentTimeMillis();
            System.out.println(solution3.coinChange(coins, amount));
            end = System.currentTimeMillis();
            long t1 = end - start;
            // 20
            // t1: 21809
            System.out.println("t1: " + t1);

            System.out.println();
            start = System.currentTimeMillis();
            System.out.println(solution1.coinChange(coins, amount));
            end = System.currentTimeMillis();
            long t2 = end - start;
            // 20
            // t2: 1
            System.out.println("t2: " + t2);
        }

        /**
         * time: O(MN), N:len(coins), M:amount
         * space: O(M)
         *
         * Time Limit Exceeded
         *
         * @param coins -
         * @param amount -
         * @return -
         */
        public int coinChange(int[] coins, int amount) {
            if (amount <= 0) {return 0;}
            int[] memo = new int[amount+1];
            Arrays.fill(memo, amount+1);
            memo[0] = 0;
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= amount) {
                    memo[coins[i]] = 1;
                }
            }
            int res = coinChange(amount, coins, memo);
            return (res == amount+1) ? -1 : res;
        }

        private int coinChange(int amount, int[] coins, int[] memo) {
            if (memo[amount] <= amount) {
                return memo[amount];
            }
            int res = memo[amount];
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] >= amount) {continue;}
                res = Math.min(res, 1 + coinChange(amount-coins[i], coins, memo));
            }
            memo[amount] = res;
            return res;
        }
    }
}
