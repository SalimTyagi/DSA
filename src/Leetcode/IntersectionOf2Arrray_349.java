package Leetcode;

import java.util.*;

public class IntersectionOf2Arrray_349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(approach1(nums1, nums2)));
    }

    public static int[] approach1(int[] nums1, int[] nums2) {
        // brute force
          Set<Integer> set = new HashSet<>();

          for(int i=0;i<nums1.length;i++){
             for(int j=0;j<nums2.length;j++){
                 if(nums1[i]==nums2[j] && !set.add(nums1[i])){
                     set.add(nums1[i]);
                 }
             }
         }

         int[] result = new int[set.size()];
         int index = 0;
         for(Integer num: set){
             result[index++]=num;
         }


         return result;
    }


    public static int[] approach2(int[] nums1, int[] nums2) {
    // optimised solution

    Map<Integer,Boolean> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();


        for(int i=0;i<nums1.length;i++){
        map.put(nums1[i], true);
    }

        for (int i = 0; i < nums2.length; i++) {
        if(map.containsKey(nums2[i])){
            set.add(nums2[i]);
        }
    }

    int[] result = new int[set.size()];
    int index=0;

        for(Integer num : set){
        result[index++]=num;
    }
        return result;
    }
}
