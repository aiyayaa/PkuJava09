package test136;

public class Main {

	public static void main(String[] args) {
		int [] nums = {1,2,1,3,4,4,3};
		int result = singleNumber(nums);
		System.out.println(result);
	}
/*
 * 初见思路：use HashSet	(实际上并没有用，然而我一开始就是这么想的)
*/
	
/*
 * 		solution1	要用XOR(异或)
*/
	public static int singleNumber(int [] nums){
		    for (int i = 1; i<nums.length; i++) nums[0] ^=nums[i];
		    return nums[0];
	}
}
