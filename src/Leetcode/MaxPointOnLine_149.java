package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPointOnLine_149 {
    public static void main(String[] args) {

    }

    static int bruteForce(int[][] points){

    }

    static int maxPoint(int[][] points){
        int ans = 0;

        for (int i = 0; i < points.length; i++) {
            int count = 0;
            Map<List<Integer>,Integer> frequency = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(j==i) continue;

                List<Integer> slope =  new ArrayList<>();
                int numerator = points[j][0] - points[i][0];
                int denominator = points[j][1]- points[i][1];
                int gcd = gcd(numerator,denominator);
                if(gcd>0){
                    numerator/=gcd;
                    denominator/=gcd;
                }
                if(denominator<0){
                    numerator = -numerator;
                }
                if(numerator==0){
                    denominator =1;
                }
                if(denominator==0){
                    numerator=1;
                }

                slope.add(numerator);
                slope.add(denominator);

                if(frequency.containsKey(slope)){
                    int freq = frequency.get(slope);
                    frequency.put(slope,freq++);
                    count = freq;
                }else {
                    count = 1;
                    frequency.put(slope,1);
                }
            }
            ans = Math.max(ans,count+1);
        }
        return ans;
    }

    private static int gcd(int numerator, int denominator) {
        int gcd = 0;
        for (int i = 1; i <= numerator && i<= denominator; i++) {
            if(numerator%i==0 && denominator%i==0){
                gcd = i;
            }
        }
        return gcd;
    }
}
