package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * 25
 * Easy
 *
 * @author gdev
 * @date 2022/5/27 21:34
 */
public class Offer25 {

    private static class Solution1 {
        /**
         * time: O(M+N), M:len(l1), N:len(l2)
         * space: O(1)
         *
         * @param l1 -
         * @param l2 -
         * @return -
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = (l1 == null) ? l2 : l1;
            return dummy.next;
        }
    }

    private static class Solution2 {
        /**
         * time: O(M+N), M:len(l1), N:len(l2)
         * space: O(M+N), stack
         *
         * @param l1 -
         * @param l2 -
         * @return -
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {return l2;}
            if (l2 == null) {return l1;}
            ListNode cur;
            if (l1.val <= l2.val) {
                cur = l1;
                cur.next = mergeTwoLists(l1.next, l2);
            } else {
                cur = l2;
                cur.next = mergeTwoLists(l1, l2.next);
            }
            return cur;
        }
    }
}
