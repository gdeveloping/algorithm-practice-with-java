package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 27
 * Easy
 *
 * @author gdev
 * @date 2022/5/28 23:28
 */
public class Offer27 {

    private static class Solution1 {
        /**
         * time: O(N), N:len(tree)
         * space: O(N)
         *
         * @param root -
         * @return -
         */
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {return null;}
            TreeNode temp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(temp);
            return root;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N), N:len(tree)
         * space: O(N)
         *
         * @param root -
         * @return -
         */
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) {return null;}
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            TreeNode cur;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if (cur.left != null) {queue.offer(cur.left);}
                if (cur.right != null) {queue.offer(cur.right);};
            }
            return root;
        }
    }
}
