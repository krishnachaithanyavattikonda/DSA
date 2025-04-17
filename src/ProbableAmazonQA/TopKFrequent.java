package ProbableAmazonQA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
//    Example 1:
//    Input: nums = [1,1,1,2,2,3], k = 2
//    Output: [1,2]
//    Example 2:
//    Input: nums = [1], k = 1
//    Output: [1]

    static int[] topKFrequent(int[] nums, int k) {
        // Edge case: null or empty array
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        // Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // Min-heap for top k
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a, b) -> freq.get(a) - freq.get(b)
        );
        for (int num : freq.keySet()) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        // Build result
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3,4,4,4,4,5},2)));
    }
}
