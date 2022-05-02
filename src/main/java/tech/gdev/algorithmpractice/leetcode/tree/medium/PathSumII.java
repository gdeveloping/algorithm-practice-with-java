package tech.gdev.algorithmpractice.leetcode.tree.medium;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 113.
 * Medium
 *
 * @author gdev
 * @date 2022/5/2 20:19
 */
public class PathSumII {

    private static class Solution1 {
        /**
         * Runtime: 2 ms, faster than 72.32% of Java online submissions for Path Sum II.
         * Memory Usage: 44.3 MB, less than 71.10% of Java online submissions for Path Sum II.
         *
         * @param root -
         * @param targetSum -
         * @return -
         */
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            this.res = new ArrayList<>();
            this.path = new ArrayList<>();
            dfs(root, targetSum);
            return res;
        }

        List<List<Integer>> res;
        List<Integer> path;

        private void dfs(TreeNode root, int sum) {
            if (root == null) {return;}
            path.add(root.val);
            sum -= root.val;
            if (root.left == null && root.right == null && sum == 0) {
                List<Integer> list = new ArrayList<>(path);
                res.add(list);
            }
            dfs(root.left, sum);
            dfs(root.right, sum);
            path.remove(path.size()-1);
        }
    }

    private static class Solution2 {
        /**
         * Runtime: 2 ms, faster than 72.32% of Java online submissions for Path Sum II.
         * Memory Usage: 42.8 MB, less than 85.06% of Java online submissions for Path Sum II.
         *
         * @param root -
         * @param targetSum -
         * @return -
         */
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;
            TreeNode pre = null;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    targetSum -= curr.val;
                    path.add(curr.val);
                    curr = curr.left;
                }
                curr = stack.peek();
                if (targetSum == 0 && curr.left == null && curr.right == null) {
                    res.add(new ArrayList<>(path));
                }
                if (curr.right == null || curr.right == pre) {
                    curr = stack.pop();
                    targetSum += curr.val;
                    path.remove(path.size()-1);
                    pre = curr;
                    curr = null;
                } else {
                    curr = curr.right;
                }
            }
            return res;
        }
    }
}
