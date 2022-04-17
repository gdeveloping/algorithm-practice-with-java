package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102.
 * Medium
 *
 * @author gdev
 * @date 2022/4/17 23:30
 */
public class BinaryTreeLevelOrderTraversal {
    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
         * Memory Usage: 42.7 MB, less than 79.35% of Java online submissions for Binary Tree Level Order Traversal.
         *
         * @param root -
         * @return -
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> layer = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    layer.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                res.add(layer);
            }
            return res;
        }
    }

    private static class Solution2 {

        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
         * Memory Usage: 42.6 MB, less than 79.35% of Java online submissions for Binary Tree Level Order Traversal.
         *
         * @param root -
         * @return -
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            res = new LinkedList<>();
            if (root == null) return res;
            dfs(root, 0);
            return res;
        }
        List<List<Integer>> res;
        private void dfs(TreeNode root, int depth) {
            if (root == null) return;
            if (res.size() == depth) {
                res.add(new LinkedList<>());
            }
            res.get(depth).add(root.val);
            dfs(root.left, depth+1);
            dfs(root.right, depth+1);
        }
    }
}
