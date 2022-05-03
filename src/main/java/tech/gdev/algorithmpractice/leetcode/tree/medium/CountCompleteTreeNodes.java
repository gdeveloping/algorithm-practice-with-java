package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

/**
 * 222.
 * Medium
 *
 * @author gdev
 * @date 2022/5/3 19:08
 */
public class CountCompleteTreeNodes {

    private static class Solution1 {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
         * Memory Usage: 49.2 MB, less than 69.35% of Java online submissions for Count Complete Tree Nodes.
         *
         * @param root -
         * @return -
         */
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            TreeNode l, r;
            int hLeft, hRight;
            hLeft = hRight = 0;
            l = r = root;
            while (l.left != null) {
                hLeft++;
                l = l.left;
            }
            while (r.right != null) {
                hRight++;
                r = r.right;
            }
            if (hLeft == hRight) {
                // 1 + (int) Math.pow(2, hLeft) - 1 + (int) Math.pow(2, hRight) - 1;
                return (1 << hLeft + 1) - 1;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
