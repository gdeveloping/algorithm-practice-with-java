package tech.gdev.algorithmpractice.leetcode.linkedlist.easy;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * 21.
 * Easy
 *
 * @author gdev
 * @date 2022/4/17 22:50
 */
public class MergeTwoSortedLists {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
         * Memory Usage: 41.7 MB, less than 87.90% of Java online submissions for Merge Two Sorted Lists.
         *
         * @param list1 -
         * @param list2 -
         * @return -
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            ListNode dummy = new ListNode();
            ListNode list0 = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    list0.next = list1;
                    list1 = list1.next;
                } else {
                    list0.next = list2;
                    list2 = list2.next;
                }
                list0 = list0.next;
            }
            list0.next = (list1 != null) ? list1 : list2;
            return dummy.next;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(N) stack
         *
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
         * Memory Usage: 42 MB, less than 80.45% of Java online submissions for Merge Two Sorted Lists.
         *
         * @param list1 -
         * @param list2 -
         * @return -
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }

}
