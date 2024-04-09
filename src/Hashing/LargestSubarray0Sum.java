package Hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarray0Sum {
    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        System.out.println(maxLen(arr,arr.length));
    }

    //optimised approach
    static int maxLen(int arr[], int n) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int prefixSum = 0;
        int ans = 0;
        map.put(0,-1);
        
        for (int i = 0; i < n; i++) {
          prefixSum+=arr[i];
          if(!map.containsKey(prefixSum)){
              map.put(prefixSum,i);
          }else {
              int prevIndex = map.get(prefixSum);
              int len = i-prevIndex;
              ans = Math.max(ans,len);
          }
        }
        return ans;
    }
    
    //brute force
    static int bruteForce(int[] arr, int n){
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum+=arr[k];
                }
                if(sum==0){
                    ans = Math.max(ans,j-i);
                }
            }
            
        }
        return ans;
    }
}
