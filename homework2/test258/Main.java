package test258;

public class Main {

	public static void main(String[] args) {
		int num = 11;
		int result = addDigits(num);
		System.out.println(result);
	}
/*
 * 	solution 1 常规解法	
*/	
		public static int addDigits(int num){
		int sum =0;
		while(num>0){
			sum+=num%10;
			num/=10;
//			System.out.println(sum);
		}
		if(sum%10==sum) return sum;
		else  return addDigits(sum);
	}

/*
 * solution 2 niubility解法1 
*/	
	public static int addDigits1(int nums){
		nums = (nums-1)%9+1;
		return nums;
	}
/*
 * solution 3 niubility解法2  1-line 	
*/	
	public static int addDigits2(int num){
		return (num==0)?0:(num%9==0)?9:num%9;
	}
	
	
	
	
	
	
	
	
}
