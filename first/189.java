public class Solution {
    public void rotate(int[] nums, int k) {
        //int temp;
        //int[] temp = new int [k];
        
        
        int len = nums.length;
        int[] temp = new int[len];
        //temp = nums.Clone();
        /*for (int i = 0; i < len; i++) {   //time limited!!!
            temp[i] = nums[i];
        }*/
        System.arraycopy(nums , 0 , temp , 0 , len);
        for (int i = 0; i < len; i++) {
        //    temp = nums[len - k + i];
        //    nums [len - k + i] = nums [i];
        //    nums [i] = temp;
            nums[(i + k)%len] = temp [i];
        }
    }
}