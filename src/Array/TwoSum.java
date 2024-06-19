    package Array;

    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.Map;

    public class TwoSum {
        public static void main(String[] args) {
            int[] nums = {2,7,11,15};
            int target = 9;
            int[] pair = twoSum(nums,target);
            System.out.println("Index:::::  "+Arrays.toString(pair));
        
        }

        
        private static int[] twoSum(int[] nums, int target) {
        //return bruteForceApproach(nums,target);
        //   return hashingApproach(nums,target);
        return twoPointerApproach(nums,target);
        }

        static int[] bruteForceApproach(int[] nums,int target){

            // tc:O(n^2), sc:O(1)
                for(int i=0;i<nums.length;i++){
                    for(int j=i+1;j<nums.length;j++){
                        if(nums[i]+nums[j]==target){
                            // return new int[]{i,j}; // return index
                            return new int[]{nums[i],nums[j]}; // return pair/values
                        }
                    }
                }
                return new int[]{-1,-1};
        }


        static int[] hashingApproach(int[] nums, int target){
                Map<Integer,Integer> map = new HashMap<>();
                for(int i=0;i<nums.length;i++){
                    int temp = target-nums[i];
                    if(map.containsKey(temp)){
                        // return new int[]{map.get(temp),i}; // return index
                        return new int[]{temp,nums[i]}; //return pair/values
                    }else{
                        map.put(nums[i],i);
                    }
                }
                return new int[]{-1,-1};
    }

    private static int[] twoPointerApproach(int[] nums, int target) {
        Arrays.sort(nums);
        int start =0;
        int end = nums.length-1;
        while (start<end) {
        int sum = nums[start]+nums[end];
        if(sum==target){
            return new int[]{nums[start],nums[end]}; // return pair/values
            //return new int[]{start,end}; // return index
        }else if(sum<target){
            start++;
        }else{
            end--;
        }
        }
        return new int[]{-1,-1};
    }

        
    }
