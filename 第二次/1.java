public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] result = new int[2];
       for(int i = 0; i < len; i++) {
           int temp = target - nums[i];
           for(int j = i + 1; j < len; j++) {
               if(nums[j] == temp) {
                   if (i > j) {
                       result[0] = j+1;
                       result[1] = i+1;
                   }
                   else {
                       result[0] = i+1;
                       result[1] = j+1;
                   }
                   return result;
               }
               
           }
           
       }
       return result;
    }
}