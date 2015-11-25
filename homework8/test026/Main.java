package test026;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {};
		int res = removeDuplicates1(input);
		System.out.println();
		System.out.println(res);
	}
	// solution 1
	private static int removeDuplicates(int [] nums){
		if(nums.length==0) return 0;
		int temp = nums[0];
		int len = 1;
		for(int i = 1;i<nums.length;++i){
			if(temp != nums[i]){
				temp = nums[i];
				nums[len++]=temp;
			} 
		}
//		for(int i : nums) System.out.print(i+" ");
		return len;
	}
	// solution 2
	private static int removeDuplicates1(int [] nums){
		    int i = 0;
		    for (int n : nums)
		        if (i == 0 || n > nums[i-1])
		            nums[i++] = n;
		    return i;
	}
}


