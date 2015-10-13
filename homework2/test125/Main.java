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
	//初见思路：用栈
	
/*	//solution1,using little library
 * 
	private static boolean isPalindrome(String s){
		int len = s.length();
		//把大写字母转换成小写字母
		String sLow = s.toLowerCase();
//		System.out.println(sLow);
		StringBuffer temp = new StringBuffer();
		boolean result = true;
		//遍历String找出字母，存进temp
		for(int i= 0;i<len;++i){
			//小写字母和数字
			if((sLow.charAt(i)<='z'&&sLow.charAt(i)>='a')||(sLow.charAt(i)<='9'&&sLow.charAt(i)>='0')){
				temp.append(sLow.charAt(i));
				}
		}
			//数字
//			for(int i=0;i<temp.length();++i) System.out.print(temp.charAt(i)+" ");
//			System.out.println(" ");
			//如果没有字母，算回文，如""
			if(temp.length()==0) return true;
			int j =0;
//			System.out.println(j);
			//验证是否是回文
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
		//使用正则表达式来除去所有非字母和数字字符
		s = s.replaceAll("[^0-9a-zA-Z]", "");
		//用toCharArray方法把String存进数组
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
	        	//把String转化成StringBuffer
	        StringBuffer sb = new StringBuffer(s);
	        	//用StringBuffer.reverse()转化
	        sb.reverse();
	        	//把StringBuffer转化回String
	        String reverseString = sb.toString();
	        boolean result = s.equals(reverseString);
	        return result;
	    }
	}*/
/*
 * 			solution4  niubility&readable  2 line in java!!	
*/	
	private static boolean isPalindrome(String s) {
			//用regex保留可识别字符
		s = s.toLowerCase().replaceAll("\\W", "");
			//代码之美！
		return new StringBuilder(s).reverse().toString().equals(s);
	}
	
}


