package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199.
 * Medium
 *
 * @author gdev
 * @date 2022/5/2 22:17
 */
public class BinaryTreeRightSideView {

    private static class Solution1 {
        /**
         * Runtime: 3 ms, faster than 9.51% of Java online submissions for Binary Tree Right Side View.
         * Memory Usage: 42.7 MB, less than 47.25% of Java online submissions for Binary Tree Right Side View.
         *
         * @param root -
         * @return -
         */
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {return res;}
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            TreeNode node;
            while (!queue.isEmpty()) {
                res.add(queue.peek().val);
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    node = queue.poll();
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * Runtime: 1 ms, faster than 91.68% of Java online submissions for Binary Tree Right Side View.
         * Memory Usage: 43.2 MB, less than 10.97% of Java online submissions for Binary Tree Right Side View.
         *
         * @param root -
         * @return -
         */
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res, 0);
            return res;
        }

        private void dfs(TreeNode root, List<Integer> res, int depth) {
            if (root == null) {return;}
            if (res.size() == depth) {
                res.add(root.val);
            }
            dfs(root.right, res, depth+1);
            dfs(root.left, res, depth+1);
        }
    }
}
