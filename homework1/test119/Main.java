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
		//��ʼ��
		++rowIndex;
		if(rowIndex<0) return null;
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> line = new ArrayList<>();
		if(0==rowIndex) return result;
		//��һ��
		line.add(1);
		result=line;
		//֮�����
		ArrayList<Integer> nextline = line;
		for(int i = 1; i < rowIndex ;++i){
			//ͨ������getNextLine���������µ���һ��
			nextline = getNextLine(nextline);
//			result.add(nextline);
		}
		result=nextline;
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
	