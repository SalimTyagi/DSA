package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] arr = {-2,0,0,2,2};
        System.out.println(approach1(arr));
    }

    private static List<List<Integer>> approach1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int target = -(nums[i]);
            int start = i+1;
            int end = nums.length-1;

            while(start<end){
                int sum = nums[start]+nums[end];

                if(target == sum){
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[i]);
                    pair.add(nums[start]);
                    pair.add(nums[end]);
                    ans.add(pair);
                    while(start+1<nums.length && nums[start]==nums[start+1]){
                        start++;
                    }
                    while(end+1>start && nums[end]==nums[end-1]){
                        start++;
                    }
                    start++;
                    end--;
                }else if(sum>target){
                    end--;
                }else{
                    start++;
                }
            }
            while(i+1<nums.length && nums[i]==nums[i+1]){
                i++;
            }
        }
        return ans;
    }
}
