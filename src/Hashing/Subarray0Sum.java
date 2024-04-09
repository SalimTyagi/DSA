package Hashing;

import java.util.HashMap;
import java.util.Map;

public class Subarray0Sum {
    public static void main(String[] args) {
       int[] arr = {4,2,-3,1,6};
        System.out.println(findsum(arr,arr.length));
    }

    static boolean findsum(int arr[],int n)
    {
        boolean subArrayWithZeroSum = false;
        Map<Integer, Boolean> map  = new HashMap<>();
        map.put(0,true);
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum+=arr[i];

            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,true);
            }else {
                subArrayWithZeroSum = true;
                return subArrayWithZeroSum;
            }
        }
        return subArrayWithZeroSum;

    }
}
