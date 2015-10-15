public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    /*    int count = 0;
        while(n%2 !=0){
        int k = n % 2;
        //int count = 0;   //aware of the scope of the variable
        if (k == 1)     //important notition
            count++;
        n = n/2 + k;
        }
        return count; */
       /* int count = 0;
        if (n == 0)
        return 0;
        while (n != 0){
            int var = n >> 1;
            if(n != 2*var)
            count++;
        }
        return count;*/
       
       /* int count = 0;
        int temp = 0;
        while (n != 0){
            temp = n & 1;
            count += temp;
            n = n >> 1;
        }
        return count;*/
        int re = 0;

        while(0 != n)
        {
            n = n&(n - 1);
            ++re;
        }

        return re;
    }
}