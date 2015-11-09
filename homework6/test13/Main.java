package test13;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "MCXXIV";
		int res = romanToInt1(input);
		System.out.println(res);
	}
	
	// solution 1 
	public static int romanToInt(String s){

        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int result = map.get(s.charAt(len -1));
        int pivot = result;
        for(int i = len -2; i>= 0;i--){
            int curr = map.get(s.charAt(i));
            if(curr >=  pivot){
                result += curr;
            }else{
                result -= curr;
            }
            pivot = curr;
        }
        return result;
	}
	
	// solution 2
	public static int romanToInt1(String s) {
	     int sum=0;
	    if(s.indexOf("IV")!=-1){sum-=2;}
	    if(s.indexOf("IX")!=-1){sum-=2;}
	    if(s.indexOf("XL")!=-1){sum-=20;}
	    if(s.indexOf("XC")!=-1){sum-=20;}
	    if(s.indexOf("CD")!=-1){sum-=200;}
	    if(s.indexOf("CM")!=-1){sum-=200;}

	    char c[]=s.toCharArray();
	    int count=0;

	   for(;count<=s.length()-1;count++){
	       if(c[count]=='M') sum+=1000;
	       if(c[count]=='D') sum+=500;
	       if(c[count]=='C') sum+=100;
	       if(c[count]=='L') sum+=50;
	       if(c[count]=='X') sum+=10;
	       if(c[count]=='V') sum+=5;
	       if(c[count]=='I') sum+=1;
	   }
	   return sum;
	}
	
	// solution 3
	public int romanToInt2(String s) {
	    int[] a = new int[26];
	    a['I' - 'A'] = 1;
	    a['V' - 'A'] = 5;
	    a['X' - 'A'] = 10;
	    a['L' - 'A'] = 50;
	    a['C' - 'A'] = 100;
	    a['D' - 'A'] = 500;
	    a['M' - 'A'] = 1000;
	    char prev = 'A';
	    int sum = 0;
	    for(char str : s.toCharArray()) {
	        if(a[str - 'A'] > a[prev - 'A']) {
	            sum = sum - 2 * a[prev - 'A'];
	        }
	        sum = sum + a[str - 'A'];
	        prev = str;
	    }
	    return sum;
	}
	
	// solution 4
	public int romanToInt3(String s) {
	    int result = 0;
	    int index = 0;
	    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
	    String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };  
	    for (int i = 0; i < values.length; i++) {  
	       if(numerals[i].length() == 1){
	           while(index < s.length() && 
	                   s.substring(index, index+1).equals(numerals[i])){
	               result += values[i];
	               index ++;
	           }
	       }else{
	           if(index < s.length()-1 && 
	                   s.substring(index, index+2).equals(numerals[i])){
	               result += values[i];
	               index += 2;
	           }
	       }
	       if(index >= s.length()) break;
	    }  
	    return result;
	}
	
	
	
}
