/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
 * The solution set must not contain duplicate quadruplets.
 */
//package leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxit
 *
 */
public class Solution {
	   public List<List<Integer>> threeSum(int[] num,int target,int start) {
			 List<List<Integer>> res = new ArrayList<List<Integer>>();
			 if(num==null||num.length==0)
				 return res;
			 for(int i=start;i<num.length;i++){
				 ArrayList<Integer> sub = new ArrayList<Integer>();
				 if(i>start && num[i]==num[i-1])
					 continue;
				 int n1 = num[i];
				 int sum = target-n1;
				 int p = i+1,q = num.length-1;
				 while(p<q){
					 if(num[q]+num[p]==sum){
						 sub.add(n1);
						 sub.add(num[p]);
						 sub.add(num[q]);
						 res.add((ArrayList<Integer>)sub.clone());
						 sub = new ArrayList<Integer>();
						 while(p+1<q&&num[p+1]==num[p]){
							 p++;
						 }
						p++;
						 while(q-1>p&&num[q-1]==num[q])
							 q--;
						q--;
					}else if(num[q]+num[p]>sum){
						q--;
						}else{
							p++;
							}
				}
			}
		      return res;  
		}
		public List<List<Integer>> fourSum(int[] num, int target) {
			List<List<Integer>> res=new ArrayList<List<Integer>>();
			 if(num==null||num.length==0)
				 return res;
			 Arrays.sort(num);
			 for(int i=0;i<num.length;i++){
				 if(i>0&&num[i]==num[i-1])
					 continue;
				 int tem=num[i];
				 List<List<Integer>> half=threeSum(num,target-tem,i+1);
				 for(int j=0;j<half.size();j++){
					 half.get(j).add(0,tem);
				 }
				 res.addAll(half);
			 }
			 return res;
	    }
	}


