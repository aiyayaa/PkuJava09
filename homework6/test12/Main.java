package test12;

import java.util.LinkedHashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input  = 1124;
		String res = intToRoman6(input);
		System.out.println(res);
	}
	
	//  solution 1
	private static String intToRoman(int num){
		String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
	
	//  solution 2
	private static String intToRoman1(int num){
			int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

		    StringBuilder sb = new StringBuilder();

		    for(int i=0;i<values.length;i++) {
		        while(num >= values[i]) {
		            num -= values[i];
		            sb.append(strs[i]);
		        }
		    }
		    return sb.toString();		
	}
	
	// solution 4
	private static LinkedHashMap<Integer, String> numToRoman3 = new LinkedHashMap<Integer, String>();
    static {
        numToRoman3.put(1000, "M");
        numToRoman3.put(900, "CM");
        numToRoman3.put(500, "D");
        numToRoman3.put(400, "CD");
        numToRoman3.put(100, "C");
        numToRoman3.put(90, "XC");
        numToRoman3.put(50, "L");
        numToRoman3.put(40, "XL");
        numToRoman3.put(10, "X");
        numToRoman3.put(9, "IX");
        numToRoman3.put(5, "V");
        numToRoman3.put(4, "IV");
        numToRoman3.put(1, "I");
    }
    public String intToRoman3(int num) {
        for (Integer i : numToRoman3.keySet()) {
            if (num >= i) {
                return numToRoman3.get(i) + intToRoman(num - i);
            	}
        	}
        	return "";
    }
    
    // solution 5
    public String intToRoman4(int num) {
        if(num>=1000) return "M"+intToRoman(num-1000);
        if(num>=900) return "CM"+intToRoman(num-900);
        if(num>=500) return "D"+intToRoman(num-500);
        if(num>=400) return "CD"+intToRoman(num-400);
        if(num>=100) return "C"+intToRoman(num-100);
        if(num>=90) return "XC"+intToRoman(num-90);
        if(num>=50) return "L"+intToRoman(num-50);
        if(num>=40) return "XL"+intToRoman(num-40);
        if(num>=10) return "X"+intToRoman(num-10);
        if(num>=9) return "IX"+intToRoman(num-9);
        if(num>=5) return "V"+intToRoman(num-5);
        if(num>=4) return "IV"+intToRoman(num-4);
        if(num>=1) return "I"+intToRoman(num-1);
        return "";
    }
    
    // solution 6
    public static String intToRoman5(int num) {
    	String[][] table = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
    					{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
    					{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
    					{"", "M", "MM", "MMM"}
               };
    	String result="";
    	int count = 0;
    	while(num > 0){
    			int temp = num % 10;
    			result = table[count][temp] + result;
    			num /= 10;
    			count++;
    	}
    	return result;
    }
    
    // solution 7 Ã¶¾ÙÀà
    public enum Type{
        M(1000),CM(900),D(500),CD(400),C(100),XC(90),L(50),XL(40),X(10),IX(9),V(5),IV(4),I(1);
        private final int value;
        Type(int value) {
            this.value = value;
        }
    };
    public static String intToRoman6(int num) {
        StringBuilder output = new StringBuilder();
        for (Type t:Type.values()) {
            while (num>=t.value) {
                output.append(t);
                num -= t.value;
            }
        }
        return output.toString();
    }
}
