package ProbableAmazonQA;

import java.util.*;

class RateLimiter {
    private final int k;
    private final long window; // in milliseconds
    private final Map<String, Queue<Long>> userRequests;

    public RateLimiter(int k, int windowSeconds) {
        this.k = k;
        this.window = windowSeconds * 1000L;
        this.userRequests = new HashMap<>();
    }

    public synchronized boolean allowRequest(String userId) {
        // Get current time
        long now = System.currentTimeMillis();

        // Initialize queue for user if absent
        userRequests.computeIfAbsent(userId, key -> new LinkedList<>());
        Queue<Long> queue = userRequests.get(userId);

        // Remove timestamps outside window
        while (!queue.isEmpty() && now - queue.peek() > window) {
            queue.poll();
        }

        // Check if request is allowed
        if (queue.size() < k) {
            queue.offer(now);
            return true;
        }
        return false;
    }
}