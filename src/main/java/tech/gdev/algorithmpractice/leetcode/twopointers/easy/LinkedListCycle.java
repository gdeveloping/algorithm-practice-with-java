package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * 141.
 * Easy
 *
 * @author gdev
 * @date 2022/4/21 20:39
 */
public class LinkedListCycle {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
         * Memory Usage: 43.9 MB, less than 78.26% of Java online submissions for Linked List Cycle.
         *
         * @param head -
         * @return -
         */
        public boolean hasCycle(ListNode head) {
            if (head == null) {return false;}
            ListNode fast, slow;
            fast = slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) {
                    return true;
                }
            }
            return false;
        }
    }
}
