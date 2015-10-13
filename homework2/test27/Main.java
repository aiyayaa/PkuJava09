package test27;

public class Main {

	public static void main(String[] args) {
		int [] nums = {1};
		int target = 1;
		int result = removeElement(nums,target);
		System.out.println(result);		
	}
	/*
	 * 初见思路：遍历数组
	 */
	
	
	
	//solution1
	public static int removeElement(int[] nums, int val){
		int len= nums.length;
		for(int i =0;i<len;++i){
//			while(nums[i]==val) {   如果没有i<len判断 容易在直接进入下一次循环的时候数组越界
			while(nums[i]==val&&i<len){
				nums[i] = nums[--len];				
			}
		}
		return len;
	}

	
	
	//solution2
	/*int removeElement(int A[], int n, int elem) {
	    int begin=0;
	    for(int i=0;i<n;i++) if(A[i]!=elem) A[begin++]=A[i];
	    return begin;
	}*/
	
	
//这个是没读懂题。。。英语渣。。。= =	
/*	public static int removeElement(int[] nums, int val){
		int result = 0;
		for(int i =0;i<nums.length;++i){
//			while(nums[i]==val) {   如果没有i<len判断 容易在直接进入下一次循环的时候数组越界
			if(nums[i]!=val){
				++result;				
			}
		}
		return result;	
	}*/
}