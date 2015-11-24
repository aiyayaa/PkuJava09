public class Solution {
    public boolean containsDuplicate(int[] nums) {
       int len = nums.length;
       if(len == 0) return false;
       
/*       quicksort(nums, 0 , len-1);
       for(int i = 1; i < len; i++) {
           if(nums[i] == nums[i -1]) return true;
           else continue;
       }
       return false;
       
       
    }
    private static void quicksort(int[] A, int low, int high) {
        if(low < high) {
            int i = low, j = high;
            int vot = A[i];
            
            while(i != j) {
                while(i < j && vot <= A[j])
                    j--;
                
                if(i < j) {
                    A[i] = A[j];
                    i++;
                }
                
                while(i < j && A[i] <= vot) {
                    i++;
                }
                
                if(i < j) {
                    A[j] = A[i];
                    j--;
                }
            }
            
            A[i] = vot;
            quicksort(A, low, j - 1);
            quicksort(A, i+1, high);
        }
*/
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
              return true;  
            }
        }
        return false;
    }
}

