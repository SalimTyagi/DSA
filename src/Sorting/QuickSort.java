package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        /*
            Space Complexity : O(1)
            Time Complexity:
            Best: O(n logn)
            Worst: O(n^2)
            Average: O(n logn)
            Inplace: Yes
            Stable: No
         */
        int[] input = {5, 4, 3, 2, 1};
        quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while (start <= end) {

            while (arr[start] < pivot) {
                start++;
            }

            while (arr[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }
}
