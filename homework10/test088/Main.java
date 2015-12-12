package test088;

public class Main {

	public static void main(String[] args) {
		int [] nums1 = {0,1};
		int [] nums2 = {2,3};
		int m = 2;
		int n = 2;
		merge(nums1,m,nums2,n);
		for(int x : nums1) System.out.print(x+" ");
	}
	//solution 1
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int curr1 = m -1, curr2 = n -1, start = m + n-1;
		
		while (curr1 >= 0 && curr2 >=0) {
			if(nums1[curr1] > nums2[curr2]) 
				nums1[start--] = nums1[curr1--];
			else 
				nums1[start--] = nums2[curr2--];
		}
		
		if(curr1 <= 0) {
			while(curr2>= 0) 
				nums1[start--] = nums2[curr2--];
		}
	}
	// solution 2
	 public static void merge1(int[] nums1, int m, int[] nums2, int n) {
	        while(n>0) nums1[m+n-1] = (m==0||nums2[n-1] > nums1[m-1]) ? nums2[--n] : nums1[--m];
	    }
}
