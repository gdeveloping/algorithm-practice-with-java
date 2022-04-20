package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.hard;

/**
 * 1312.
 * Hard
 *
 * @author gdev
 * @date 2022/4/20 22:18
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String[] arr = new String[]{
                  "zzazz" // 0
                , "mbadm" // 2
                , "leetcode" // 5
        };
        for (String s : arr) {
            System.out.println(solution1.minInsertions(s));
        }
    }

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N^2)
         *
         * Runtime: 20 ms, faster than 91.38% of Java online submissions for Minimum Insertion Steps to Make a String Palindrome.
         * Memory Usage: 43.9 MB, less than 79.75% of Java online submissions for Minimum Insertion Steps to Make a String Palindrome.
         *
         * @param s -
         * @return -
         */
        public int minInsertions(String s) {
            final int size = s.length();
            int[][] dp = new int[size][size];
            for (int i = size-2; i >= 0; i--) {
                for (int j = i+1; j < size; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j-1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
            return dp[0][size-1];
        }
    }
}
