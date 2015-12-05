package test292;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 8;
		boolean res = canWinNim2(input);
		System.out.println(res);
	}
	public static boolean canWinNim(int n){
		 if( (n%4)>0 ) return true;
		 return false;		
	}
	public boolean canWinNim1(int n) {    
	    return n % 4 != 0 ;
	}
	
	// 虽然是个很笨的方法，但是很有思想！
	public  static boolean canWinNim2(int n) {
	    if(n <= 0)
	        throw new IllegalArgumentException();
	    if(n < 4)
	        return true;
	    boolean[] res = new boolean[n + 1];
	    res[0] = true;
	    res[1] = true;
	    res[2] = true;
	    res[3] = true;
	    for(int i = 4 ; i <= n ; i++)
	        res[i] = !(res[i - 1] && res[i - 2] && res[i - 3]);
	    return res[n];
	}
}
