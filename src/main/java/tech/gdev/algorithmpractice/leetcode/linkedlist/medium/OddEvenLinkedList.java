package tech.gdev.algorithmpractice.leetcode.linkedlist.medium;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;


/**
 * 328.
 * Medium
 *
 * @author gdev
 * @date 2022/5/10 22:18
 */
public class OddEvenLinkedList {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
         * Memory Usage: 41.9 MB, less than 85.45% of Java online submissions for Odd Even Linked List.
         *
         * @param head -
         * @return -
         */
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                odd = odd.next;
                even.next = even.next.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }
}
