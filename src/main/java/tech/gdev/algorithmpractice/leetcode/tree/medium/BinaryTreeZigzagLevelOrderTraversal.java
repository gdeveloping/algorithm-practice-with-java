package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.*;

/**
 * 102.
 * Medium
 *
 * @author gdev
 * @date 2022/4/21 20:07
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 1 ms, faster than 85.85% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
         * Memory Usage: 43 MB, less than 35.80% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
         *
         * @param root -
         * @return -
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {return Collections.emptyList();};
            List<List<Integer>> res = new LinkedList<>();
            boolean reverseFlag = false;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                TreeNode node;
                List<Integer> list = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    node = queue.poll();
                    if (node.left != null) {queue.offer(node.left);}
                    if (node.right != null) {queue.offer(node.right);}
                    if (reverseFlag) {
                        list.add(0, node.val);
                    } else {
                        list.add(node.val);
                    }
                }
                reverseFlag = !reverseFlag;
                res.add(list);
            }
            return res;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * Runtime: 1 ms, faster than 85.85% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
         * Memory Usage: 43.1 MB, less than 27.34% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
         *
         * @param root -
         * @return -
         */
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            helper(root, 0, res);
            return res;
        }
        private void helper(TreeNode root, int level, List<List<Integer>> res) {
            if (root == null) {return;}
            if (res.size() == level) {
                res.add(new LinkedList<>());
            }
            if (level % 2 == 0) {
                res.get(level).add(root.val);
            } else {
                res.get(level).add(0, root.val);
            }
            helper(root.left, level+1, res);
            helper(root.right, level+1, res);
        }
    }
}
