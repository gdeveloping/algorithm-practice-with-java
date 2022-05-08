package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47.
 * Medium
 *
 * @author gdev
 * @date 2022/5/8 19:30
 */
public class PermutationsII {

    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> res;
        Solution1 solution1 = new Solution1();
        // Output: [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
        nums = new int[]{1, 1, 2};
        res = solution1.permuteUnique(nums);
        System.out.println("res: " + res);
    }

    private static class Solution1 {
        /**
         * Runtime: 3 ms, faster than 83.26% of Java online submissions for Permutations II.
         * Memory Usage: 47.9 MB, less than 54.93% of Java online submissions for Permutations II.
         *
         * @param nums -
         * @return -
         */
        public List<List<Integer>> permuteUnique(int[] nums) {
            res = new ArrayList<>();
            path = new ArrayList<>();
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            helper(nums, used);
            return res;
        }

        List<List<Integer>> res;
        List<Integer> path;

        private void helper(int[] nums, boolean[] used) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                helper(nums, used);
                path.remove(path.size()-1);
                used[i] = false;
            }
        }
    }
}
