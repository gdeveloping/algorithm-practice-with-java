package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 26
 * Medium
 *
 * @author gdev
 * @date 2022/5/27 21:52
 */
public class Offer26 {

    private static class Solution1 {
        /**
         * time: O(MN), N:len(A), M:len(B)
         * space: O(M+N)
         *
         * @param A -
         * @param B -
         * @return -
         */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {return false;}
            if (A.val == B.val) {
                if (helper(A, B)) {return true;}
            }
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean helper(TreeNode A, TreeNode B) {
            if (A == null && B == null) {return true;}
            if (B == null) {return true;}
            if (A == null) {return false;}
            if (A.val != B.val) {return false;}
            return helper(A.left, B.left) && helper(A.right, B.right);
        }
    }

    private static class Solution2 {
        /**
         * time: O(MN), N:len(A), M:len(B)
         * space: O(M+N)
         *
         * @param A -
         * @param B -
         * @return -
         */
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) {return false;}
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(A);
            TreeNode cur;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                if (cur.val == B.val) {
                    if (helper(cur, B)) {return true;}
                }
                if (cur.left != null) {queue.offer(cur.left);}
                if (cur.right != null) {queue.offer(cur.right);}
            }
            return false;
        }

        private boolean helper(TreeNode A, TreeNode B) {
            Queue<TreeNode> qa = new ArrayDeque<>();
            Queue<TreeNode> qb = new ArrayDeque<>();
            qa.offer(A);
            qb.offer(B);
            TreeNode nodeA, nodeB;
            while (!qa.isEmpty()) {
                nodeA = qa.poll();
                nodeB = qb.poll();
                if (nodeA.left == null && nodeB.left != null) {return false;}
                if (nodeA.right == null && nodeB.right != null) {return false;}
                if (nodeA.left != null && nodeB.left != null) {
                    if (nodeA.left.val != nodeB.left.val) {return false;}
                    qa.offer(nodeA.left);
                    qb.offer(nodeB.left);
                }
                if (nodeA.right != null && nodeB.right != null) {
                    if (nodeA.right.val != nodeB.right.val) {return false;}
                    qa.offer(nodeA.right);
                    qb.offer(nodeB.right);
                }
            }
            return true;
        }
    }
}
