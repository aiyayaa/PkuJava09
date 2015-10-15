public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i < len; i++) {
            if (nums[i] == 0)    //remember the difference between "=" and "=="
                count0++;
            if (nums[i] == 1)
                count1++;
        }
        for(int i = 0; i < count0; i++) {
            nums[i] = 0;
        }
        for(int i = count0; i < count0 + count1;i++)
            nums[i] = 1;
        for(int i = count0 + count1;i < len;i++)
            nums[i] = 2;
    }
}

