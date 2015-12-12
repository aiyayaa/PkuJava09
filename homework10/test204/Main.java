package test204;

public class Main {

	public static void main(String[] args) {
		int input = 16;
		int res = countPrimes3(input);
		System.out.println(res);
	}

	// solution 1 ����1000ʱ��ʱ
	private static int countPrimes(int n) {
		int res = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i))
				res++;
		}
		return res;
	}
//�ڿ��˱��˴�֮���ҷ����˳�ʱ��ԭ����Ϊÿ�ε������������ʱ��Ҫ����һ��n2����
// ������˷ǳ���Σ���˷������������������������ solution 2	
	private static boolean isPrime(int n) {
		for(int i = 2;i<n;i++){
//			for(int j=2;j<n;j++){        �Ľ�forѭ�������ǳ�ʱ��������������499979ʱ��ʱ
			for(int j=2;i*j<n;j++){
				if(n==i*j) return false;
			}
		}
		return true;
	}


	// solution 2 �����鷽�������������
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
	
	//soluiton 3 ����ⷨ�������Ĵ����������
	 public int countPrimes2(int n) {
	        boolean[] m = new boolean[n];
	        int count = 0;
	        for (int i=2; i<n; i++) {
	            if (m[i])
	                continue;

	            count++;
	            for (int j=i; j<n; j=j+i)	//������ÿ�� j=j+i 
	                m[j] = true;
	        }

	        return count;
		}
	 // solution 4 ��һ���������ķ�����������û������
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
