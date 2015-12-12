package test204;

public class Main {

	public static void main(String[] args) {
		int input = 16;
		int res = countPrimes3(input);
		System.out.println(res);
	}

	// solution 1 输入1000时超时
	private static int countPrimes(int n) {
		int res = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i))
				res++;
		}
		return res;
	}
//在看了别人答案之后，我发现了超时的原因，因为每次调用这个函数的时候都要进行一次n2运算
// 多计算了非常多次，因此放弃这个方法，具体解决方法看 solution 2	
	private static boolean isPrime(int n) {
		for(int i = 2;i<n;i++){
//			for(int j=2;j<n;j++){        改进for循环，还是超时，不过是在输入499979时超时
			for(int j=2;i*j<n;j++){
				if(n==i*j) return false;
			}
		}
		return true;
	}


	// solution 2 用数组方法解决函数问题
	public int countPrimes1(int n) {
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (notPrime[i] == false) {
				count++;
				for (int j = 2; i * j < n; j++) {
					notPrime[i * j] = true;
				}
			}
		}
		return count;
	}
	
	//soluiton 3 这个解法对质数的处理很有亮点
	 public int countPrimes2(int n) {
	        boolean[] m = new boolean[n];
	        int count = 0;
	        for (int i=2; i<n; i++) {
	            if (m[i])
	                continue;

	            count++;
	            for (int j=i; j<n; j=j+i)	//这里是每次 j=j+i 
	                m[j] = true;
	        }

	        return count;
		}
	 // solution 4 另一种求质数的方法，但是我没看懂。
	 public static int countPrimes3(int n) {
			int res = 0;
			boolean[] used = new boolean[n];
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (!used[i - 1]) {
					int temp = i * i;
					while (temp < n) {
						used[temp - 1] = true;
						temp += i;
					}
				}
			}
			for (int i = 2; i < n; i++) {
				if (!used[i - 1]) {
					res++;
				}
			}
			return res;
		}
	
	
	
	
	
	
}
