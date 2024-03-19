package Leetcode;

import java.util.Arrays;

public class SortColors_75 {
    public static void main(String[] args) {
        int[] colors = {2,0,2,1,1,0};
        approach1(colors);
        approach2(colors);
        System.out.println(Arrays.toString(colors));
    }

    static void approach1(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        for(int num : nums){
            if(num==0){
                countZero++;
            }
            if(num==2){
                countTwo++;
            }
            if(num==1){
                countOne++;
            }
        }
        int index = 0;
        for(int i=0;i<countZero;i++){
            nums[index] = 0;
            index++;
        }
        for(int i=0;i<countOne;i++){
            nums[index] = 1;
            index++;
        }
        for(int i=0;i<countTwo;i++){
            nums[index] = 2;
            index++;
        }
    }

    static void approach2(int[] colors) {

    }
}
