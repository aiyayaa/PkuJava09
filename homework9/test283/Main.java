package test283;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 0 };
		moveZeros(nums);
		for (int i : nums)
			System.out.print(" " + i);
	}
	// solution 1 luanxu
	private static void moveZeros(int[] nums) {
		int end = nums.length - 1;
		for (int pre = 0; pre < end; pre++) {
			if (nums[pre] == 0) {
				while (nums[end] == 0) {
					end--;
					if (end <= pre)
						break;
				}
				nums[pre] = nums[end];
				nums[end] = 0;
			}
		}
	}
	// solution 2 foreach 
	public static void  moveZeros1(int[] nums){       		
	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        
	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	// solution 3
	public void moveZeroes2(int[] nums) {
        int z = -1;
        for (int i=0; i< nums.length; i++) {
            int temp = nums[i];
            if (temp != 0) {
                nums[i]=0;
                nums[++z]=temp;
            }
        }
    }
	
	
}