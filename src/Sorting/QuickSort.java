package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[]={5,2,-1,4,5,1};
        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void QuickSort(int[] arr, int low, int high){
        if(low>=high){
            return;
        }
        int s=low;
        int e=high;
        int m=s +(e-s)/2;
        int pivot=arr[m];
        while(s<=e){
            //If its already sorted, it will not swap
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }
            if(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }

        //Time for recursion, Pivot at correct place, now sort two halves.
        QuickSort(arr,low,e);
        QuickSort(arr,s,high);

    }
}
