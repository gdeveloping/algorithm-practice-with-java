package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 669.
 * Medium
 *
 * @author gdev
 * @date 2022/5/3 21:11
 */
public class TrimABinarySearchTree {

    private static class Solution1 {
        /**
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Trim a Binary Search Tree.
         * Memory Usage: 45.7 MB, less than 6.27% of Java online submissions for Trim a Binary Search Tree.
         *
         * @param root -
         * @param low -
         * @param high -
         * @return -
         */
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {return null;}

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);

            if (root.val < low || root.val > high) {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode p = root.right;
                    while (p.left != null) {
                        p = p.left;
                    }
                    p.left = root.left;
                    return root.right;
                }
            }
            return root;
        }
    }

    private static class Solution2 {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Trim a Binary Search Tree.
         * Memory Usage: 45.5 MB, less than 9.01% of Java online submissions for Trim a Binary Search Tree.
         *
         * @param root -
         * @param low -
         * @param high -
         * @return -
         */
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {return null;}
            if (root.val < low) {
                return trimBST(root.right, low, high);
            } else if (root.val > high) {
                return trimBST(root.left, low, high);
            }
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }

    private static class Solution3 {
        /**
         * Runtime: 1 ms, faster than 100.00% of Java online submissions for Trim a Binary Search Tree.
         * Memory Usage: 45.2 MB, less than 10.91% of Java online submissions for Trim a Binary Search Tree.
         *
         * @param root -
         * @param low -
         * @param high -
         * @return -
         */
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            while (root != null && (root.val < low || root.val > high)) {
                if (root.val < low) {
                    root = root.right;
                } else if (root.val > high) {
                    root = root.left;
                }
            }
            if (root == null) {
                return null;
            }

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            boolean adjusted = false;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null && node.left.val < low) {
                    node.left = node.left.right;
                    adjusted = true;
                }
                if (node.right != null && node.right.val > high) {
                    node.right = node.right.left;
                    adjusted = true;
                }
                if (!adjusted) {
                    if (node.left != null) {queue.offer(node.left);}
                    if (node.right != null) {queue.offer(node.right);}
                } else {
                    queue.offer(node);
                }
                adjusted = false;
            }
            return root;
        }
    }
}
