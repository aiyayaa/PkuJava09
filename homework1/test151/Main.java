package test151;

public class Main {

	public static void main(String[] args) {
		String s = "the sky is blue ";
		String result = reverseWords(s);
		System.out.println(result);
		System.out.println(result.length());
	}
	public static String reverseWords(String s){
		String temp = "";
		String result = "";
		for(int i=0;i<s.length();++i){
			if(s.charAt(i)==' '){
				if(temp!="") 			//防止出现前缀空格
					if(result=="") result = temp;           //防止出现后缀空格
					else result = temp+" "+result;
				temp = "";
			}
			else temp = temp+s.charAt(i);
		}
		
		if(temp!=""&&result=="") result = temp;      //第一次run后修改过的地方
		else if(temp!=""&&result!="") result = temp+" "+result;
		if(result!=""){
			if(result.charAt(0)==' ') result = "";         //第一次submit后修改的地方，检查前缀空格
			}
		return result;
	}
}
