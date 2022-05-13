package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 279.
 * Medium
 *
 * @author gdev
 * @date 2022/5/13 15:15
 */
public class PerfectSquares {
    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N)
         *
         * Runtime: 42 ms, faster than 67.58% of Java online submissions for Perfect Squares.
         * Memory Usage: 43.6 MB, less than 45.60% of Java online submissions for Perfect Squares.
         *
         * @param n -
         * @return -
         */
        public int numSquares(int n) {
            if (n <= 1) {
                return n;
            }
            int[] dp = new int[n+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                int k = 1;
                for (int j = 1; k <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i-k]+1);
                    k = j * j;
                }
            }
            return dp[n];
        }
    }

    private static class Solution1_2 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 111 ms, faster than 31.40% of Java online submissions for Perfect Squares.
         * Memory Usage: 41.7 MB, less than 86.00% of Java online submissions for Perfect Squares.
         *
         * @param n -
         * @return -
         */
        public int numSquares(int n) {
            if (n <= 1) {
                return n;
            }
            List<Integer> list = new ArrayList<>();
            int idx = 1;
            while (idx * idx <= n) {
                list.add(idx * idx);
                idx++;
            }
            int[] dp = new int[n+1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) > i) {
                        break;
                    }
                    dp[i] = Math.min(dp[i], dp[i-list.get(j)]+1);
                }
            }
            return dp[n];
        }
    }
}
