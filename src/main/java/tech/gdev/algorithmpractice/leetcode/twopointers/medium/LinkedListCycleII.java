package tech.gdev.algorithmpractice.leetcode.twopointers.medium;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * 142.
 * Medium
 *
 * @author gdev
 * @date 2022/4/21 20:45
 */
public class LinkedListCycleII {
    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
         * Memory Usage: 42.9 MB, less than 80.53% of Java online submissions for Linked List Cycle II.
         *
         * @param head -
         * @return -
         */
        public ListNode detectCycle(ListNode head) {
            if (head == null) {return null;}
            ListNode fast, slow;
            fast = slow = head;
            boolean hasCycle = false;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    hasCycle = true;
                    break;
                }
            }
            if (!hasCycle) {return null;}
            slow = head;
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
