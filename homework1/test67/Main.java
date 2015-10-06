package test67;

public class Main {

	public static void main(String[] args) {
//		String num1 = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
//		String num2 = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
    	String num2 = "101111";
		String num1 = "10";
		
		String result = addBinary(num1,num2);
		System.out.println(result);
	}
//	public static String addBinary(String a , String b){
//		 a = Long.valueOf(a,2).toString();
//		 b = Long.valueOf(b,2).toString();
//		 long numsofa = Long.valueOf(a).longValue();
//		 long numsofb = Long.valueOf(b).longValue();
//		 long sum = numsofa +numsofb;
//		 String result = Long.toBinaryString(sum);
//		 return result;
//	}
	
		
//	public static String addBinary(String a , String b){
////		 a = Long.valueOf(a,2).toString();
////		 b = Long.valueOf(b,2).toString();
//		 int numsofa = Integer.valueOf(a).intValue();
//		 int numsofb = Integer.valueOf(b).intValue();
//		int sum = numsofa +numsofb;
//		 String result = Integer.toBinaryString(sum);
//		 return result;
//	}

	public static String addBinary(String a , String b){
		int lenOfa = a.length();
		int lenOfb = b.length();
		int carry = 0;         //进位标识符    
		String result = "";
		if(lenOfb>=lenOfa){
			for(int i =lenOfb-1,  j=lenOfa-1; i>=lenOfb-lenOfa;--i,--j){
				
//				System.out.println("1 i is "+i);
//				System.out.println("1 j is "+j);
//				System.out.println("str1 is "+b.charAt(i));
//				System.out.println("str2 is "+a.charAt(j));
				if(a.charAt(j)==b.charAt(i)&&b.charAt(i)=='1'&&carry==1){
//					b.charAt(i)='1';
					result = "1"+result;
//					carry = 1;
					
				}
				else if(a.charAt(j)==b.charAt(i)&&b.charAt(i)=='0'&&carry==0){
					result = "0"+result;
//					carry = 0;

				}
				else if((a.charAt(j)!=b.charAt(i)&&carry==1)||(a.charAt(j)==b.charAt(i)&&b.charAt(i)=='1'&&carry==0)){
					result = "0"+result;
					carry = 1;
					
				}
				else{
					result ="1"+result;
					carry = 0;
//					System.out.println("here!");
				}
//				System.out.println("1 carry is "+carry);
//				System.out.println("1 result is "+result);
				if(0==i){
					if(0==carry) return result;
					else return "1"+result;
				}
			}
			for(int i=lenOfb-lenOfa-1;i>=0;--i){
//				System.out.println("2 result is "+result);
//				System.out.println("2 i is "+i);
//				System.out.println("2 carry is "+carry);
				if(1==carry&&b.charAt(i)=='1'){
					result = "0"+result;
					if(0==i){
						result = "1"+result;
						return result;
						}
					}
			    else if(1==carry){
					result = "1"+result;
					carry = 0;              //新增
					}
				else{
//					System.out.println(i);
//					System.out.println(b.substring(0,i+1));
					result = b.substring(0,i+1)+result;
					return result;
					}
				}//for			
			}	//if
		else{
			String temp = a;
			a=b;
			b=temp;
			return addBinary(a,b);
		}
		return result	;
	}
}
	
	
	
	
	
	
	

