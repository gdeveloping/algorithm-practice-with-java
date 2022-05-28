package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 28
 * Easy
 *
 * @author gdev
 * @date 2022/5/28 23:44
 */
public class Offer28 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param root -
         * @return -
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {return true;}
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {return true;}
            if (left == null || right == null) {return false;}
            if (left.val != right.val) {return false;}
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param root -
         * @return -
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {return true;}
            if (root.left == null && root.right == null) {return true;}
            if (root.left == null || root.right == null) {return false;}
            if (root.left.val != root.right.val) {return false;}
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root.left);
            queue.offer(root.right);
            TreeNode leftNode, rightNode;
            while (!queue.isEmpty()) {
                leftNode = queue.poll();
                rightNode = queue.poll();
                if (!validate(leftNode.left, rightNode.right, queue)) {return false;}
                if (!validate(leftNode.right, rightNode.left, queue)) {return false;}
            }
            return true;
        }

        private boolean validate(TreeNode left, TreeNode right, Queue<TreeNode> queue) {
            if (left == null && right == null) {return true;}
            if (left == null || right == null) {return false;}
            if (left.val != right.val) {return false;}
            queue.offer(left);
            queue.offer(right);
            return true;
        }
    }
}
