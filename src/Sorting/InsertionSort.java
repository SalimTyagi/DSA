package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        /*
            Space Complexity : O(1)
            Time Complexity:
            Best: O(n)
            Worst: O(n^2)
            Average: O(n^2)
            Inplace: Yes
            Stable: Yes
         */
        int[] arr = {64,25,12,22,11};
        insertionSortApproach1(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSortApproach1(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>curr){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=curr;
        }
    }
}
