package tech.gdev.algorithmpractice.leetcode.linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 146.
 * Medium
 *
 * @author gdev
 * @date 2022/4/12 21:24
 */
public class LRUCache_ {
    public static void main(String[] args) {
        Solution.main(null);
    }

    private static class Solution {
        public static void main(String[] args) {
            LRUCache lruCache = new LRUCache(2);
            lruCache.put(1, 1); // cache is {1=1}
            System.out.println(lruCache.cache.keySet());
            lruCache.put(2, 2); // cache is {1=1, 2=2}
            System.out.println(lruCache.cache.keySet());
            System.out.println(lruCache.get(1));    // return 1
            System.out.println(lruCache.cache.keySet());
            lruCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
            System.out.println(lruCache.cache.keySet());
            System.out.println(lruCache.get(2));    // returns -1 (not found)
            System.out.println(lruCache.cache.keySet());
            lruCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
            System.out.println(lruCache.cache.keySet());
            System.out.println(lruCache.get(1));    // return -1 (not found)
            System.out.println(lruCache.cache.keySet());
            System.out.println(lruCache.get(3));    // return 3
            System.out.println(lruCache.cache.keySet());
            System.out.println(lruCache.get(4));    // return 4
        }

        /**
         * Runtime: 84 ms, faster than 49.90% of Java online submissions for LRU Cache.
         * Memory Usage: 133.8 MB, less than 22.06% of Java online submissions for LRU Cache.
         */
        private static class LRUCache {

            private class Node {
                int key;
                int value;
                Node prev;
                Node next;

                public Node() {
                }

                public Node(int key, int value) {
                    this.key = key;
                    this.value = value;
                }
            }

            Map<Integer, Node> cache;
            Node head = new Node();
            Node tail = new Node();
            final int capacity;

            public LRUCache(int capacity) {
                this.capacity = capacity;
                this.cache = new HashMap<>(capacity);
                head.next = tail;
                tail.prev = head;
            }

            public int get(int key) {
                Node node = cache.get(key);
                if (node != null) {
                    remove(node);
                    insert(node);
                    return node.value;
                }
                return -1;
            }

            public void put(int key, int value) {
                Node node = cache.get(key);
                if (node != null) {
                    remove(node);
                } else if (cache.size() == capacity) {
                    remove(tail.prev);
                }
                node = new Node(key, value);
                insert(node);
            }

            private void remove(Node node) {
                cache.remove(node.key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            private void insert(Node node) {
                cache.put(node.key, node);
                node.prev = head;
                node.next = head.next;
                node.prev.next = node;
                node.next.prev = node;
            }
        }
    }
}
