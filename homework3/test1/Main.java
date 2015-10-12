package test1;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		int [] nums = {11,7,2,13};
		int target = 9;
		int [] result = twoSum(nums,target);
		System.out.println(result[0]+" "+result[1]);
	}
/*
	solution1
	暴力解法
	T(n)=O(n^2)
*/	
//	public static int [] twoSum(int [] nums,int target){
//		int [] result = new int [2];
//		for(int i=0;i <nums.length;++i){
//			int temp = target-nums[i];			
//			for(int j=0;j <nums.length;++j){
//				if(nums[j]==temp&&j!=i){
//					result[0]=i>j?j+1:i+1;
//					result[1]=i>j?i+1:j+1;
//					return result;
//				} 
//			}
//		}
//		return result;
//	}
	
/*	
	solution2
	暴力解法2.0_make it more readable
	T(n)=O(n^2)
*/	
//	public class Solution {
//	    public int[] twoSum(int[] nums, int target) {
//	        int[] result = new int[2];
//			for(int i = 0;i<nums.length;i++) {
//	                for(int j = i;j<nums.length;j++){  
//	                	if((nums[i]+nums[j])==target&&(i!=j)){
//	                    	 result[0]=i+1;
//	                    	 result[1]=j+1;                  	 
//	                    }
//	                     
//	                }
//	            }
//			return result;
//	    }
//	}
/*
 * 	solution3 
 *  利用hashmap
 *  T(n)=O(n)
 */
	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}
}
	
	