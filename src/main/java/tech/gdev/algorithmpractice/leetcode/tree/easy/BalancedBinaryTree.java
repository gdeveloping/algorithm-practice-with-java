package tech.gdev.algorithmpractice.leetcode.tree.easy;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

/**
 * 110.
 * Easy
 *
 * @author gdev
 * @date 2022/5/3 19:50
 */
public class BalancedBinaryTree {

    private static class Solution1 {
        /**
         * Runtime: 1 ms, faster than 90.75% of Java online submissions for Balanced Binary Tree.
         * Memory Usage: 44.9 MB, less than 15.32% of Java online submissions for Balanced Binary Tree.
         *
         * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
         *
         * @param root -
         * @return -
         */
        public boolean isBalanced(TreeNode root) {
            return (height(root) == falseFlag) ? false : true;
        }

        final int falseFlag = -1;

        private int height(TreeNode root) {
            if (root == null) {return 0;}
            int hLeft = height(root.left);
            int hRight = height(root.right);
            if (hLeft == falseFlag || hRight == falseFlag
                    || Math.abs(hLeft - hRight) > 1 ) {
                return falseFlag;
            }
            return 1 + Math.max(hLeft, hRight);
        }
    }
}
