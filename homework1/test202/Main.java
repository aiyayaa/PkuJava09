package test202;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		int num = 10;
		boolean result = isHappy(num);
		System.out.println(result);
	}
	//该题解法源自网络
	public static boolean isHappy(int n) {
        Set<Integer> numberSet = new HashSet<Integer>();       
        while (n!=1){
            if (numberSet.add(n)==false){
                return false;
            }
            char[] chars = String.valueOf(n).toCharArray();
            System.out.println(chars);
            int total = 0;
            for (Character ch: chars){
                total += Math.pow(Integer.parseInt(ch+""),2);
            }
            n = total;
        }
        return true;
    }				
}
