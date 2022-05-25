package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 09
 * Easy
 *
 * @author gdev
 * @date 2022/5/25 21:20
 */
public class Offer09 {
    private static class CQueue {

        Deque<Integer> in;
        Deque<Integer> out;

        public CQueue() {
            in = new ArrayDeque<>();
            out = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
            in.push(value);
        }

        public int deleteHead() {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            if (out.isEmpty()) {
                return -1;
            }
            return out.pop();
        }
    }
}
