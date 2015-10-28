package test18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1, 0, -1, 0 ,-2, 2};
		int target = 0;
		List<List<Integer>> result = fourSum(nums,target);
		System.out.println(result);
	}
	//		solution 1
	public static List<List<Integer>> fourSum(int [] nums, int target){
		    if(nums.length < 4) return new ArrayList();
		            List<List<Integer>> res = new ArrayList();
		            Arrays.sort(nums);
		            for(int i = 0; i < nums.length - 3; i++){
		                for(int j = nums.length - 1; j > i + 2; j--){
		                    int start = i + 1, end = j - 1;
		                    while(start < end){
		                        int sum = nums[i] + nums[j] + nums[start] + nums[end];
		                        if(sum == target){
		                            List<Integer> arr = new ArrayList(Arrays.asList(nums[i], nums[start], nums[end], nums[j]));
		                            if(!res.contains(arr))
		                                res.add(arr);
		                            end --;
		                            start ++;
		                        }else if(sum > target){
		                            end --;
		                        }else start ++;
		                    }
		                }
		            }
		            return res;			
	}
}
//        kSum solution µİ¹é£¬Ã»Ì«¿´¶®
//public class Solution {
//	 public List<List<Integer>> fourSum(int[] nums, int target) {
//	  return kSum(nums, target, 4);
//	}
//
//	private List<List<Integer>> kSum(int[] nums, int target, int k) {
//	  List<List<Integer>> res = new ArrayList<List<Integer>>();
//	  if(nums.length < k) return res;
//	  Arrays.sort(nums);
//	  return help(nums, target, k, 0);
//	}
//
//	private List<List<Integer>> help(int[] nums, int target, int k, int count) {
//	  if(k == 2) {
//	     return twoSum(nums, count, target);
//	  } else {
//	     List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//	     for(int i = count; i < nums.length - 1; i++) {
//	        if(i == count || nums[i] != nums[i - 1]) {
//	           List<List<Integer>> tmp = help(nums, target - nums[i], k - 1, i + 1);
//	           for(List<Integer> curr : tmp) {
//	              curr.add(0,nums[i]);
//	              res.add(curr);
//	           }
//	        }
//	     }
//	     return res;
//	  }
//	}
//
//	private List<List<Integer>> twoSum(int[] nums, int start, int target) {
//	  List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//	  int first = start, last = nums.length - 1;
//	  while(first < last) {
//	     if(nums[first] + nums[last] == target) {
//	        List<Integer> curr = new ArrayList<Integer>();
//	        curr.add(nums[first++]);
//	        curr.add(nums[last--]);
//	        res.add(curr);
//	        while(first < last && nums[first] == nums[first - 1]) {
//	           first++;
//	        }
//	        while(first < last && nums[last] == nums[last + 1]) {
//	           last--;
//	        }
//	     } else if(nums[first] + nums[last] < target) {
//	        first++;
//	     } else {
//	        last--;
//	     }
//	  }
//
//	  return res;
//	}
//	}
