package MostAsked.Arrays;

import java.util.HashMap;

public class TwoSum {

//    Example 1:
//    Input: nums = [2,7,11,15], target = 9
//    Output: [0,1]
//    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length<2){
            return new int[]{};
        }

        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int compliment=target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{i, map.get(compliment)};
            }
            map.put(nums[i],i);
        }
        return new int[]{};

    }
}
