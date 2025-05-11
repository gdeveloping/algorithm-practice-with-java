package tech.gdev.algorithmpractice.leetcode.twopointers.medium;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;
import tech.gdev.algorithmpractice.utils.ListNodeUtil;

/**
 * 19.
 * Medium
 * Remove Nth Node From End of List
 *
 * @author gdev
 * @date 1/5/2025 11:03
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        testSolution1(new int[]{1, 2, 3, 4, 5}, 2);
        testSolution1(new int[]{1}, 1);

        testSolution2(new int[]{1, 2, 3, 4, 5}, 2);
        testSolution2(new int[]{1}, 1);
    }

    public static void testSolution1(int[] arr, int n) {
        System.out.println("\n***");
        ListNode node = ListNodeUtil.convertArrayToListNode(arr);
        ListNode head = new Solution1().removeNthFromEnd(node, n);
        ListNodeUtil.printListNode(head);
    }

    public static void testSolution2(int[] arr, int n) {
        System.out.println("\n***");
        ListNode node = ListNodeUtil.convertArrayToListNode(arr);
        ListNode head = new Solution2().removeNthFromEnd(node, n);
        ListNodeUtil.printListNode(head);
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * time: 0ms, 100.00%
         * space: 41.03MB, 25.61%
         *
         * 已知：给定的 k 保证是有效的。
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode slow = head;
            ListNode fast = head;
            ListNode prevSlow = new ListNode();
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                prevSlow = slow;
                slow = slow.next;
                fast = fast.next;
            }
            prevSlow.next = slow.next;
            if (slow == head) {
                return head.next;
            }
            return head;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * time: 0ms, 100.00%
         * space: 41.17MB, 5.33%
         *
         * 已知：给定的 k 保证是有效的。
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode fast = dummy;
            ListNode prevSlow = dummy;
            for (int i = 0; i < n + 1; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                prevSlow = prevSlow.next;
                fast = fast.next;
            }
            if (prevSlow.next == head) {
                return head.next;
            }
            prevSlow.next = prevSlow.next.next;
            return head;
        }
    }
}
