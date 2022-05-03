package tech.gdev.algorithmpractice.leetcode.tree.easy;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

/**
 * 108.
 * Easy
 *
 * @author gdev
 * @date 2022/5/3 16:47
 */
public class ConvertSortedArrayToBinarySearchTree {

    private static class Solution1 {
        /**
         * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
         * Memory Usage: 43.4 MB, less than 64.48% of Java online submissions for Convert Sorted Array to Binary Search Tree.
         *
         * @param nums -
         * @return -
         */
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length-1);
        }

        private TreeNode helper(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            if (left == right) {
                return new TreeNode(nums[left]);
            }
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, left, mid-1);
            root.right = helper(nums, mid+1, right);
            return root;
        }
    }
}
