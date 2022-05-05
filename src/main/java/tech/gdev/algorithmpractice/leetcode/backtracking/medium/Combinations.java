package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77.
 * Medium
 *
 * @author gdev
 * @date 2022/5/5 20:45
 */
public class Combinations {

    public static void main(String[] args) {
        List<List<Integer>> res;
        Solution1 solution1 = new Solution1();
        res = solution1.combine(4, 2);
        System.out.println(res);
        res = solution1.combine(1, 1);
        System.out.println(res);
    }

    private static class Solution1 {
        /**
         * Runtime: 3 ms, faster than 94.62% of Java online submissions for Combinations.
         * Memory Usage: 55 MB, less than 41.00% of Java online submissions for Combinations.
         *
         * @param n -
         * @param k -
         * @return -
         */
        public List<List<Integer>> combine(int n, int k) {
            res = new ArrayList<>();
            path = new ArrayList<>();
            helper(n, k, 0);
            return res;
        }

        List<List<Integer>> res;
        List<Integer> path;

        private void helper(final int n, final int k, int cur) {
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }
            int m = n - (k - path.size() - 1);
            for (int i = cur+1; i <= m; i++) {
                path.add(i);
                helper(n, k, i);
                path.remove(path.size()-1);
            }
        }
    }
}
