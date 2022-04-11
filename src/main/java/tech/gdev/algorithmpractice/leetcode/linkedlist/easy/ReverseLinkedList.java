package tech.gdev.algorithmpractice.leetcode.linkedlist.easy;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * 206
 * Esay
 * @author gdev
 * @date 2022/4/11 21:09
 */
public class ReverseLinkedList {
    private static class Solution1 {
        /**
         * time: O(n)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
         * Memory Usage: 42.2 MB, less than 83.41% of Java online submissions for Reverse Linked List.
         *
         * begin |     middle        | end
         * a     |  b c d e f g h i  | j
         *
         * @param head -
         * @return -
         */
        public ListNode reverseList(ListNode head) {
            if (head == null) {return head;}
            ListNode prev, curr, next;
            prev = null;
            curr = head;
            next = head.next;
            while (next != null) {
                curr.next = prev;
                prev = curr;
                curr = next;
                next = next.next;
            }
            curr.next = prev;
            return curr;
        }
    }

    private static class Solution2 {
        /**
         * time: O(n)
         * space: stack: O(n)
         *
         * Runtime: 1 ms, faster than 10.08% of Java online submissions for Reverse Linked List.
         * Memory Usage: 42.5 MB, less than 74.81% of Java online submissions for Reverse Linked List.
         *
         * @param head -
         * @return -
         */
        public ListNode reverseList(ListNode head) {
            return dfs(head);
        }

        /**
         * begin |   unprocessed  |  processed   | end
         * a     |    b c d e     |   f g h i    | j
         *
         * @param node -
         * @return -
         */
        private ListNode dfs(ListNode node) {
            if (node == null || node.next == null) {
                return node;
            }
            ListNode tail = dfs(node.next);
            node.next.next = node;
            node.next = null;
            return tail;
        }
    }
}