package tech.gdev.algorithmpractice.codinginterviews2;

import tech.gdev.algorithmpractice.leetcode.tree.binarytree.TreeNode;

import java.util.*;

/**
 * 32
 * Medium
 *
 * @author gdev
 * @date 2022/5/29 17:37
 */
public class Offer32 {

    private static class SolutionQ1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param root -
         * @return -
         */
        public int[] levelOrder(TreeNode root) {
            if (root == null) {return new int[0];}
            Queue<TreeNode> queue = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            queue.offer(root);
            TreeNode cur;
            while (!queue.isEmpty()) {
                cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {queue.offer(cur.left);}
                if (cur.right != null) {queue.offer(cur.right);}
            }
            int[] res = new int[list.size()];
            int i = 0;
            for (Integer num : list) {res[i++] = num;}
            return res;
        }
    }


    private static class SolutionQ2 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param root -
         * @return -
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {return res;}
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            TreeNode cur;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    cur = queue.poll();
                    list.add(cur.val);
                    if (cur.left != null) {queue.offer(cur.left);}
                    if (cur.right != null) {queue.offer(cur.right);}
                }
                res.add(list);
            }
            return res;
        }
    }

    private static class SolutionQ3 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param root -
         * @return -
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {return res;}
            Deque<TreeNode> stack1 = new ArrayDeque<>();
            Deque<TreeNode> stack2 = new ArrayDeque<>();
            stack1.push(root);
            TreeNode cur;
            boolean flag = true;
            while (!stack1.isEmpty()) {
                List<Integer> list = new ArrayList<>(stack1.size());
                while (!stack1.isEmpty()) {
                    cur = stack1.pop();
                    list.add(cur.val);
                    if (flag) {
                        if (cur.left != null) {stack2.push(cur.left);}
                        if (cur.right != null) {stack2.push(cur.right);}
                    } else {
                        if (cur.right != null) {stack2.push(cur.right);}
                        if (cur.left != null) {stack2.push(cur.left);}
                    }
                }
                res.add(list);
                Deque<TreeNode> temp = stack1;
                stack1 = stack2;
                stack2 = temp;
                flag = !flag;
            }
            return res;
        }
    }
}
