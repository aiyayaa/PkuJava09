package test;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordCount {
	 public static void main(String[] args) throws IOException {
		 File fileA = new File("F:\\A.txt");
		 File fileB = new File("F:\\B.txt");
		 FileInputStream finA = new FileInputStream(fileA);
		 FileInputStream finB = new FileInputStream(fileB);
		 BufferedReader bufferedReaderA = new BufferedReader(new InputStreamReader(finA));
		 BufferedReader bufferedReaderB = new BufferedReader(new InputStreamReader(finB));
		 String strA = "";
		 String resultA = "";
		 String strB = "";
		 String resultB = "";
		 while((strA = bufferedReaderA.readLine()) != null) {
			 resultA += strA;
		 }
		 while((strB = bufferedReaderA.readLine()) != null) {
			 resultB += strB;
		 }
		 String[] arrA = resultA.split(" ");
		 String[] arrB = resultB.split(" ");
		 int initialA = arrA.length;
		 int initialB = arrB.length;
		 
		 Set<String> setA = new HashSet<String>();
		 Set<String> setB = new HashSet<String>();
		 for(int i = 0; i < initialA; i++) {
			 setA.add(arrA[i]);
		 }
		 for(int i = 0; i < initialB; i++) {
			 setB.add(arrB[i]);
		 }
		 int countA = setA.size();
		 int countB = setB.size();
		 int repeat = 0;     //重复的单词数字
		 int remain = countA;  //A中剩余的个数
		 
		 for(Iterator iB = setB.iterator();iB.hasNext(); ) {
			 String s = (String) iB.next();
			 if(setA.contains(s)) {
				 repeat++;
				 setB.remove(s);   //B为交集
			 } else {
				 setA.add(s);      //A为并集
				 remain++;
			 }
		 }
		 
		 System.out.println("两文件的并集：" + setA);
		 System.out.println("两文件的交集: " + setB);
		 System.out.println("A 单词总数：" + countA);
		 System.out.println("B 单词总数：" + countB);
		 System.out.println("重复单词占A的百分比：" + (repeat/countA));
		 System.out.println("重复单词占B的百分比：" + (repeat/countB));
		 
		 
	 }
}
