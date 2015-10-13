package test7;

public class Main {

	public static void main(String[] args) {
		int test = -123456;            //添加Test case
		test = reverse(test);		
		System.out.println(test);
	}
/*
 *  初见思路：1.将integer转化成string，对其进行交换(比较笨)
 *  				2.用栈搞定
 */	
	//好吧，其实没那么麻烦 = =
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
//亮点在于溢出的判断上，该判断方法的优点是：不用引入long ，减少了溢出后的无效操作
//														缺点是：while循环每一次都要进行一次运算							

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




