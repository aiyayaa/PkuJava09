public class Solution {
    public int myAtoi(String str) {
        int max = Long.MAX_VALUE;
        int min = Long.MIN_VALUE;
        long sum = 0;
        //String ss = str.trim();
        str = str.trim();
        int len = str.length();  //simplified the next lines coding
        int flag = 1;
        if(len < 1)   //ss.length()this is a method!
            return 0；
        if (ss.charAt(0) = '+') 
            flag = 1;
            ss.replace(ss.charAt(0),' ');
            ss = ss.trim();
        //else
        //    flag = -1;
        if (ss.charAt(0) = '-')
            flag = -1;
            ss.replace(ss.charAt(0),' ');
            ss = ss.trim();
            
        //long sum = 0;
        for(int i = 0; i < ss.length(); i++) {
            //while(ss.charAt(i) != '\0') {   //not necessary
                if(ss.charAt(i) >= '0' && ss.charAt(i) <= '9')
                    sum = sum * 10 + (ss.charAt(i) - '0');  //why add - '0'
                else
                    sum = sum * flag;
                //if (sum > Long.MAX_VALUE || sum < Long.MIN_VALUE) {
                 //   return sum > 0 ? Long.MAX_VALUE : Long.MIN_VALUE;
                //}
                if(sum > max || sum < min) {
                    return  sum > 0 ? max : min;
                 }
                
           // }
        }
    }
}

/*public class Solution 
{
    public int myAtoi(String str)
    {
        int max = Integer.MAX_VALUE;
        int min = -Integer.MIN_VALUE;
        long result = 0;
        str = str.trim();
        int len = str.length();
        if (len < 1)
            return 0;
        int start = 0;
        boolean neg = false;//标示正负
 
        if (str.charAt(start) == '-' || str.charAt(start) == '+') 
        {
            if (str.charAt(start) == '-')
                neg = true;
            start++;
        }
 
        for (int i = start; i < len; i++) 
        {
            char ch = str.charAt(i);
 
            if (ch < '0' || ch > '9')
                break;
            result = 10 * result + (ch - '0');
            if (!neg && result > max)// 超出边界时，直接返回边界值
                return max;
            if (neg && -result < min)
                return min;
 
        }
        if (neg)
            result = -result;
 
        return (int) result;
    }
}*/