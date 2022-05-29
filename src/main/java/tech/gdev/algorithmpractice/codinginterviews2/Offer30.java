package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 30
 * Easy
 *
 * @author gdev
 * @date 2022/5/29 16:57
 */
public class Offer30 {

    private static class Solution1 {
        private static class MinStack {
            Deque<Integer> stack;
            Deque<Integer> min;

            /** initialize your data structure here. */
            public MinStack() {
                stack = new ArrayDeque<>();
                min = new ArrayDeque<>();
            }

            public void push(int x) {
                stack.push(x);
                if (min.isEmpty() || min.peek() >= x) {
                    min.push(x);
                }
            }

            public void pop() {
                if (stack.isEmpty()) {return;}
                if (Objects.equals(min.peek(), stack.peek())) {min.pop();}
                stack.pop();
            }

            public int top() {
                if (stack.isEmpty()) {return Integer.MIN_VALUE;}
                return stack.peek();
            }

            public int min() {
                if (min.isEmpty()) {return Integer.MIN_VALUE;}
                return min.peek();
            }
        }
    }
}
