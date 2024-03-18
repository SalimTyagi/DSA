package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval_56 {
    public static void main(String[] args) {
        //sorting question
        int[][] intervals = {{1,3},{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16,17}};
        int[][] output = mergeIntervalApproach1(intervals);
        System.out.println(Arrays.toString(output));
    }

    private static int[][] mergeIntervalApproach1(int[][] intervals) {
        List<int[]> output = new ArrayList<>();
        if(intervals.length == 0){
            return output.toArray(new int[0][]);
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] arr : intervals){
            if(arr[0] <= end){
                end = Math.max(end,arr[1]);
            }else{
                output.add(new int[]{start,end});
                start = arr[0];
                end = arr[1];
            }
        }
        output.add(new int[]{start,end});

        return output.toArray(new int[0][]);
    }
}
