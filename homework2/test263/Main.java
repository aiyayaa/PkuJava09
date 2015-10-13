package test263;

public class Main {

	public static void main(String[] args) {
		int num = 256*7;
		boolean result = isUgly1(num);
		System.out.println(result);
	}
/*
 *	����˼·���ݹ�  
*/
/*
 * solution 1 ����ⷨ���ݹ�
*/
	public static boolean isUgly(int num){
//		System.out.println(num);
		if(num<=0) return false;
		if(num==1) return true;
		if(num%2==0) return isUgly(num/2);
		if(num%3==0) return isUgly(num/3);
		if(num%5==0) return isUgly(num/5);
		return false;
	}	
/*
 * solution 2. ����ⷨ������
*/
	public static boolean isUgly1(int num) {
		if (num == 0)
			return false;
		else {
			while (num != 1) {
				if (num % 2 == 0)
					num /= 2;
				else if (num % 3 == 0)
					num /= 3;
				else if (num % 5 == 0)
					num /= 5;
				else
					break;
			}

			if (num == 1)
				return true;
			else
				return false;
		}
	}
/*
 * solution 3. niubility���룺����
*/
	public static boolean isUgly3(int num) {
		for (int i = 2; i < 6 && num > 0; i++)
			while (num % i == 0)
				num /= i;
		return num == 1;
	}


}
