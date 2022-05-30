package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 36
 * Medium
 *
 * @author gdev
 * @date 2022/5/30 10:49
 */
public class Offer36 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param root -
         * @return -
         */
        public Node treeToDoublyList(Node root) {
            if (root == null) {return null;}
            Node dummy = new Node(-1);
            Node node = dummy;
            Node cur = root;
            Deque<Node> stack = new ArrayDeque<>();
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                node.right = cur;
                cur.left = node;
                node = node.right;
                cur = cur.right;
            }
            node.right = dummy.right;
            dummy.right.left = node;
            return dummy.right;
        }
    }


    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(N) stack
         *
         * @param root -
         * @return -
         */
        public Node treeToDoublyList(Node root) {
            if (root == null) {return null;}
            Node dummy = new Node(-1);
            pre = dummy;
            helper(root);
            pre.right = dummy.right;
            dummy.right.left = pre;
            return dummy.right;
        }

        Node pre;

        private void helper(Node node) {
            if (node == null) {return;}
            helper(node.left);
            pre.right = node;
            node.left = pre;
            pre = pre.right;
            helper(node.right);
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
