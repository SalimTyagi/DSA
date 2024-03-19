package TutortAssignments.SortingAssignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q3MergeInterval_56 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        System.out.println(Arrays.deepToString(approach1(intervals)));
    }


    public static int[][] approach1(int[][] intervals){

        List<int[]> output = new ArrayList<>();
        if(intervals.length==0){
            return output.toArray(new int[0][]);
        }

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int[] arr : intervals){
            if(arr[0]<=end){
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
