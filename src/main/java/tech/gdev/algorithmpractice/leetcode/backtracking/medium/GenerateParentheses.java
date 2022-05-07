package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.
 * Medium
 *
 * @author gdev
 * @date 2022/5/7 20:49
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        int n;
        List<String> res;
        Solution1 solution1 = new Solution1();

        n = 3; // output: ["((()))","(()())","(())()","()(())","()()()"]
        res = solution1.generateParenthesis(n);
        System.out.println("res: " + res);
    }

    private static class Solution1 {
        /**
         * Runtime: 2 ms, faster than 61.51% of Java online submissions for Generate Parentheses.
         * Memory Usage: 43.4 MB, less than 63.21% of Java online submissions for Generate Parentheses.
         *
         * @param n -
         * @return -
         */
        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            path = new StringBuilder();
            helper(n, 0, 0);
            return res;
        }

        List<String> res;
        StringBuilder path;

        private void helper(final int n, int open, int close) {
            if (path.length() == 2*n) {
                res.add(new String(path));
                return;
            }
            if (open < n) {
                path.append("(");
                helper(n, open+1, close);
                path.deleteCharAt(path.length()-1);
            }
            if (close < open) {
                path.append(")");
                helper(n, open, close+1);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
}
