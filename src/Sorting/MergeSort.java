package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        /*
        1. It works on the principle of divide and conquer
            Space Complexity : O(1)
            Time Complexity:
            Best: O(n logn)
            Worst: O(n logn)
            Average: O(n logn)
            Inplace: No
            Stable: Yes
         */
        int[] arr = {64,25,12,22,11};
        mergeSortApproach1(arr,0,arr.length-1);
    }

    private static void mergeSortApproach1(int[] arr, int start, int end) {

        if(start>=end){
            return;
        }
        // divide the array
        int mid = start+(end-start)/2;
        mergeSortApproach1(arr,start,mid);
        mergeSortApproach1(arr,mid+1,end);

        //merge the array
        merge(arr,start,mid,end);

    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] merge = new int[arr.length];

        int i = start;
        int j = mid;
        int k =0;

        while (i<=mid && j<=end){
            if(arr[i]<arr[j]){
                    merge[k++] = arr[i++];
            }else {
                merge[k++] = arr[j++];
            }
        }

        while (i<=mid){
            merge[k++] = arr[i++];
        }

        while (j<=end){
            merge[k++] = arr[j++];
        }

        k = 0;
        for (int l = start ; l < end ; l++) {
            arr[l] = merge[k++];
        }

    }
}
