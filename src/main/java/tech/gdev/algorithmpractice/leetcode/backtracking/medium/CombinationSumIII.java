package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 216.
 * Medium
 *
 * @author gdev
 * @date 2022/5/5 21:23
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        List<List<Integer>> res;
        Solution1 solution1 = new Solution1();
        res = solution1.combinationSum3(3, 7);
        System.out.println("output: " + ("[[1, 2, 4]]".equals(res.toString())));
        System.out.println(res);

        System.out.println();
        res = solution1.combinationSum3(3, 9);
        System.out.println("output: " + ("[[1, 2, 6], [1, 3, 5], [2, 3, 4]]".equals(res.toString())));
        System.out.println(res);
    }

    private static class Solution1 {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Combination Sum III.
         * Memory Usage: 39.6 MB, less than 94.09% of Java online submissions for Combination Sum III.
         *
         * @param k -
         * @param n -
         * @return -
         */
        public List<List<Integer>> combinationSum3(int k, int n) {
            res = new ArrayList<>();
            path = new ArrayList<>();
            helper(k, n, 1);
            return res;
        }

        List<List<Integer>> res;
        List<Integer> path;

        private void helper(int k, int n, int cur) {
            if (path.size() == k && n == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (cur > 9 || path.size() >= k) {
                return;
            }
            for (int i = cur; i <= 9; i++) {
                path.add(i);
                helper(k, n-i, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
