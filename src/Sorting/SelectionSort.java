package Sorting;

import java.util.Arrays;

/*
Sorting is a technique to arrange all elements in a specific order.
i.e Ascending, Descending order
 */
public class SelectionSort {
    public static void main(String[] args) {
        /*
        1. Divides the array into two parts i.e sorted and unsorted
        2. pick minimum element and swap
        Space Complexity: O(1)
        Time Complexity:
        Best: O(n^2)
        Worst: O(n^2)
        Average: O(n^2)
        Inplace : Yes (Because we are not creating extra array)
        Stable : No ( An algo is stable when order of same element did not change)
         */
        int[] arr = {12,34,45,67,11,100,13};
        selectionSortApproach1(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSortApproach1(int[] arr) {

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            //now swap
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
