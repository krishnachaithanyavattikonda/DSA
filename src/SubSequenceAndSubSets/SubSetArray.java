package SubSequenceAndSubSets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetArray {
    public static void main(String[] args) {
        //System.out.println(subsets(new int[]{1,2,3,4,5,6,7,8,9,0,11,12,13,14,15,16,17,18,19,20}));
        //System.out.println(subsets(new int[]{1,2,3,4,5}));
        System.out.println(subsetsWithIgnoringDuplicates(new int[]{1,2,4,2}));

    }
    static List<List<Integer>> subsets(int[] arr){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num:arr){
            int n=outer.size();
            for(int i=0;i<n;i++){
                List<Integer> internal=new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
    static List<List<Integer>> subsetsWithIgnoringDuplicates(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0;
        int end=0;
        for (int i = 0; i < arr.length; i++) {
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end=outer.size()-1;
            int n=outer.size();
            for (int j=start;j<n;j++){
                List<Integer> internal=new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
