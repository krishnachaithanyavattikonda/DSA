package MostAsked.StacksAndQueues;
import java.util.*;
public class DailyTemperatures {
//    Given an array of integers temperatures represents the daily temperatures, return an array answer
//    such that answer[i] is the number of days you have to wait after the ith day to get a warmer
//    temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
//    Example 1:
//    Input: temperatures = [73,74,75,71,69,72,76,73]
//    Output: [1,1,4,2,1,1,0,0]
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }
}
