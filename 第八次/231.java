public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) 
            return false;
        
        int i = Integer.bitCount(n);
        if(i == 1)
            return true;
        else
            return false;
//        if (n = 0)
//            return true;
//        Integer N = (Integer) n;
/*        String s = Integer.toBinaryString(n);
        int len = s.length();
        
        int temp = 1;
        for(int i = 1; i < len; i++) {
            temp = temp << 1;
        }
        
        if(n == temp)
            return true;
        else
            return false;
*/      
    }
}