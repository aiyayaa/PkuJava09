public class Solution {
   public int reverse(int x) {
        int sum = 0;
        //int max = 0x7fffffff;
        //int min = 0x80000000;
        while(x !=0) {
            int temp = x %10;
            sum = sum * 10 + temp;
            if((sum > Integer.MAX_VALUE/10 || sum < Integer.MIN_VALUE/10) && x/10 !=0)
                return 0;
    //        sum = sum * 10 + temp;
            x = x/10;
        }
        return sum;
    }
}