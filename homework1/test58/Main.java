package test58;

public class Main {

	public static void main(String[] args) {
		String txt ="        ";
		int result = lengthOfLastWord(txt);
		System.out.println(result);
	}
	public static int lengthOfLastWord(String s){
		int num = 0;				
		int flag = 0;
		for(int i =0 ;i <s.length();++i){
			if(' '==s.charAt(i)){
				if(i==s.length()-1) return num;
				else if (' '==s.charAt(i+1)){}
			    else  num=0;
			}
			if(s.charAt(i)!=' ') ++num;						
		}
		return num;
	}
}
