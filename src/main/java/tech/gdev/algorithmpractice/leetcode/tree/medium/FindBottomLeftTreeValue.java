package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 513.
 * Medium
 *
 * @author gdev
 * @date 2022/5/3 20:55
 */
public class FindBottomLeftTreeValue {

    private static class Solution1 {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Bottom Left Tree Value.
         * Memory Usage: 43.9 MB, less than 52.20% of Java online submissions for Find Bottom Left Tree Value.
         *
         * @param root -
         * @return -
         */
        public int findBottomLeftValue(TreeNode root) {
            depth = -1;
            dfs(root, 0);
            return val;
        }

        private int val;
        private int depth;

        private void dfs(TreeNode root, int d) {
            if (root == null) {return;}
            if (d > depth) {
                depth = d;
                val = root.val;
            }
            dfs(root.left, d+1);
            dfs(root.right, d+1);
        }
    }

    private static class Solution2 {
        /**
         * Runtime: 2 ms, faster than 44.06% of Java online submissions for Find Bottom Left Tree Value.
         * Memory Usage: 43.7 MB, less than 61.20% of Java online submissions for Find Bottom Left Tree Value.
         *
         * @param root -
         * @return -
         */
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int res = root.val;
            while (!queue.isEmpty()) {
                int size = queue.size();
                res = queue.peek().val;
                for (int i = 0; i < size; i++) {
                    root = queue.poll();
                    if (root.left != null) {
                        queue.offer(root.left);
                    }
                    if (root.right != null) {
                        queue.offer(root.right);
                    }
                }
            }
            return res;
        }
    }
}
