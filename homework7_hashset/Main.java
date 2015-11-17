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
		//设置文件路径
		String filename1 = "h:/A.txt";
		String filename2 = "h:/B.txt";
		//调用readtext函数读取文件内容
		String bfile=readtext(filename2);
		String afile=readtext(filename1);
		//调用getwords将函数分为各个单词，存入hashset中
		Set<String> a = getwords(afile);
		Set<String> b = getwords(bfile);
		//调用merge和inter来计算并集和交集，通过rate来计算比例
		Set<String> merge = merge(a,b);
		Set<String> inter = inter(a,b);
		int rateOfa = rate(a.size(),inter.size());
		int rateOfb = rate(b.size(),inter.size());
		
		
		System.out.println("读到的文件A内容为： "+afile);
		System.out.println("读到的文件B内容为： "+bfile);
		
		output(a,"文件A");
		output(b,"文件B");
		output(merge,"文件A与文件B的合集");
		output(inter,"文件A与文件B的交集");
		
		System.out.println("文件A中自己独有的单词所占的比率为"+rateOfa+"%");
		System.out.println("文件B中自己独有的单词所占的比率为"+rateOfb+"%");
	
	}
	/**
	 *  读取文件内容
	 * @param filename 文件路径
	 * @return 一个String字符串，保存文件内容
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
	 *  将String内容分成各个单词
	 * @param str 需要拆分成单词的内容
	 * @return 一个hashset保存str中的单词
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
	 * 合并两个hashset，因hashset中内容是不重复的，故得出的是两个hashset的并集
	 * @param a 
	 * @param b 
	 * @return a和b的并集
	 */
	public static Set<String> merge(Set<String> a,Set<String> b){
		Set<String> bclone=new HashSet<String>(b);
		bclone.addAll(a);
		return bclone;	
	}
	/**
	 *  求两个hashset的交集
	 * @param a
	 * @param b
	 * @return a和b的交集
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
	 * 通过计算得出一个hashset独有的单词所占的比例
	 * @param a 一个int型变量表示hashset中的单词总数
	 * @param a_b 一个int型变量表示hashset中自己独有的单词数量，即a-b
	 * @return 一个int型变量表示所占比例，百分制
	 */
	public static int rate(int a,int a_b){
		if(a==0) return -1;
		int res = (a-a_b)*100/a;
		return res;
	}
	/**
	 * 遍历输出hashset中的内容
	 * @param a	要遍历的hashset
	 * @param str hashset的名字
	 */
	public static void output(Set<String> a ,String str){
		System.out.print(str+"中的单词有： ");
		Iterator<String> iterator=a.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		System.out.println(str+"中的单词总数为："+a.size());
	}
}
