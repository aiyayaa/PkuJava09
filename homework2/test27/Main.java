package test27;

public class Main {

	public static void main(String[] args) {
		int [] nums = {1};
		int target = 1;
		int result = removeElement(nums,target);
		System.out.println(result);		
	}
	/*
	 * ����˼·����������
	 */
	
	
	
	//solution1
	public static int removeElement(int[] nums, int val){
		int len= nums.length;
		for(int i =0;i<len;++i){
//			while(nums[i]==val) {   ���û��i<len�ж� ������ֱ�ӽ�����һ��ѭ����ʱ������Խ��
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
	
	
//�����û�����⡣����Ӣ����������= =	
/*	public static int removeElement(int[] nums, int val){
		int result = 0;
		for(int i =0;i<nums.length;++i){
//			while(nums[i]==val) {   ���û��i<len�ж� ������ֱ�ӽ�����һ��ѭ����ʱ������Խ��
			if(nums[i]!=val){
				++result;				
			}
		}
		return result;	
	}*/
}