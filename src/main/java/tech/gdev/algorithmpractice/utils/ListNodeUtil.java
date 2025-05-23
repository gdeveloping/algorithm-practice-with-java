package tech.gdev.algorithmpractice.utils;

import tech.gdev.algorithmpractice.leetcode.linkedlist.single.ListNode;

/**
 * @author gdev
 * @date 2025/4/30 22:43
 */
public class ListNodeUtil {
    public static ListNode convertArrayToListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int val : array) {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        return dummy.next;
    }

    public static ListNode[] convertArraysToListNode(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new ListNode[0];
        }
        ListNode[] nodes = new ListNode[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            nodes[i] = convertArrayToListNode(arrays[i]);
        }
        return nodes;
    }

    public static void printListNode(ListNode node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            System.out.println(" -> " + node.val);
            node = node.next;
        }
    }
}
