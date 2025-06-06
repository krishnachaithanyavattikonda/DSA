package MostAsked.StacksAndQueues;

import java.util.Arrays;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
//        Example 1:
//        Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//        Output: [3,3,5,5,6,7]
//        Explanation:
//        Window position                Max
//                ---------------               -----
//[1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7

        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1]; // number of windows

        // left & right
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0]; // init
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; ++i) {
            // left
            if (i % k == 0) left[i] = nums[i];
            else            left[i] = Math.max(left[i - 1], nums[i]);
            // right
            int j = n - i - 1;
            if (j % k == (k - 1)) right[j] = nums[j];
            else                  right[j] = Math.max(right[j + 1], nums[j]);
        }

        // dp
        for (int i = 0, j = i + k - 1; j < n; ++i, ++j) {
            result[i] = Math.max(right[i], left[j]);
        }

        return result;
    }
}
