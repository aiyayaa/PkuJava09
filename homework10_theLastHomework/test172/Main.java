package test172;

public class Main {

	public static void main(String[] args) {
		int num = 16;
		int res = trailingZeros(num);
		System.out.println(res);
	}
	
	//solution 1 .  ����70��ʱ�򣬳�ʱ
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
	
	// solution 2 �Ľ��棬���ǳ�ʱ������������80��ʱ��ʱ
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
	
	// solution 3 �Ľ��棬���ǳ�ʱ������������102��ʱ��ʱ
	
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
	
	//solution 4 logn �Ľⷨ
	private static int trailingZeros3(int n){
		return n==0?0:n/5 + trailingZeros(n/5);	
	}
	//solution 5 ͬ�ⷨ4�����Ǹ��������
	 public int trailingZeroes4(int n) {
	        int r = 0;
	        while (n > 0) {
	            n /= 5;
	            r += n;
	        }
	        return r;
	    }
	
}
