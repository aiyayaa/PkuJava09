/**
 * Leetcode第15题，3Sum
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 */
package leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxit
 *
 */
public class Solution {
	public List<List<Integer>>threeSum(int[] num){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null||num.length == 0 ) {
			return res;
		}
		Arrays.sort(num);//将数组从小到大排列
		for (int i = 0; i < num.length; i++) {
			ArrayList<Integer> sub = new ArrayList<Integer>();
			if (i>0 && num[i] == num[i-1]) {//遇到相同元素就继续向前
				continue;
			}
			int n1 = num[i];
			int sum = -n1;
			int p = i+1,q = num.length-1;
			while (p<q) {
				if (num[q]+num[p] == sum) {
					sub.add(n1);
					sub.add(num[p]);
					sub.add(num[q]);
					res.add((ArrayList<Integer>)sub.clone());
					sub = new ArrayList<Integer>();
					while (p+1<q && num[p+1] == num[p]) {
						p++;
					}
					p++;
					while (q-1>p && q-1 == num[q]) {
						q--;
					}
					q--;
				}else if (num[q] + num[p]>sum) {
					q--;
				}else {
					p++;
				}
			}
		}
		return res;
	}
}
