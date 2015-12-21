public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
/*        int[] nums3 = nums1;
        
        int i = 0, j = 0, k = 0;
        while(i < nums3.length && j < nums2.length) {
            if(nums3[i] < nums2[j]) {
                nums1[k++] = nums3[i++];
            }else{
                nums1[k++] = nums2[j++];
            }
            
            while(i < nums3.length) {
                nums1[k++] = nums3[i++];
            }
            while(j < nums2.length) {
                nums1[k++] = nums2[j++];
            }
        }
        */
        while(m > 0 && n > 0) {
            if(nums1[m-1] > nums2[n-1]) {
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        
        while(n > 0) {
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }
}