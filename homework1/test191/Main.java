package test191;

public class Main {

	public static void main(String[] args) {
		int num = 45;
		int result = hammingWeight(num);
		System.out.println(result);
	}
	public static int hammingWeight(int n){
		String binary = Integer.toBinaryString(n);
		int result = 0;
		for(int i = 0; i < binary.length(); ++i){
			if(binary.charAt(i)=='1') ++result;
		}
		return result;
	}
	
	
	
}
