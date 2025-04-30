package tech.gdev.algorithmpractice.leetcode.heap.hard;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;
import tech.gdev.algorithmpractice.utils.ListNodeUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23.
 * Hard
 * Merge K Sorted Lists
 *
 * @author gdev
 * @date 2022/4/24 21:19
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        int[][] nums1 = new int[][]{{1,4,5},{1,3,4},{2,6}};
        testCaseSolution2(nums1);
        int[][] nums2 = new int[][]{};
        testCaseSolution2(nums2);
        int[][] nums3 = new int[][]{{}};
        testCaseSolution2(nums3);
    }

    private static void testCaseSolution1(int[][] nums) {
        ListNode[] arr = ListNodeUtil.convertArraysToListNode(nums);
        System.out.println("\nSolution1");
        System.out.println("Source: " + Arrays.deepToString(nums));
        ListNode merged = new Solution1().mergeKLists(arr);
        System.out.println("Merged: ");
        ListNodeUtil.printListNode(merged);
    }

    private static void testCaseSolution2(int[][] nums) {
        ListNode[] arr = ListNodeUtil.convertArraysToListNode(nums);
        System.out.println("\nSolution2");
        System.out.println("Source: " + Arrays.deepToString(nums));
        ListNode merged = new Solution2().mergeKLists(arr);
        System.out.println("Merged: ");
        ListNodeUtil.printListNode(merged);
    }

    private static class Solution1 {
        /**
         * time: O(N*log(K))
         * space: O(K)
         *
         * time: 6ms 29.04%
         * space: 43.41MB 97.65%
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            ListNode dummy = new ListNode();
            ListNode curr = dummy;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
            for (ListNode pItem : lists) {
                if (pItem != null) {
                    pq.offer(pItem);
                }
            }
            while (pq.size() > 1) {
                ListNode node = pq.poll();
                curr.next = node;
                curr = curr.next;
                node = node.next;
                if (node != null) {
                    pq.offer(node);
                }
            }
            curr.next = pq.poll();
            return dummy.next;
        }
    }

    private static class Solution2 {
        /**
         * time: O(log(K)N)
         * space: O(N)
         *
         * time: 1ms 100.00%
         * space: 43.43MB 94.95%
         */
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length < 1) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            return mergeKLists(lists, 0, lists.length-1);
        }

        private ListNode mergeKLists(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            }
            int mid = (left + right) / 2;
            ListNode l1 = mergeKLists(lists, left, mid);
            ListNode l2 = mergeKLists(lists, mid+1, right);
            return mergeTwoLists(l1, l2);
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            tail.next = (l1 != null) ? l1 : l2;
            return dummy.next;
        }
    }
}
