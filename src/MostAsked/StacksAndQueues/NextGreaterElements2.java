package MostAsked.StacksAndQueues;
import java.util.*;
public class NextGreaterElements2 {
    public static void main(String[] args) {
//        Input: nums = [1,2,1]
//        Output: [2,-1,2]
//        Explanation: The first 1's next greater number is 2;
//        The number 2 can't find next greater number.
//        The second 1's next greater number needs to search circularly, which is also 2.
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1,2,3,4,3})));
    }
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            stack.push(nums[i]);
        }
        for(int i=nums.length-1;i>=0;i--){
            int number=nums[i];
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }

            nums[i]=stack.empty()?-1:stack.peek();
            stack.push(number);
        }
        return nums;
    }
}
