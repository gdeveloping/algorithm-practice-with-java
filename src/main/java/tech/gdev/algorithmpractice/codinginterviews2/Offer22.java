package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * 22
 * Easy
 *
 * @author gdev
 * @date 2022/5/27 21:04
 */
public class Offer22 {

    private static class Solution {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param head -
         * @param k -
         * @return -
         */
        public ListNode getKthFromEnd(ListNode head, int k) {
            if (head == null || k <= 0) {return null;}
            ListNode slow = head;
            ListNode fast = head;
            while (k-- > 0) {
                if (fast != null) {
                    fast = fast.next;
                } else {
                    return null;
                }
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
