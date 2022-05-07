package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40.
 * Medium
 *
 * @author gdev
 * @date 2022/5/7 21:32
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates;
        int target;
        List<List<Integer>> res;
        Solution1 solution1 = new Solution1();
        candidates = new int[]{10,1,2,7,6,1,5};
        target = 8;
        res = solution1.combinationSum2(candidates, target);
        System.out.println("res: " + res);
    }

    private static class Solution1 {
        /**
         * Runtime: 6 ms, faster than 51.50% of Java online submissions for Combination Sum II.
         * Memory Usage: 44 MB, less than 47.76% of Java online submissions for Combination Sum II.
         *
         * @param candidates -
         * @param target -
         * @return -
         */
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Arrays.sort(candidates);
            helper(res, path, candidates, target, 0, 0);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> path,
                            int[] candidates, int target,
                            int sum, int index) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (sum > target || index == candidates.length) {
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                // skip duplicates
                if (i > index && candidates[i] == candidates[i-1]) {continue;}
                path.add(candidates[i]);
                helper(res, path, candidates, target, sum+candidates[i], i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
