package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354.
 * Hard
 *
 * @author gdev
 * @date 2022/4/18 21:58
 */
public class RussianDollEnvelopes {

    public static void main(String[] args) {
        int[][] envelopes1 = new int[][]{{5,4},{6,4},{6,7},{2,3}}; // 3
        int[][] envelopes2 = new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}}; // 4
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.maxEnvelopes(envelopes1));
        System.out.println(solution1.maxEnvelopes(envelopes2));
    }

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N)
         *
         * Time Limit Exceeded
         *
         * @param envelopes -
         * @return -
         */
        public int maxEnvelopes(int[][] envelopes) {
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
                }
            });
            final int size = envelopes.length;

            int[] dp = new int[size];
            Arrays.fill(dp, 1);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < i; j++) {
                    if (envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < size; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
