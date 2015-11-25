package test171;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "A";
		int res = titleToNumber(input);
		System.out.println(res);
	}

	// regular solution
	private static int titleToNumber(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); ++i) {
			int num = s.charAt(i) - 'A' + 1;
			sum = 26 * sum + num;
		}
		return sum;
	}
	// solution ตÝน้
	private static int titleToNumber1(String s) {
		return s.length()==0?0:(s.charAt(s.length()-1)-'A'+1)+26*titleToNumber(s.substring(0, s.length()-1));
	}
	
}
