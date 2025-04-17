package ProbableAmazonQA;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        // Initialize capacity, HashMap, and dummy head/tail
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Return value if key exists, else -1
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // Move to front (most recent)
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        // Update if key exists
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }

        // Create new node
        node = new Node(key, value);
        cache.put(key, node);
        addToFront(node);

        // Evict if over capacity
        if (cache.size() > capacity) {
            Node lru = tail.prev;
            removeNode(lru);
            cache.remove(lru.key);
        }
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(5);
        cache.put(1,4);
        cache.put(2,5);
        cache.put(3,5);
        cache.put(4,-2);
        cache.get(4);
        cache.put(5,11);
        cache.put(10,10);


    }
}