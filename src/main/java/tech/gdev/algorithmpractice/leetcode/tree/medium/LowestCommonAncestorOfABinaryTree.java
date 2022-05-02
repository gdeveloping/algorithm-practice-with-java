package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.*;

/**
 * 236.
 * Medium
 *
 * @author gdev
 * @date 2022/5/2 21:20
 */
public class LowestCommonAncestorOfABinaryTree {

    private static class Solution1 {
        /**
         * Runtime: 8 ms, faster than 65.24% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
         * Memory Usage: 47.1 MB, less than 60.07% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
         *
         * @param root -
         * @param p -
         * @param q -
         * @return -
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) {return right;}
            if (right == null) {return left;}
            return root;
        }
    }

    private static class Solution2 {
        /**
         * Runtime: 17 ms, faster than 11.46% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
         * Memory Usage: 48.7 MB, less than 9.85% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
         *
         * @param root -
         * @param p -
         * @param q -
         * @return -
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {return root;}
            Map<TreeNode, TreeNode> map = new HashMap<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            map.put(root, null);
            queue.offer(root);
            while (!map.containsKey(p) || !map.containsKey(q)) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    map.put(node.left, node);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    map.put(node.right, node);
                }
            }
            Set<TreeNode> set = new HashSet<>();
            while (p != null) {
                set.add(p);
                p = map.get(p);
            }
            while (!set.contains(q)) {
                q = map.get(q);
            }
            return q;
        }
    }
}

