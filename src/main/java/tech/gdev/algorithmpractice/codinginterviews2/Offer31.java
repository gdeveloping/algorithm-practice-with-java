package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 31
 * Medium
 *
 * @author gdev
 * @date 2022/5/29 17:23
 */
public class Offer31 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(N)
         *
         * @param pushed -
         * @param popped -
         * @return -
         */
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed == null && popped == null) {return true;}
            if (pushed == null || popped == null) {return false;}
            Deque<Integer> stack = new ArrayDeque<>();
            int j = 0;
            for (int i = 0; i < pushed.length; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && Objects.equals(stack.peek(), popped[j])) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }
}
