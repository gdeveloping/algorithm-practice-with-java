package tech.gdev.algorithmpractice.leetcode.twopointers.easy;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;
import tech.gdev.algorithmpractice.utils.ListNodeUtil;

/**
 * 21.
 * Easy
 * Merge Two Sorted Lists
 *
 * @author gdev
 * @date 2025/4/30 22:21
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        testCase(new int[]{1, 2, 4}, new int[]{1, 3, 4});
        testCase(new int[]{}, new int[]{});
        testCase(new int[]{}, new int[]{0});
    }

    public static void testCase(int[] l1, int[] l2) {
        ListNode list1 = ListNodeUtil.convertArrayToListNode(l1);
        System.out.println("\nlist1: ");
        ListNodeUtil.printListNode(list1);
        ListNode list2 = ListNodeUtil.convertArrayToListNode(l2);
        System.out.println("\nlist2: ");
        ListNodeUtil.printListNode(list2);
        ListNode merged = new Solution1().mergeTwoLists(list1, list2);
        System.out.println("\nmerged: ");
        ListNodeUtil.printListNode(merged);
    }

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * time: 0ms 100.00%
         * space: 41.68MB 56.02%
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            }
            ListNode p1 = list1;
            ListNode p2 = list2;
            ListNode dummy = new ListNode();
            ListNode curr = dummy;
            while (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    curr.next = p1;
                    p1 = p1.next;
                } else {
                    curr.next = p2;
                    p2 = p2.next;
                }
                curr = curr.next;
            }
            if (p1 == null) {
                curr.next = p2;
            } else {
                curr.next = p1;
            }
            return dummy.next;
        }
    }
}
