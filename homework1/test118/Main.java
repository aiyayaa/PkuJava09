package test118;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		int num = 10;
		List<List<Integer>> result = generat(num);	
		for(int i=0;i<num;++i){
			System.out.println(result.get(i));
		}
		
	}
	public static List<List<Integer>> generat(int numRows){
		//初始化
		if(numRows<0) return null;
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> line = new ArrayList<>();
		if(0==numRows) return result;
		//第一行
		line.add(1);
		result.add(line);
		//之后各行
		ArrayList<Integer> nextline = line;
		for(int i = 1; i < numRows ;++i){
			//通过调用getNextLine方法生成新的下一行
			nextline = getNextLine(nextline);
			result.add(nextline);
		}
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
	
	
	
	
	
