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
				if(temp!="") 			//��ֹ����ǰ׺�ո�
					if(result=="") result = temp;           //��ֹ���ֺ�׺�ո�
					else result = temp+" "+result;
				temp = "";
			}
			else temp = temp+s.charAt(i);
		}
		
		if(temp!=""&&result=="") result = temp;      //��һ��run���޸Ĺ��ĵط�
		else if(temp!=""&&result!="") result = temp+" "+result;
		if(result!=""){
			if(result.charAt(0)==' ') result = "";         //��һ��submit���޸ĵĵط������ǰ׺�ո�
			}
		return result;
	}
}
