package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 54
 * Easy
 *
 * @author gdev
 * @date 2022/7/10 12:58
 */
public class Offer54 {
    private static class Solution1 {
        /**
         * InOrder
         *
         * time: O(N)
         * space: O(N)
         * modify source: N
         *
         * @param root -
         * @param k 1 <= k <= len(tree)
         * @return -
         */
        public int kthLargest(TreeNode root, int k) {
            TreeNode node = root;
            Deque<TreeNode> stack = new ArrayDeque<>();
            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    stack.push(node);
                    node = node.right;
                }
                node = stack.poll();
                if (--k == 0) {
                    return node.val;
                }
                node = node.left;
            }
            return 0;
        }
    }
}
