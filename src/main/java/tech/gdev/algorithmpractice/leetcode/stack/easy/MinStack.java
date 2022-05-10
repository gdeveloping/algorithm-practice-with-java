package tech.gdev.algorithmpractice.leetcode.stack.easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155.
 * Easy
 *
 * @author gdev
 * @date 2022/5/10 22:05
 */
public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /**
     * Runtime: 11 ms, faster than 18.31% of Java online submissions for Min Stack.
     * Memory Usage: 48.8 MB, less than 26.09% of Java online submissions for Min Stack.
     */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else if (val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (!minStack.isEmpty() && val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
