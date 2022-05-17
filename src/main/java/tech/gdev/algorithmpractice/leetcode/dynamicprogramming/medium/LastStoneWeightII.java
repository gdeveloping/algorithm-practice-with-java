package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * 1049.
 * Medium
 *
 * @author gdev
 * @date 2022/5/17 14:14
 */
public class LastStoneWeightII {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] stones = new int[]{2,7,4,1,8,1};
        System.out.println(Arrays.toString(stones));
        int res = solution1.lastStoneWeightII(stones);
        int output = 1;
        System.out.println("res: " + res + "\toutput: " + (res == output));
    }

    private static class Solution1 {
        /**
         * time: O(MN), N:len(stones), M:sum(stones)/2
         * space: O(N)
         *
         * Runtime: 4 ms, faster than 64.09% of Java online submissions for Last Stone Weight II.
         * Memory Usage: 41.5 MB, less than 70.60% of Java online submissions for Last Stone Weight II.
         *
         * @param stones -
         * @return -
         */
        public int lastStoneWeightII(int[] stones) {
            final int size = stones.length;
            int sum = 0;
            for (int num : stones) {
                sum += num;
            }
            int half = sum / 2;
            int[] dp = new int[half+1];
            for (int i = 1; i <= size; i++) {
                for (int j = half; j > 0; j--) {
                    if (j >= stones[i-1]) {
                        dp[j] = Math.max(dp[j], dp[j-stones[i-1]] + stones[i-1]);
                    }
                }
//                System.out.println(Arrays.toString(dp));
            }
            return sum - 2 * dp[half];
        }
    }
}
