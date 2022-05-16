package tech.gdev.algorithmpractice.leetcode.dynamicprogramming.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337.
 * Medium
 *
 * @author gdev
 * @date 2022/5/16 21:28
 */
public class HouseRobberIII {

    private static class Solution1 {

        /**
         * Runtime: 1 ms, faster than 84.46% of Java online submissions for House Robber III.
         * Memory Usage: 44.4 MB, less than 56.57% of Java online submissions for House Robber III.
         *
         * @param root -
         * @return -
         */
        public int rob(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        /**
         *
         * @param root -
         * @return [0]:max value while rob this node; [1]:max value while not rob this node
         */
        private int[] dfs(TreeNode root) {
            if (root == null) {return new int[2];}
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            int[] res = new int[2];
            res[0] = root.val + left[1] + right[1];
            res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return res;
        }
    }

    private static class Solution2 {
        /**
         * Time Limit Exceeded
         *
         * @param root -
         * @return -
         */
        public int rob(TreeNode root) {
            Map<TreeNode, Integer> map = new HashMap<>();
            return rob(root, map);
        }

        public int rob(TreeNode root, Map<TreeNode, Integer> map) {
            if (root == null) {return 0;}
            if (map.containsKey(root)) {return map.get(root);}
            int res = 0;
            if (root.left != null) {
                res += rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null) {
                res += rob(root.right.left) + rob(root.right.right);
            }
            res = Math.max(res + root.val, rob(root.left) + rob(root.right));
            map.put(root, res);
            return res;
        }
    }
}
