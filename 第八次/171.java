public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int ans = 0;
        if(len == 0) {
            return 0;
        }
        
        for(int i = 0; i < len; i++) {
            int temp = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + temp;
        }
        
        return ans;
    }
}