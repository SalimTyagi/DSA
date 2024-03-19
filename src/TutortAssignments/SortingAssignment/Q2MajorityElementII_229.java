package TutortAssignments.SortingAssignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2MajorityElementII_229 {
    public static void main(String[] args) {
        System.out.println(approach1(new int[]{3,2,3}));
    }

    private static List<Integer> approach1(int[] nums) {

        List<Integer> majorityElementList = new ArrayList<>();
        int majority = nums.length/3;
        Map<Integer,Integer> countMap = new HashMap<>();

        for(int num : nums){
            if(countMap.containsKey(num)){
                int prevCount = countMap.get(num);
                countMap.put(num, prevCount + 1);
            }else{
                countMap.put(num,1);
            }
        }

        for(int num : nums){
            if(!majorityElementList.contains(num) && countMap.get(num)>majority){
                majorityElementList.add(num);
            }
        }

        return majorityElementList;
    }
}
