package tech.gdev.algorithmpractice.leetcode.slidingwindow.medium;

import java.util.HashMap;

/**
 * 3.
 * Medium
 * @author gdev
 * @date 2022/4/11 22:42
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        Solution2_1 solution21 = new Solution2_1();
        String[] arr = {"abcabcbb", "bbbbb", "pwwkew", "tmmzuxt"};
        for (String s : arr) {
//            System.out.println(solution1.lengthOfLongestSubstring(s) + "\t" + s);
//            System.out.println(solution2.lengthOfLongestSubstring(s) + "\t" + s);
            System.out.println(solution21.lengthOfLongestSubstring(s) + "\t" + s);
        }
    }

    private static class Solution1 {
        /**
         * time: O(n)
         * space: O(1)
         *
         * Runtime: 2 ms, faster than 99.71% of Java online submissions for Longest Substring Without Repeating Characters.
         * Memory Usage: 42 MB, less than 96.86% of Java online submissions for Longest Substring Without Repeating Characters.
         *
         * [left, right)
         * windows
         * res
         *
         * two pointers can only move forward.
         *
         * @param s -
         * @return -
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            int[] windows = new int[128];
            int left = 0, right = 0;
            int res = 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                windows[c]++;
                while (windows[c] > 1) {
                    char d = s.charAt(left);
                    left++;
                    windows[d]--;
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(n)
         * space: O(1)
         *
         * Runtime: 10 ms, faster than 64.85% of Java online submissions for Longest Substring Without Repeating Characters.
         * Memory Usage: 44.8 MB, less than 53.99% of Java online submissions for Longest Substring Without Repeating Characters.
         *
         * [left, right]
         *
         * @param s -
         * @return -
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            HashMap<Character, Integer> map = new HashMap<>();
            int res = 0;
            for (int left = 0, right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                if (map.containsKey(c)) {
                    left = Math.max(left, map.get(c)+1);
                }
                map.put(c, right);
                res = Math.max(res, right-left+1);
            }
            return res;
        }
    }

    private static class Solution2_1 {
        /**
         * time: O(n)
         * space: O(1)
         *
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Substring Without Repeating Characters.
         * Memory Usage: 42.6 MB, less than 86.49% of Java online submissions for Longest Substring Without Repeating Characters.
         *
         * (left, right]
         *
         * @param s -
         * @return -
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.length() <= 1) {
                return s.length();
            }
            int[] windows = new int[128];
            int res = 0;
            for (int left = 0, right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                if (windows[c] > 0) {
                    left = Math.max(left, windows[c]);
                }
                windows[c] = right + 1;
                res = Math.max(res, right - left + 1);
            }
            return res;
        }
    }
}