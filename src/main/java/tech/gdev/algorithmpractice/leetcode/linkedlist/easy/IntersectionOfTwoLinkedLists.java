package tech.gdev.algorithmpractice.leetcode.linkedlist.easy;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;


/**
 * 160.
 * Easy
 *
 * @author gdev
 * @date 2022/5/9 20:45
 */
public class IntersectionOfTwoLinkedLists {

    private static class Solution1 {
        /**
         * time: O(m+n)
         * space: O(1)
         *
         * Runtime: 1 ms, faster than 98.97% of Java online submissions for Intersection of Two Linked Lists.
         * Memory Usage: 56.2 MB, less than 7.24% of Java online submissions for Intersection of Two Linked Lists.
         *
         * @param headA -
         * @param headB -
         * @return -
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode q = headB;

            while (p != q) {
                if (p == null) {
                    p = headB;
                } else {
                    p = p.next;
                }
                if (q == null) {
                    q = headA;
                } else {
                    q = q.next;
                }
            }

            return p;
        }
    }
}
