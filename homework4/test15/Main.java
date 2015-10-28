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
	//solution1：暴力解法  NO AC time : Time Limit Exceeded
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
	
	
	//solution2：O(n^2)解法，类似于快排，no hashmap
	public static List<List<Integer>> threeSum(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
/*	    
 * 		@LinkedList<>
 * 		List是一个接口，ArrayList和LinkedList是两个实现类，他们实现的方式不一样
 * 		1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
 * 	    2.对于随机访问get和set，ArrayList优于LinkedList，因为ArrayList可以随机定位，
 * 			而LinkedList要移动指针一步一步的移动到节点处。
 *      3.对于新增和删除操作add和remove，LinedList比较占优势，只需要对指针进行
*/	    
	    for (int i = 0; i < num.length-2; i++) {			
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {	
	        	//lo指向数组头，hi指向数组尾，sum为约束条件
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];				
	            while (lo < hi) {					
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
/*
 * 		@Arrays.asList()
 * 		将一个数组转化为一个List对象，这个方法会返回一个ArrayList类型的对象，
 * 		 这个ArrayList类并非java.util.ArrayList类，而是Arrays类的静态内部类！
 */
	                    //前后数组相同时跳过
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } 
	                //数组是排好序的，和小于sum时lo向前移动，大于sum时hi向后移动
	                else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
}
