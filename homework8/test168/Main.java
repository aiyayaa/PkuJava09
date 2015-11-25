package test168;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 26;
		String res = converToTitle(input);
		System.out.println(res);
	}
	private static String converToTitle(int n){
		StringBuffer res = new StringBuffer();
		while(n>0){
			n--;
			res.insert(0, (char)('A' + n % 26));
//			res.insert(0, (char)('A' + n % 26-1));    wrong : 输入是26时，输出是A@			
			n/=26;
		}
		return res.toString();
	}
	// solution 递归
	private static String converToTitle1 (int n){
		return n == 0 ? "" : converToTitle1(--n / 26) + (char)('A' + (n % 26));
	}
}
