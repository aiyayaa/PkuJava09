package test70;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 11;
		int res = climbStairs4(input);
		System.out.println(res);
	}
	//solution 1 斐波那契数列生成
	public static int climbStairs(int n){
		if(n>0){
			if(n == 1) return 1;
			if(n == 2) return 2;
			int F1 = 1;
			int F2 = 2;
			int res = 0;
			for(int i=2;i<n;++i){
				res = F1 + F2;
				F1 = F2;
				F2 = res;
			}
			return res;
		}
		return 0;
	}
	// solution 2	数组生成斐波那契数列
	public static int climbStairs1(int n){
		if(n == 0 || n == 1 || n == 2) return n;
		 int[] mem = new int[n];
		    mem[0] = 1;
		    mem[1] = 2;
		    for(int i = 2; i < n; i++){
		        mem[i] = mem[i-1] + mem[i-2];
		    }
		    return mem[n-1];
	}
	// solution 3 斐波那契数列生成
	public static int climbStairs2(int n) {
	    int a = 1, b = 1;
	    while (n-- > 0)
	        a = (b += a) - a;	// b=b+a; a=b;
	    return a;
	}
	// solution 4		递归
	public static int climbStairs3(int n){
		if(n == 0 || n == 1 || n == 2) return n;
		return climbStairs3(n-1)+climbStairs3(n-2);
	}
	// solution 5		矩阵
	public static int climbStairs4(int n) {
	    int[][] a = {{0, 1}, {1, 1}};
	    int[][] m = pow(a, n - 1);
	    return m[0][1] + m[1][1];
	}
	private static int[][] pow(int[][] a, int n) {
	    int[][] ret = {{1, 0}, {0, 1}};
	    while (n > 0) {
	        if ((n & 1) == 1) {
	            ret = multiply(ret, a);
	        }
	        n >>= 1;
	        a = multiply(a, a);
	    }
	    return ret;
	}

	private static int[][] multiply(int[][] a, int[][] b) {
	    int[][] c = new int[2][2];
	    for (int i = 0; i < 2; i++) {
	        for (int j = 0; j < 2; j++) {
	            c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
	        }
	    }
	    return c;
	}
	
}
