package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

/**
 * 07
 * Medium
 *
 * @author gdev
 * @date 2022/5/24 21:30
 */
public class Offer07 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] preorder;
        int[] inorder;
        preorder = new int[]{3,9,20,15,7};
        inorder = new int[]{9,3,15,20,7};
        solution1.buildTree(preorder, inorder);
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param preorder -
         * @param inorder -
         * @return -
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            this.pre = 0;
            this.in = 0;
            return buildTree(Integer.MAX_VALUE);
        }

        private int[] preorder;
        private int[] inorder;
        int pre;
        int in;

        private TreeNode buildTree(int stop) {
            if (pre == preorder.length) {
                return null;
            }
            if (inorder[in] == stop) {
                in++;
                return null;
            }
            TreeNode root = new TreeNode(preorder[pre++]);
            root.left = buildTree(root.val);
            root.right = buildTree(stop);
            return root;
        }
    }
}
