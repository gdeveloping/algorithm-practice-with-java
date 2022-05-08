package tech.gdev.algorithmpractice.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.
 * Medium
 *
 * @author gdev
 * @date 2022/5/8 19:23
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums;
        List<List<Integer>> res;
        Solution1 solution1 = new Solution1();
        // output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        nums = new int[]{1,2,3};
        res = solution1.permute(nums);
        System.out.println("res: " + res);
    }

    private static class Solution1 {
        /**
         * Runtime: 4 ms, faster than 18.22% of Java online submissions for Permutations.
         * Memory Usage: 44.4 MB, less than 64.96% of Java online submissions for Permutations.
         *
         * @param nums -
         * @return -
         */
        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            path = new ArrayList<>();
            helper(nums);
            return res;
        }

        List<List<Integer>> res;
        List<Integer> path;

        private void helper(int[] nums) {
            if (path.size() == nums.length) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (path.contains(nums[i])) {continue;}
                path.add(nums[i]);
                helper(nums);
                path.remove(path.size()-1);
            }
        }
    }
}
