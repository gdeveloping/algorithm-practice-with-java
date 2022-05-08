package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90.
 * Medium
 *
 * @author gdev
 * @date 2022/5/8 19:04
 */
public class SubsetsII {

    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> res;
        Solution1 solution1 = new Solution1();
        nums = new int[]{1, 2, 2}; // output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        res = solution1.subsetsWithDup(nums);
        System.out.println("res: " + res);
    }

    private static class Solution1 {
        /**
         * Runtime: 2 ms, faster than 76.05% of Java online submissions for Subsets II.
         * Memory Usage: 44.2 MB, less than 46.53% of Java online submissions for Subsets II.
         *
         * @param nums -
         * @return -
         */
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            res = new ArrayList<>();
            path = new ArrayList<>();
            Arrays.sort(nums);
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
                if (i > index && nums[i] == nums[i-1]) {continue;}
                path.add(nums[i]);
                helper(nums, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
