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
		//��ʼ��
		if(numRows<0) return null;
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> line = new ArrayList<>();
		if(0==numRows) return result;
		//��һ��
		line.add(1);
		result.add(line);
		//֮�����
		ArrayList<Integer> nextline = line;
		for(int i = 1; i < numRows ;++i){
			//ͨ������getNextLine���������µ���һ��
			nextline = getNextLine(nextline);
			result.add(nextline);
		}
		return result;
	}
	//ͨ��getNextLine�����µ���
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
	
	
	
	
	
