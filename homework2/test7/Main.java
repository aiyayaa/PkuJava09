package test7;

public class Main {

	public static void main(String[] args) {
		int test = -123456;            //���Test case
		test = reverse(test);		
		System.out.println(test);
	}
/*
 *  ����˼·��1.��integerת����string��������н���(�Ƚϱ�)
 *  				2.��ջ�㶨
 */	
	//�ðɣ���ʵû��ô�鷳 = =
    public static int reverse(int x){
    	long result =0;
    	while(x!=0){
    		int temp = x%10;
    		x/=10;
    		result = result*10+temp;
    		}
    	if(result>Integer.MAX_VALUE) x=0;
    	else if(result<Integer.MIN_VALUE) x=0;
    	else {
    		x=(int)result;
    	}
    	return x;
    }	
}


// more niubility&interesting solution (comes from Internet)
//��������������ж��ϣ����жϷ������ŵ��ǣ���������long ����������������Ч����
//														ȱ���ǣ�whileѭ��ÿһ�ζ�Ҫ����һ������							

/*public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}*/




