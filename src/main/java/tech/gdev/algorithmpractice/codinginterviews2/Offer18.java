package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * 18
 * Easy
 *
 * @author gdev
 * @date 2022/5/26 22:15
 */
public class Offer18 {
    private static class Solution1 {
        public ListNode deleteNode(ListNode head, int val) {
            if (head == null) {return head;}
            if (head.val == val) {return head.next;}
            ListNode pre = head;
            ListNode cur = head.next;
            while (cur != null && cur.val != val) {
                pre = cur;
                cur = cur.next;
            }
            if (cur != null) {pre.next = cur.next;}
            return head;
        }
    }
}
