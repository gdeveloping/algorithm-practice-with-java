package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.
 * Medium
 *
 * @author gdev
 * @date 2022/5/8 18:38
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> res;
        Solution1 solution1 = new Solution1();
        nums = new int[]{1,2,3}; // output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
        res = solution1.subsets(nums);
        System.out.println("res: " + res);
    }

    private static class Solution1 {
        /**
         * Runtime: 1 ms, faster than 78.59% of Java online submissions for Subsets.
         * Memory Usage: 43.2 MB, less than 60.87% of Java online submissions for Subsets.
         *
         * @param nums -
         * @return -
         */
        public List<List<Integer>> subsets(int[] nums) {
            res = new ArrayList<>();
            path = new ArrayList<>();
            helper(nums, 0);
            return res;
        }

        List<List<Integer>> res;
        List<Integer> path;

        private void helper(int[] nums, int index) {
            if (index >= nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            res.add(new ArrayList<>(path));
            for (int i = index; i < nums.length; i++) {
                path.add(nums[i]);
                helper(nums, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
