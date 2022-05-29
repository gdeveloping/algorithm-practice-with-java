package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 33
 * Medium
 *
 * @author gdev
 * @date 2022/5/29 18:30
 */
public class Offer33 {

    private static class Solution1 {
        /**
         * time: O(N^2)
         * space: O(N) stack
         *
         * @param postorder -
         * @return -
         */
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length == 0) {return true;}
            return verifyPostorder(postorder, 0, postorder.length-1);
        }

        private boolean verifyPostorder(int[] postorder, int start, int end) {
            if (end < 0 || end >= postorder.length || start >= end) {return true;}
            int i = start;
            while (postorder[i] < postorder[end]) {i++;}
            int j = i;
            while (postorder[i] > postorder[end]) {i++;}
            return i == end
                    && verifyPostorder(postorder, start, j-1)
                    && verifyPostorder(postorder, j, end-1);
        }
    }

    private static class Solution2 {
        public static void main(String[] args) {
            Solution2 s2 = new Solution2();
            int[] postorder;
            postorder = new int[]{5,7,6,9,11,10,8};
//            postorder = new int[]{1,3,2,6,5};
            s2.verifyPostorder(postorder);
        }

        /**
         * time: O(N)
         * space: O(N)
         *
         * @param postorder -
         * @return -
         */
        public boolean verifyPostorder(int[] postorder) {
            if (postorder == null || postorder.length == 0) {return true;}
            Deque<Integer> stack = new ArrayDeque<>();
            int root = Integer.MAX_VALUE;
            for (int i = postorder.length-1; i >= 0; i--) {
                if (postorder[i] > root) {return false;}
                while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                    root = stack.pop();
                }
                stack.push(postorder[i]);
            }
            return true;
        }
    }
}
