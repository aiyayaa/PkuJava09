/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */
package test125;

public class Main {

	public static void main(String[] args) {
//		String test = "1a2";
		String test ="1a2";
		boolean temp = isPalindrome(test);
		System.out.println();
		System.out.println(temp);
	}
	//����˼·����ջ
	
/*	//solution1,using little library
 * 
	private static boolean isPalindrome(String s){
		int len = s.length();
		//�Ѵ�д��ĸת����Сд��ĸ
		String sLow = s.toLowerCase();
//		System.out.println(sLow);
		StringBuffer temp = new StringBuffer();
		boolean result = true;
		//����String�ҳ���ĸ�����temp
		for(int i= 0;i<len;++i){
			//Сд��ĸ������
			if((sLow.charAt(i)<='z'&&sLow.charAt(i)>='a')||(sLow.charAt(i)<='9'&&sLow.charAt(i)>='0')){
				temp.append(sLow.charAt(i));
				}
		}
			//����
//			for(int i=0;i<temp.length();++i) System.out.print(temp.charAt(i)+" ");
//			System.out.println(" ");
			//���û����ĸ������ģ���""
			if(temp.length()==0) return true;
			int j =0;
//			System.out.println(j);
			//��֤�Ƿ��ǻ���
			for(int i=temp.length()-1;j<i;--i){
//				System.out.println(temp.charAt(i)+" "+temp.charAt(j));
				if(temp.charAt(i)!=temp.charAt(j++)) result = false; 	
				}
			return result;
	}*/
/*
 * 			solution2  more readable
*/	
/*	private static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		//ʹ��������ʽ����ȥ���з���ĸ�������ַ�
		s = s.replaceAll("[^0-9a-zA-Z]", "");
		//��toCharArray������String�������
		char c[] = s.toCharArray();
		int counthead = 0, counttail = s.length() - 1;
		while (counthead <= s.length() - 1 && counttail >= 0) {
			if (c[counthead] != c[counttail])
				return false;
			counthead++;
			counttail--;
		}
		return true;
	}*/
	
/*	
 * 		solution 3.  using StringBuffer.reverse()
*/	
	
/*	public class Solution {
	    public boolean isPalindrome(String s) {
	        s = s.toLowerCase()
	        s = s.replaceAll("[^A-Z^a-z^0-9]+", "");
	        	//��Stringת����StringBuffer
	        StringBuffer sb = new StringBuffer(s);
	        	//��StringBuffer.reverse()ת��
	        sb.reverse();
	        	//��StringBufferת����String
	        String reverseString = sb.toString();
	        boolean result = s.equals(reverseString);
	        return result;
	    }
	}*/
/*
 * 			solution4  niubility&readable  2 line in java!!	
*/	
	private static boolean isPalindrome(String s) {
			//��regex������ʶ���ַ�
		s = s.toLowerCase().replaceAll("\\W", "");
			//����֮����
		return new StringBuilder(s).reverse().toString().equals(s);
	}
	
}


