package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 114.
 * Medium
 *
 * @author gdev
 * @date 2022/5/2 22:37
 */
public class FlattenBinaryTreeToLinkedList {

    private static class Solution1 {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
         * Memory Usage: 41.8 MB, less than 87.98% of Java online submissions for Flatten Binary Tree to Linked
         *
         * @param root -
         */
        public void flatten(TreeNode root) {
            if (root == null) {return;}

            flatten(root.left);
            flatten(root.right);

            TreeNode l = root.left;
            TreeNode r = root.right;
            root.left = null;
            root.right = l;
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = r;
        }
    }

    private static class Solution2 {
        /**
         * Runtime: 1 ms, faster than 67.27% of Java online submissions for Flatten Binary Tree to Linked List.
         * Memory Usage: 42.8 MB, less than 36.36% of Java online submissions for Flatten Binary Tree to Linked List.
         *
         * @param root -
         */
        public void flatten(TreeNode root) {
            while (root != null) {
                if (root.left != null) {
                    TreeNode p = root.left;
                    while (p.right != null) {
                        p = p.right;
                    }
                    p.right = root.right;
                    root.right = root.left;
                    root.left = null;
                }
                root = root.right;
            }
        }
    }

    private static class Solution3 {
        /**
         * Runtime: 2 ms, faster than 13.65% of Java online submissions for Flatten Binary Tree to Linked List.
         * Memory Usage: 42.6 MB, less than 56.19% of Java online submissions for Flatten Binary Tree to Linked List.
         *
         * @param root -
         */
        public void flatten(TreeNode root) {
            if (root == null) {return;}
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            TreeNode pre = null;
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (pre != null) {
                    pre.right = node;
                    pre.left = null;
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                pre = node;
            }
        }
    }
}
