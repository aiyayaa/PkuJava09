package test189;

public class Main {

	public static void main(String[] args) {
		int [] nums = {1,2};
		int k = 3 ;
		rotate(nums,k);
//		for(int i = 0; i<nums.length;++i){
//		System.out.println(nums[i]);
//			}
	}
	public static  void rotate(int [] nums , int k){
		int len = nums.length;
		k%=len;	//submitºóÌí¼Ó
		int [] result = new int [len];
		for(int i = 0; i < len-k ;++i)	result[k+i]=nums[i];			
		for(int i = len-k; i<len ;++i)    result[i-len+k]=nums[i];	
		for(int i= 0;i<result.length;++i) nums[i]=result[i];		
//		for(int i = 0; i<nums.length;++i){
//			System.out.println(nums[i]);
//			}
		
	}

	
	
}
