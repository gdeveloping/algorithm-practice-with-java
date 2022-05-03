package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 538.
 * Medium
 *
 * @author gdev
 * @date 2022/5/3 17:08
 */
public class ConvertBstToGreaterTree {


    private static class Solution1 {
        /**
         * Runtime: 1 ms, faster than 39.56% of Java online submissions for Convert BST to Greater Tree.
         * Memory Usage: 49.8 MB, less than 10.89% of Java online submissions for Convert BST to Greater Tree.
         *
         * modified in-order
         *
         * @param root -
         * @return -
         */
        public TreeNode convertBST(TreeNode root) {
            dfs(root, 0);
            return root;
        }

        private int dfs(TreeNode root, int pre) {
            if (root == null) {return pre;}
            pre = dfs(root.right, pre);
            root.val += pre;
            pre = root.val;
            pre = dfs(root.left, pre);
            return pre;
        }
    }

    private static class Solution2 {
        /**
         * Runtime: 3 ms, faster than 12.02% of Java online submissions for Convert BST to Greater Tree.
         * Memory Usage: 48.9 MB, less than 21.27% of Java online submissions for Convert BST to Greater Tree.
         *
         * modified in-order
         *
         * @param root -
         * @return -
         */
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {return root;}

            int sum = 0;
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.right;
                }
                curr = stack.pop();
                curr.val += sum;
                sum = curr.val;
                curr = curr.left;
            }
            return root;
        }
    }
}
