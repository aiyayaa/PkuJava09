public class Solution {
    public String addBinary(String a, String b) {
        int m = a.length(); //字符串a的长度
        int n = b.length();  //字符串b的长度
        int carry = 0;  //carry进位
        String res = "";
        int maxLen = Math.max(m, n);
        for (int i = 0; i < maxLen; i++) {//如出现a，b位数不一样，短的那个数前端补0
            int p=0,q=0;
            if(i<m)
            p = a.charAt(m-1-i) - '0';
            else
            p = 0;
            
            if(i<n)
            q = b.charAt(n-1-i)-'0';
            else
            q = 0;
            
            int tmp = p + q + carry;
            carry = tmp / 2;
            //res+=tmp%2;
            res = tmp%2 + res;
        }
        return (carry == 0) ? res : "1" + res;//检查最后进位是否为1
        
    }
}