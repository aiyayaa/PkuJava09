public class Solution {
    public boolean isUgly(int num) {
/*        int flag = 0;
        if(num <= 0)
            return false;
        if(num == 1)
            return true;
            
        while(num != 1) {
            if(num % 2 == 0) {
                num = num/2;
                flag = 1;
            } 
            if (num % 3 == 0) {
                num = num/3;
                flag = 1;
            }
            if(num % 5 ==0) {
                num = num/5;
                flag = 1;
            }
            if(flag == 0)
                return false;
        }
        return true;
*/      if (num <= 0) {
            return false;
        }
        if (num == 1)
            return true;
        while(num >= 2 && num%2 == 0)
            num /= 2;
        while(num >= 3 && num%3 == 0)
            num /= 3;
        while(num >= 5 && num%5 == 0)
            num /=5;
        return num == 1;
    }
}