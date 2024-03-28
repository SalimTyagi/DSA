package GFG;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConsecutiveArrayElement {
    public static void main(String[] args) {
        long[] arr = {5, 4, 2, 1, 3};
        System.out.println(areConsecutives(arr,arr.length));
        System.out.println(areConsecutive(arr,arr.length));
    }

    //optimised
    static boolean areConsecutives(long arr[], int N)
    {
        Map<Long,Integer> map  =new HashMap<>();
        long min = Integer.MAX_VALUE;
        boolean ans = true;
        for (int i = 0; i < N; i++) {
            map.put(arr[i],i);
            if(arr[i]<min){
                min = arr[i];
            }
        }

        for (int i = 0; i < N; i++) {
              if(!map.containsKey(min++)){
                  ans = false;
                  return ans;
              }
        }
        return ans;
    }

    //more optimised using one traversal
    static boolean areConsecutive(long[] arr, int n){
        Set<Long> set =  new HashSet<>();
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(set.contains(arr[i])){
                return false;
            }
            set.add(arr[i]);
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
        }
        long length = max-min+1;
        return length==set.size();

    }
}
