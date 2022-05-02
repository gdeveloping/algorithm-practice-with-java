package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 105.
 * Medium
 *
 * @author gdev
 * @date 2022/5/2 18:18
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private static class Solution1 {
        /**
         * Runtime: 2 ms, faster than 91.16% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
         * Memory Usage: 44.1 MB, less than 61.43% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
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

        int[] preorder;
        int[] inorder;
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

    private static class Solution2 {
        /**
         * Runtime: 3 ms, faster than 81.14% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
         * Memory Usage: 44.4 MB, less than 44.19% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
         *
         * @param preorder -
         * @param inorder -
         * @return -
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            int pre = 0;
            int in = 0;
            TreeNode root = new TreeNode(preorder[pre++]);
            stack.push(root);
            TreeNode curr = root;
            while (pre < preorder.length) {
                // build left tree in dfs way until tree arrives leaf node, whose value equals inorder[in]
                if (curr.val != inorder[in]) {
                    curr.left = new TreeNode(preorder[pre++]);
                    curr = curr.left;
                    stack.push(curr);
                } else {
                    // pop all left node until there is right node, which contains a strange value
                    while (!stack.isEmpty() && stack.peek().val == inorder[in]) {
                        curr = stack.pop();
                        in++;
                    }
                    curr.right = new TreeNode(preorder[pre++]);
                    curr = curr.right;
                    stack.push(curr);
                }
            }
            return root;
        }
    }
}
