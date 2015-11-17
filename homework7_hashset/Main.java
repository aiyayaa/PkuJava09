package homework_set;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		//�����ļ�·��
		String filename1 = "h:/A.txt";
		String filename2 = "h:/B.txt";
		//����readtext������ȡ�ļ�����
		String bfile=readtext(filename2);
		String afile=readtext(filename1);
		//����getwords��������Ϊ�������ʣ�����hashset��
		Set<String> a = getwords(afile);
		Set<String> b = getwords(bfile);
		//����merge��inter�����㲢���ͽ�����ͨ��rate���������
		Set<String> merge = merge(a,b);
		Set<String> inter = inter(a,b);
		int rateOfa = rate(a.size(),inter.size());
		int rateOfb = rate(b.size(),inter.size());
		
		
		System.out.println("�������ļ�A����Ϊ�� "+afile);
		System.out.println("�������ļ�B����Ϊ�� "+bfile);
		
		output(a,"�ļ�A");
		output(b,"�ļ�B");
		output(merge,"�ļ�A���ļ�B�ĺϼ�");
		output(inter,"�ļ�A���ļ�B�Ľ���");
		
		System.out.println("�ļ�A���Լ����еĵ�����ռ�ı���Ϊ"+rateOfa+"%");
		System.out.println("�ļ�B���Լ����еĵ�����ռ�ı���Ϊ"+rateOfb+"%");
	
	}
	/**
	 *  ��ȡ�ļ�����
	 * @param filename �ļ�·��
	 * @return һ��String�ַ����������ļ�����
	 */
	public static String readtext(String filename){
		String str = "";
		try {
	            Scanner in = new Scanner(new File(filename));  
	            while (in.hasNextLine()) {
	                String strline = in.nextLine();
	                str+=strline;
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
		return str;
	}
	/**
	 *  ��String���ݷֳɸ�������
	 * @param str ��Ҫ��ֳɵ��ʵ�����
	 * @return һ��hashset����str�еĵ���
	 */
	public static Set<String> getwords(String str){
		Set<String> res = new HashSet<String>(); 
		StringTokenizer st = new StringTokenizer(str, ", !.?");
		while (st.hasMoreTokens())
		{
		res.add(st.nextToken());
		}
		return res;
	}
	/**
	 * �ϲ�����hashset����hashset�������ǲ��ظ��ģ��ʵó���������hashset�Ĳ���
	 * @param a 
	 * @param b 
	 * @return a��b�Ĳ���
	 */
	public static Set<String> merge(Set<String> a,Set<String> b){
		Set<String> bclone=new HashSet<String>(b);
		bclone.addAll(a);
		return bclone;	
	}
	/**
	 *  ������hashset�Ľ���
	 * @param a
	 * @param b
	 * @return a��b�Ľ���
	 */
	public static Set<String> inter(Set<String> a,Set<String> b){
		Set<String> c = new HashSet<String>();
		Iterator<String> iterator=a.iterator();
		while(iterator.hasNext()){
			String temp = iterator.next();
			if(b.contains(temp)){
				c.add(temp);
			}
		}
		return c;
	}
	/**
	 * ͨ������ó�һ��hashset���еĵ�����ռ�ı���
	 * @param a һ��int�ͱ�����ʾhashset�еĵ�������
	 * @param a_b һ��int�ͱ�����ʾhashset���Լ����еĵ�����������a-b
	 * @return һ��int�ͱ�����ʾ��ռ�������ٷ���
	 */
	public static int rate(int a,int a_b){
		if(a==0) return -1;
		int res = (a-a_b)*100/a;
		return res;
	}
	/**
	 * �������hashset�е�����
	 * @param a	Ҫ������hashset
	 * @param str hashset������
	 */
	public static void output(Set<String> a ,String str){
		System.out.print(str+"�еĵ����У� ");
		Iterator<String> iterator=a.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		System.out.println(str+"�еĵ�������Ϊ��"+a.size());
	}
}
