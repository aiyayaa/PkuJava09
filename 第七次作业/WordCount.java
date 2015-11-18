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
		 int repeat = 0;     //�ظ��ĵ�������
		 int remain = countA;  //A��ʣ��ĸ���
		 
		 for(Iterator iB = setB.iterator();iB.hasNext(); ) {
			 String s = (String) iB.next();
			 if(setA.contains(s)) {
				 repeat++;
				 setB.remove(s);   //BΪ����
			 } else {
				 setA.add(s);      //AΪ����
				 remain++;
			 }
		 }
		 
		 System.out.println("���ļ��Ĳ�����" + setA);
		 System.out.println("���ļ��Ľ���: " + setB);
		 System.out.println("A ����������" + countA);
		 System.out.println("B ����������" + countB);
		 System.out.println("�ظ�����ռA�İٷֱȣ�" + (repeat/countA));
		 System.out.println("�ظ�����ռB�İٷֱȣ�" + (repeat/countB));
		 
		 
	 }
}
