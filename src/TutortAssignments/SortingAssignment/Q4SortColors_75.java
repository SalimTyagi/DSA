package TutortAssignments.SortingAssignment;

import java.util.Arrays;

public class Q4SortColors_75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        approach1(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void approach1(int[] nums){
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

    static void approach2(int[] nums){
        int start = 0;
        int end = nums.length-1;
        int index = 0;
        while(index<=end){
            if(nums[index]==0){
                int temp = nums[index];
                nums[index] = nums[start];
                nums[start] = temp;
                start++;
                index++;
            }else if(nums[index]==1){
                index++;
            }else{
                int temp = nums[index];
                nums[index] = nums[end];
                nums[end] = temp;
                end--;
            }
        }

    }
}
