package test75;

public class Main {

	public static void main(String[] args) {
		int [] nums = {0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,2,2,2,1,2,0,1,2,0,2,0,2,1,0,1,0,2};
		sortColors(nums);
		for(int i=0;i<nums.length;++i){
			System.out.print(nums[i]+" ");
		}		
	}
	public static void sortColors(int [] nums){
		int [] a = new int [3] ;
		for(int i=0;i<nums.length;++i){    //�������飬��ÿ����ɫ�������浽�½�����Ķ�Ӧλ��
			a[nums[i]]+=1;
		}
		for(int i=0;i<=a[0]-1;++i) nums[i]=0;  //���ո���ɫ�����Ķ��٣��������н�nums����
		for(int i=a[0];i<=a[0]+a[1]-1;++i) nums[i]=1;
		for(int i=a[0]+a[1];i<=nums.length-1;++i) nums[i]=2;
	}
}