package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39.
 * Medium
 *
 * @author gdev
 * @date 2022/5/7 21:14
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates;
        int target;
        List<List<Integer>> res;
        Solution1 solution1 = new Solution1();
        candidates = new int[]{2,3,6,7};
        target = 7;
        res = solution1.combinationSum(candidates, target);
        System.out.println("res: " + res);
    }

    private static class Solution1 {
        /**
         * Runtime: 8 ms, faster than 33.50% of Java online submissions for Combination Sum.
         * Memory Usage: 45.5 MB, less than 19.54% of Java online submissions for Combination Sum.
         *
         * @param candidates -
         * @param target -
         * @return -
         */
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.res = new ArrayList<>();
            this.path = new ArrayList<>();
            this.candidates = candidates;
            this.size = candidates.length;
            Arrays.sort(candidates);
            helper(target, 0, 0);
            return res;
        }

        List<List<Integer>> res;
        List<Integer> path;
        int[] candidates;
        int size;

        private void helper(int target, int sum, int index) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (sum > target || index == size) {
                return;
            }
            for (int i = index; i < size; i++) {
                path.add(candidates[i]);
                helper(target, sum+candidates[i], i);
                path.remove(path.size()-1);
            }
        }
    }
}
