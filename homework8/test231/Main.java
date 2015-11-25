package test231;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 17;
		boolean res = isPowerOfTwo1(input);
		System.out.println(res);
	}
	// solution 1   bitcount ��ȡ�����Ʋ�����1��������
	private static boolean isPowerOfTwo(int n){
		return n>0 && Integer.bitCount(n) == 1;
	}
	// solution 2  �����2��ָ�� n&(n-1)Ϊȫ1�����������ڲ�����Ϊ��
	private static boolean isPowerOfTwo1(int n) {
		return ((n & (n - 1)) == 0 && n > 0);
	}
	// solution 3 �ݹ�
	private static boolean isPowerOfTwo2(int n) {
		if(n == 0)              return false;
        if(n == 2 || n == 1)    return true;
        if(n%2 != 0)            return false;
        else                    return isPowerOfTwo2(n>>1);
	}
	// solution 4 regular solution
	private static boolean isPowerOfTwo3(int n) {
		if(n <= 0)
            return false;
        if(n == 1)
            return true;
        while( n > 1 && n % 2 == 0)
            n /= 2;
        if(n == 1)
            return true;
        else
            return false;
	}
	// solution5 ��bitcount��ʵ��
	public boolean isPowerOfTwo4(int n) {
	    // power of 2 means only one bit has 1 and others are 0 
	    return (countBitHasOne(n) == 1)? true : false; 
	}

	private int countBitHasOne(int n) {
	    int count = 0; 
	    while(n > 0) { 
	        if((n & 1) == 1) {
	            count++; 
	        }

	        // shift one bit
	        n = n>>1;
	    }
	    return count; 
	}
}