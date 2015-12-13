public class Solution {
    public void moveZeroes(int[] nums) {
        int i =0, k = 0;
        int len = nums.length;
        
        while(i < len) {
            if(nums[i] != 0) {
                nums[k++] = nums[i++];
            }else{
                i++;
            }
        }
        
        while(k < len) {
            nums[k++] = 0;
        }
        
    }
}