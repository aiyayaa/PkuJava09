package test121;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {6,2,3,4,5,7,10,11};
		int res = maxProfit(input);
		System.out.println(res);
	}
	// prefect solution (±³)
	public static int maxProfit(int[] prices) {
	    int max = 0, sum = 0;
	    for(int i = 1; i < prices.length; i++){
	        sum += prices[i]-prices[i-1];
	        if(sum < 0) sum = 0;
	        if(sum > max)   max = sum;
	    }
	    return max;
	}
	// regular solution 
	public static int maxProfit1(int[] prices) {
		int le = prices.length, maxD = 0, min = Integer.MAX_VALUE;

		for (int i = 0; i < le; i++) {
			min = Math.min(min, prices[i]);
			maxD = Math.max(maxD, prices[i] - min);
		}

		return maxD;
	}
}
