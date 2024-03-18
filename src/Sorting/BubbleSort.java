package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        /*
            Space Complexity : O(1)
            Time Complexity :
            Best: O(n)
            Worst: O(n^2)
            Average: O(n^2)
            Inplace : Yes (Because we are not creating extra array)
            Stable : Yes ( Because we are only swap when current element is greater than other)
         */
        int[] arr = {11,34,4,67,110,1000,1300};
        bubbleSortApproach1(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSortApproach1(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
