package test119;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		int num = 3;
		List<Integer> result = generat(num);	
//		for(int i=0;i<num;++i){
			System.out.println(result);
//		}
		
	}
	public static List<Integer> generat(int rowIndex){
		//初始化
		++rowIndex;
		if(rowIndex<0) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> line = new ArrayList<>();
		if(0==rowIndex) return result;
		//第一行
		line.add(1);
		result=line;
		//之后各行
		ArrayList<Integer> nextline = line;
		for(int i = 1; i < rowIndex ;++i){
			//通过调用getNextLine方法生成新的下一行
			nextline = getNextLine(nextline);
//			result.add(nextline);
		}
		result=nextline;
		return result;
	}
	//通过getNextLine生成新的行
	public static ArrayList<Integer> getNextLine(ArrayList<Integer> nextline){
		ArrayList<Integer> thisline = new ArrayList<Integer>();
		thisline.add(1);
		for(int i = 0; i<nextline.size()-1;++i){
			thisline.add(nextline.get(i)+nextline.get(i+1));
		}
		thisline.add(1);
		return thisline;
		}
		
	}
	