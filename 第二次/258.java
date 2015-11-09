public class Solution {
    public int addDigits(int num) {
/*        int temp = 0;
        int sum = num;
        while(sum > 10) {
            while(sum != 0) {
                temp = temp + sum%10;
            }
            sum = temp;
        }
        return sum;
*/      return 1+(num-1) %9;   //num = a * 10000 + b * 1000 + c * 100 + d * 10 + e

                               //num = (a + b + c + d + e) + (a * 9999 + b * 999 + c * 99 + d * 9)
    }
}