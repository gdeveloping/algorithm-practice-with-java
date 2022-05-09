package tech.gdev.algorithmpractice.leetcode.linkedlist.medium;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;


/**
 * 92.
 * Medium
 *
 * @author gdev
 * @date 2022/5/9 22:27
 */
public class ReverseLinkedListII {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
         * Memory Usage: 42.2 MB, less than 19.45% of Java online submissions for Reverse Linked List II.
         *
         * 1, 2, ..., left, ..., right, ...
         *        ll, lr, ...,   head
         *
         * @param head -
         * @param left -
         * @param right -
         * @return -
         */
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == right) {
                return head;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;

            int count = 0;
            ListNode ll = null;  // left left
            ListNode lr = null;  // left right
            ListNode pre = dummy;
            ListNode next;
            while (head != null) {
                count++;
                if (count < left) {
                    head = head.next;
                    pre = pre.next;
                } else if (count == left) {
                    ll = pre;
                    lr = head;
                    head = head.next;
                    pre = pre.next;
                } else if (count > left && count < right) {
                    next = head.next;
                    head.next = pre;
                    pre = head;
                    head = next;
                } else if (count == right) {
                    lr.next = head.next;
                    head.next = pre;
                    ll.next = head;
                    break;
                }
            }
            return dummy.next;
        }
    }
}
