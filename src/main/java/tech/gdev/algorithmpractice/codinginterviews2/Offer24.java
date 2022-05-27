package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * 24
 * Easy
 *
 * @author gdev
 * @date 2022/5/27 21:25
 */
public class Offer24 {
    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param head -
         * @return -
         */
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {return head;}
            ListNode pre = null;
            ListNode cur = head;
            ListNode next;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
