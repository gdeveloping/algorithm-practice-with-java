package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * 52
 * Easy
 *
 * @author gdev
 * @date 2022/7/10 09:28
 */
public class Offer52 {

    private static class Solution1 {
        /**
         * time: O(M+N), M:len(listA), N:len(listB)
         * space: O(1)
         * modify source: N
         *
         * @param headA -
         * @param headB -
         * @return -
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode nodeA = headA, nodeB = headB;
            while (nodeA != nodeB) {
                if (nodeA == null) {
                    nodeA = headB;
                } else {
                    nodeA = nodeA.next;
                }
                if (nodeB == null) {
                    nodeB = headA;
                } else {
                    nodeB = nodeB.next;
                }
            }
            return nodeA;
        }
    }

    private static class Solution2 {
        /**
         * time: O(M+N), M:len(listA), N:len(listB)
         * space: O(1)
         * modify source: N
         *
         * @param headA -
         * @param headB -
         * @return -
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if (headA == null || headB == null) {
                return null;
            }
            ListNode nodeA = headA, nodeB = headB;
            int countA = 0, countB = 0;
            while (nodeA != null) {
                nodeA = nodeA.next;
                ++countA;
            }
            while (nodeB != null) {
                nodeB = nodeB.next;
                ++countB;
            }
            nodeA = headA;
            nodeB = headB;
            int diff;
            diff = countA - countB;
            while (diff > 0) {
                --diff;
                nodeA = nodeA.next;
            }
            diff = countB - countA;
            while (diff > 0) {
                --diff;
                nodeB = nodeB.next;
            }
            while (nodeA != null && nodeB != null) {
                if (nodeA == nodeB) {return nodeA;}
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            return null;
        }
    }
}
