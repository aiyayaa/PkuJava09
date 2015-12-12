package test172;

public class Main {

	public static void main(String[] args) {
		int num = 16;
		int res = trailingZeros(num);
		System.out.println(res);
	}
	
	//solution 1 .  输入70的时候，超时
	private static int trailingZeros(int n){
		long sum = 1;
		int res = 0;
		for(int i = 1;i<=n;++i){
			sum = sum * i ;
		}
		while(sum%10==0){
			res++;
			sum /= 10 ;
		}
		return res;
	}
	
	// solution 2 改进版，还是超时，但是在输入80的时候超时
	private static int trailingZeros1(int n){
		long sum = 1;
		int res = 0;
		for(int i = 1;i<=n;++i){
			sum = sum * i ;
			while(sum%10==0){
				res++;
				sum /= 10 ;
			}
		}		
		return res;
	}
	
	// solution 3 改进版，还是超时，但是在输入102的时候超时
	
	private static int trailingZeros2(int n){
		long sum = 1;
		int res = 0;
		for(int i = 1;i<=n;++i){
			int temp = i;
			while(i%10==0){
				res++;
				i /= 10 ;
			}
			sum = sum * i ;
			while(sum%10==0){
				res++;
				sum /= 10 ;
			}
			i =temp;
		}		
		return res;
	}
	
	//solution 4 logn 的解法
	private static int trailingZeros3(int n){
		return n==0?0:n/5 + trailingZeros(n/5);	
	}
	//solution 5 同解法4，但是更容易理解
	 public int trailingZeroes4(int n) {
	        int r = 0;
	        while (n > 0) {
	            n /= 5;
	            r += n;
	        }
	        return r;
	    }
	
}
