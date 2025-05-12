package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;
import tech.gdev.algorithmpractice.utils.ListNodeUtil;

/**
 * 83.
 * Easy
 * Remove Duplicates from Sorted List
 *
 * @author gdev
 * @date 2025/5/12 22:42
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        testSolution1(new int[]{1,1,2});
        testSolution1(new int[]{1,1,2,3,3});
    }

    private static void testSolution1(int[] arr) {
        System.out.println("\n***");
        ListNode head = ListNodeUtil.convertArrayToListNode(arr);
        ListNode res = new Solution1().deleteDuplicates(head);
        ListNodeUtil.printListNode(res);
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * time: 0ms, 100.00%
         * space: 43.30MB, 43.27%
         */
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode curr = head;
            ListNode lastUnique = head;
            while (curr != null) {
                if (curr.val != lastUnique.val) {
                    lastUnique.next = curr;
                    lastUnique = lastUnique.next;
                }
                curr = curr.next;
            }
            lastUnique.next = null;
            return dummy.next;
        }
    }
}
