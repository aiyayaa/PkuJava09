package test136;

public class Main {

	public static void main(String[] args) {
		int [] nums = {1,2,1,3,4,4,3};
		int result = singleNumber(nums);
		System.out.println(result);
	}
/*
 * ����˼·��use HashSet	(ʵ���ϲ�û���ã�Ȼ����һ��ʼ������ô���)
*/
	
/*
 * 		solution1	Ҫ��XOR(���)
*/
	public static int singleNumber(int [] nums){
		    for (int i = 1; i<nums.length; i++) nums[0] ^=nums[i];
		    return nums[0];
	}
}
