package test169;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int [] nums = {2,3,2,4,1,2,5};
		int res = majorityElement(nums);
		System.out.println(res);
	}
	// solution 1 
	public static int majorityElement(int [] nums){
		 int major=nums[0], count = 1;
	        for(int i=1; i<nums.length;i++){
	            if(count==0){
	                count++;
	                major=nums[i];
	            }else if(major==nums[i]){
	                count++;
	            }else count--;

	        }
	        return major;
	}
	// solution 2
	public int majorityElement1(int[] nums) {
	    Arrays.sort(nums);
	    return nums[nums.length/2];
	}
	
}
