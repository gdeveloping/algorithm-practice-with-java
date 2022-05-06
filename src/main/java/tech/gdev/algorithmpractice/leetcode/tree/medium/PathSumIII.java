package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437.
 * Medium
 *
 * @author gdev
 * @date 2022/5/6 22:00
 */
public class PathSumIII {

    private static class Solution1 {
        /**
         * Runtime: 3 ms, faster than 93.01% of Java online submissions for Path Sum III.
         * Memory Usage: 42.2 MB, less than 77.50% of Java online submissions for Path Sum III.
         *
         * @param root -
         * @param targetSum -
         * @return -
         */
        public int pathSum(TreeNode root, int targetSum) {
            map = new HashMap<>();
            ans = 0;
            map.put(0, 1);
            dfs(root, targetSum, 0);
            return ans;
        }

        private Map<Integer, Integer> map;
        private int ans;

        private void dfs(TreeNode root, int targetSum, int curSum) {
            if (root == null) {return;}
            curSum += root.val;
            // preSum + targetSum = curSum
            ans += map.getOrDefault(curSum - targetSum, 0);
            map.put(curSum, 1+map.getOrDefault(curSum, 0));
            dfs(root.left, targetSum, curSum);
            dfs(root.right, targetSum, curSum);
            map.put(curSum, map.get(curSum)-1);
        }
    }
}
