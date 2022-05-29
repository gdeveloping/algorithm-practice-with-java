package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.*;

/**
 * 34
 * Medium
 *
 * @author gdev
 * @date 2022/5/29 21:21
 */
public class Offer34 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N) stack
         *
         * @param root -
         * @param target -
         * @return -
         */
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {return res;}
            List<Integer> list = new ArrayList<>();
            helper(res, root, list, target);
            return res;
        }

        private void helper(List<List<Integer>> res, TreeNode root, List<Integer> list, int target) {
            if (root == null) {return;}
            list.add(root.val);
            target -= root.val;
            if (root.left == null && root.right == null) {
                if (target == 0) {
                    res.add(new ArrayList<>(list));
                }
                list.remove(list.size()-1);
                return;
            }
            helper(res, root.left, list, target);
            helper(res, root.right, list, target);
            list.remove(list.size()-1);
        }
    }
}
