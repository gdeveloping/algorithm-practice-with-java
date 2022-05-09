package tech.gdev.algorithmpractice.leetcode.linkedlist.medium;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;


/**
 * 86.
 * Medium
 *
 * @author gdev
 * @date 2022/5/9 22:12
 */
public class PartitionList {

    public static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
         * Memory Usage: 42.8 MB, less than 37.57% of Java online submissions for Partition List.
         *
         * @param head -
         * @param x -
         * @return -
         */
        public ListNode partition(ListNode head, int x) {
            ListNode bigHead = new ListNode(-1);
            ListNode bigTail = bigHead;
            ListNode smallHead = new ListNode(-1);
            ListNode smallTail = smallHead;
            while (head != null) {
                if (head.val < x) {
                    smallTail.next = head;
                    smallTail = smallTail.next;
                } else {
                    bigTail.next = head;
                    bigTail = bigTail.next;
                }
                head = head.next;
            }
            smallTail.next = bigHead.next;
            bigTail.next = null;
            return smallHead.next;
        }
    }

}
