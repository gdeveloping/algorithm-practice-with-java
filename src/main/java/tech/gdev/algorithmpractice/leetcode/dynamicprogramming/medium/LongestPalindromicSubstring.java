package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

/**
 * 5.
 * Medium
 *
 * @author gdev
 * @date 2022/5/19 09:13
 */
public class LongestPalindromicSubstring {

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N^2)
         *
         * Runtime: 335 ms, faster than 28.87% of Java online submissions for Longest Palindromic Substring.
         * Memory Usage: 86.2 MB, less than 16.49% of Java online submissions for Longest Palindromic Substring.
         *
         * @param s -
         * @return -
         */
        public String longestPalindrome(String s) {
            int size = s.length();
            boolean[][] dp = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                dp[i][i] = true; // one char
            }
            int maxLen = 1;
            int start = size-1;
            for (int i = size-2; i >= 0; i--) {
                for (int j = i+1; j < size; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        int curLen = j - i + 1;
                        if ((curLen) == 2 || dp[i+1][j-1]) {
                            dp[i][j] = true;
                        }
                        if (dp[i][j] && (curLen > maxLen)) {
                            maxLen = curLen;
                            start = i;
                        }
                    }
                }
            }
            return s.substring(start, start+maxLen);
        }
    }

    private static class Solution2 {
        /**
         * time: O(N^2)
         * space: O(1)
         *
         * Runtime: 52 ms, faster than 54.86% of Java online submissions for Longest Palindromic Substring.
         * Memory Usage: 42.9 MB, less than 74.39% of Java online submissions for Longest Palindromic Substring.
         *
         * @param s -
         * @return -
         */
        public String longestPalindrome(String s) {
            int maxLen = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = helper(s, i, i); // odd
                int len2 = helper(s, i, i+1); // even
                if (maxLen < Math.max(len1, len2)) {
                    maxLen = Math.max(len1, len2);
                    start = (len1 > len2) ? (i-len1/2) : (i-len2/2+1);
                }
            }
            return s.substring(start, start+maxLen);
        }

        private int helper(String s, int i, int j) {
            for (; i >= 0 && j < s.length(); i--, j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
            }
            return j - i + 1 - 2; // 2 means current unmatched char
        }
    }
}
