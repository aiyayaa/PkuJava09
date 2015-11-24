public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            
            else {
                nums[count] = nums[i];
                count ++;
            }
        }
        return count;
    }
}
