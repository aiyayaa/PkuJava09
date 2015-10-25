/**
 * TwoSum
 */
//package pku.ss.java.zhangxitao.second;

import java.util.HashMap;
import java.util.Map;


/**
 * @author zhangxit
 *
 */
public class Solution {

	public static void main(String[] args) {
		int [] nums = {11,7,2,13};
		int target = 9;
		int [] result = twoSum(nums,target);
		System.out.println(result[0]+" "+result[1]);
	}
	public static int[] twoSum(int[] numbers, int target) {
	    int[] result = new int[2];
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < numbers.length; i++) {
	        if (map.containsKey(target - numbers[i])) {
	            result[1] = i + 1;
	            result[0] = map.get(target - numbers[i]);
	            return result;
	        }
	        map.put(numbers[i], i + 1);
	    }
	    return result;
	}
}
