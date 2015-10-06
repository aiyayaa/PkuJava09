package test8;

import java.awt.print.Printable;

public class Main {

	public static void main(String[] args) {
		
/*   for test case:  
 * 		""
 * 		" "										
 * 		"1354"
 *		"0"
 *		"test"
 *		"tes32t"
 *		"122test"
 *		"*&6^234)8"
 *		"alkasj*&^*57);l"
 *		"234/n2356"
 *		"1541684354864516543165764"
 */
		String txt =" 2147483648";             
		System.out.println(myAtoi(txt));
	
	}

	public static int myAtoi(String str){
		int len = str.length();
		int state = 0;
		long result = 0;
		boolean isNegative = false ; 
		for(int i = 0 ; i <len;i ++){
			if(' '==str.charAt(i)&&state==0){}
			else if('-'==str.charAt(i)&&state==0){
				state=2;
				isNegative = true;
			}
			else if('+'==str.charAt(i)&&state==0){
				state=2;
				isNegative = false;
			}		
			else if ('0'<=str.charAt(i)&&'9'>=str.charAt(i)&&(state==0||state==2)){
				state=1;
				result=str.charAt(i)-'0';
				if(i==len-1){					
					if(isNegative) {
						return -(int)result;
					}
					else return (int) result;
				}

			}
			else if('0'<=str.charAt(i)&&'9'>=str.charAt(i)&& state==1){
				result = result*10 + str.charAt(i)-'0';
				if(result>=2147483648L&&isNegative) return -2147483648;
				else if(result>=2147483647&&!isNegative) return 2147483647;
				if(i==len-1){					
					if(isNegative) {
						return -(int)result;
					}
					else return (int) result;
				}
								
			}
			else if(' '==str.charAt(i)&&state==1){
				state=3;				
			}
			else if(' '==str.charAt(i)&&state==3){
				if(i==len-1){
					if(isNegative) {
						return -(int)result;
					}
					else return (int) result;
				}
			}
			else if(i==len-1&&state==0) return 0;
			else {
				
					if(isNegative) {
						return -(int)result;
					}
					else return (int) result;
				}
		}
		return (int)result;						
	}
	
	
	
	
}
