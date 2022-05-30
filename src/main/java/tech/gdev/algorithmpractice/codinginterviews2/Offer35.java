package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.HashMap;
import java.util.Map;

/**
 * 35
 * Medium
 *
 * @author gdev
 * @date 2022/5/30 09:55
 */
public class Offer35 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param head -
         * @return -
         */
        public Node copyRandomList(Node head) {
            if (head == null) {return null;}
            Map<Node, Node> map = new HashMap<>();
            Node cur = head;
            Node dummy = new Node(-1);
            Node node = dummy;
            while (cur != null) {
                node.next = new Node(cur.val);
                node = node.next;
                map.put(cur, node);
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            return dummy.next;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param head -
         * @return -
         */
        public Node copyRandomList(Node head) {
            if (head == null) {return null;}

            Node cur = head;
            Node node;
            while (cur != null) {
                node = new Node(cur.val);
                node.next = cur.next;
                cur.next = node;
                cur = cur.next.next;
            }

            cur = head;
            while (cur != null) {
                cur.next.random = (cur.random == null) ? null : cur.random.next;
                cur = cur.next.next;
            }

            Node dummy = new Node(-1);
            node = dummy;
            cur = head;
            Node next;
            while (cur != null) {
                node.next = cur.next;
                node = node.next;
                next = cur.next.next;
                cur.next = next;
                cur = next;
            }
            return dummy.next;
        }
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
