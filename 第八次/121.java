public class Solution {
    public int maxProfit(int[] prices) {  //searching the max of prices[j] - prices[i]   i < j
        int len = prices.length;
        if(len == 0)
            return 0;
        int low = prices[0];
        int ans = 0;
        
        for (int i = 1; i <len; i++) {
            if(prices[i] < low) {
                low = prices[i];
            }else{
                if((prices[i] - low) > ans) {
                    ans = prices[i] - low;
                }
            }
        }
        return ans;
    }
}