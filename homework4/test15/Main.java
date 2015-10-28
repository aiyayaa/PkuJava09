package test15;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		int [] test = {-10,5,-11,-15,7,-7,-10,-8,-3,13,9,-14,4,3,5,-7,13,1,-4,-11,5,9,-11,-4,14,0,3,-10,-3,-7,10,-5,13,14,-5,6,14,0,5,-12,-10,-1,-11,9,9,1,-13,0,-13,-1,4,0,-7,8,3,14,-15,-9,-10,-3,0,-15,-1,-2,6,9,11,6,-14,1,1,-9,-14,6,7,10,14,2,-13,-13,8,6,-6,8,-9,12,7,-9,-11,4,-4,-4,4,10,1,-12,-3,-2,1,-10,6,-13,-3,-1,0,11,-5,0,-2,-11,-6,-9,11,3,14,-13,0,7,-14,-4,-4,-11,-1,8,6,8,3};
		List<List<Integer>> result = threeSum(test);
		System.out.println(result);
	}
	//solution1�������ⷨ  NO AC time : Time Limit Exceeded
//	public static List<List<Integer>> threeSum(int [] nums){
//		List<List<Integer>> result = new ArrayList<List<Integer>>();
//		for(int i=0 ; i<nums.length;++i){
//			for(int j=i+1;j<nums.length;++j){
//				for(int k=j+1;k<nums.length;++k){
//					if(nums[i]+nums[j]+nums[k]==0){
//						List<Integer> num = new ArrayList<Integer>();
//						int temp1 = Math.max(nums[i], nums[j]);
//						int temp2 = Math.min(nums[i], nums[j]);
//						int temp3 = nums[k]>temp1?temp1:nums[k]<temp2?temp2:nums[k];
// 						num.add(Math.min(temp2, nums[k]));
// 						num.add(temp3);
//						num.add(Math.max(temp1, nums[k]));
//						if(!result.contains(num)){
//							result.add(num);
//						}
//					}
//				}
//			}
//		}
//		return result;
//	}
	
	
	//solution2��O(n^2)�ⷨ�������ڿ��ţ�no hashmap
	public static List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
/*	    
 * 		@LinkedList<>
 * 		List��һ���ӿڣ�ArrayList��LinkedList������ʵ���࣬����ʵ�ֵķ�ʽ��һ��
 * 		1.ArrayList��ʵ���˻��ڶ�̬��������ݽṹ��LinkedList������������ݽṹ��
 * 	    2.�����������get��set��ArrayList����LinkedList����ΪArrayList���������λ��
 * 			��LinkedListҪ�ƶ�ָ��һ��һ�����ƶ����ڵ㴦��
 *      3.����������ɾ������add��remove��LinedList�Ƚ�ռ���ƣ�ֻ��Ҫ��ָ�����
*/	    
	    for (int i = 0; i < num.length-2; i++) {			
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {	
	        	//loָ������ͷ��hiָ������β��sumΪԼ������
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];				
	            while (lo < hi) {					
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
/*
 * 		@Arrays.asList()
 * 		��һ������ת��Ϊһ��List������������᷵��һ��ArrayList���͵Ķ���
 * 		 ���ArrayList�ಢ��java.util.ArrayList�࣬����Arrays��ľ�̬�ڲ��࣡
 */
	                    //ǰ��������ͬʱ����
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } 
	                //�������ź���ģ���С��sumʱlo��ǰ�ƶ�������sumʱhi����ƶ�
	                else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
}
