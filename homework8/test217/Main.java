package test217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {0,1,2,3,4,5,6,7,8,9,10,11,1,2,3,8};
		boolean res = containsDuplicate2(input);
		System.out.println();
		System.out.println(res);
	}

	// solution1 sort <wrong:Time Limit Exceeded>
	private static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; ++i)
			if (nums[i] == nums[i + 1])
				return true;
		return false;
	}

	// solution2 set
	private static boolean containsDuplicate1(int[] nums) {
		Set set = new HashSet<>();
		for (int n : nums) {
			// if(set.contains(n))
			if (!set.add(n))
				return true;
			else
				set.add(n);
		}
		return false;
	}

	// solution3 niubility solution!!!!!! 3ms
	private static boolean containsDuplicate2(int[] nums) {
		byte[] mark = new byte[150000];
		for (int i : nums) {

			int j = i / 8;
			int k = i % 8;
			int check = 1 << k;
			if ((mark[j] & check) != 0)  return true;
			mark[j] |= check;

		}
		return false;
	}

}
