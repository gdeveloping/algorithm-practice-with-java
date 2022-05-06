package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 131.
 * Medium
 *
 * @author gdev
 * @date 2022/5/6 21:21
 */
public class PalindromePartitioning {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<List<String>> res;

        String s = "aab"; // output [["a","a","b"],["aa","b"]]
        res = solution1.partition(s);
        System.out.println("res: " + res);
    }

    private static class Solution1 {
        /**
         * Runtime: 9 ms, faster than 88.72% of Java online submissions for Palindrome Partitioning.
         * Memory Usage: 54.7 MB, less than 88.00% of Java online submissions for Palindrome Partitioning.
         *
         * @param s -
         * @return -
         */
        public List<List<String>> partition(String s) {
            res = new ArrayList<>();
            path = new ArrayList<>();
            helper(s, 0);
            return res;
        }

        List<List<String>> res;
        List<String> path;

        private void helper(String s, int pos) {
            if (pos == s.length()) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = pos; i < s.length(); i++) {
                if (isPalindrome(s, pos, i)) {
                    path.add(s.substring(pos, i+1));
                    helper(s, i+1);
                    path.remove(path.size()-1);
                }
            }
        }

        private boolean isPalindrome(String s, int low, int high) {
            while (low < high) {
                if (s.charAt(low++) != s.charAt(high--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
