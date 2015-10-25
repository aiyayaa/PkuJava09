/**
 * Remove Element
 */
//package pku.ss.java.zhangxitao.second;

/**
 * @author zhangxit
 *
 */

public class Solution {

	public static void main(String[] args) {
		int [] nums = {1};
		int target = 1;
		int result = removeElement(nums,target);
		System.out.println(result);		
	}
	public static int removeElement(int[] nums, int val){
		int len= nums.length;
		for(int i =0;i<len;++i){
			while(nums[i]==val&&i<len){
				nums[i] = nums[--len];				
			}
		}
		return len;
	}
}