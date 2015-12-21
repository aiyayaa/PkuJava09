public class Solution {
    public int trailingZeroes(int n) {
       // int x = 5;
        int ans = 0;
        while(n >= 5) {
            n = n/5;
            ans = ans + n;
            
        }
        return ans;
    }
}