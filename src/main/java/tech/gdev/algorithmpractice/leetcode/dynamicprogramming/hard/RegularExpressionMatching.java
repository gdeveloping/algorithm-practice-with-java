package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 10.
 * Hard
 *
 * @author gdev
 * @date 2022/5/20 19:22
 */
public class RegularExpressionMatching {

    private static class Solution1 {
        private static final char SYMBOL_START = '*';
        private static final char SYMBOL_COMMA = '.';

        /**
         * time: O(mn) m=len(s), n=len(p)
         * space: O(mn) memo, stack
         *
         * Runtime: 22 ms, faster than 39.50% of Java online submissions for Regular Expression Matching.
         * Memory Usage: 43.5 MB, less than 17.88% of Java online submissions for Regular Expression Matching.
         *
         * @param s -
         * @param p -
         * @return -
         */
        public boolean isMatch(String s, String p) {
            memo = new HashMap<>();
            return isMatch(s, 0, p, 0);
        }

        Map<String, Boolean> memo;

        private boolean isMatch(String s, int i, String p, int j) {
            int m = s.length();
            int n = p.length();
            if (j == n) {
                return i == m;
            }
            if (i == m) {
                // a*b*
                if ((n - j) % 2 == 1) {
                    return false;
                }
                for (; j + 1 < n; j += 2) {
                    if (p.charAt(j+1) != SYMBOL_START) {
                        return false;
                    }
                }
                return true;
            }

            String key = genKey(i, j);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            boolean res = false;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == SYMBOL_COMMA) {
                if (j < n-1 && p.charAt(j+1) == SYMBOL_START) {
                    // match 0 or many times
                    res =  isMatch(s, i, p, j+2) || isMatch(s, i+1, p, j);
                } else {
                    res =  isMatch(s, i+1, p, j+1);
                }
            } else {
                if (j < n-1 && p.charAt(j+1) == SYMBOL_START) {
                    // match 0 times
                    res =  isMatch(s, i, p, j+2);
                } else {
                    res =  false;
                }
            }

            memo.put(key, res);
            return res;
        }

        private String genKey(int i, int j) {
            return i + "," + j;
        }
    }
}
