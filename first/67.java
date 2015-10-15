/*public static String addBinary(String a,String b){
    char[] achar = a.toCharArray();
    char[] bchar = b.toCharArray();
    aIndex = achar.length -1;
    bIndex = bchar.length -1;
    //int SIZE = Math.max(aIndex , bIndex)+1;
    int SIZE = Math.max(aIndex , bIndex)+2;  //c as the sum
    char[] c = new char[SIZE];  
    int flag = 0;
    while(aIndex >= 0 && bIndex >=0) {
        int num = achar[aIndex] - '0' + bchar[bIndex] - '0' + flag;
        flag = num/2;
        num%=2;
        c[--SIZE] = (char)num;
        aIndex--;
        bIndex--;
    }
    while(aIndex >=0) {
        int num = achar[aIndex] - '0' + flag;
        flag = num/2;
        num%=2;
        c[--SIZE] = (char)num;
        aIndex--;
    }
    while(bIndex >=0) {
      int num = bchar[bIndex] - '0' + flag;
        flag = num/2;
        num%=2;
        c[--SIZE] = (char)num;
        bIndex--;  
    }
    if (c[SIZE - 1] == null) {
        int cIndex = c.length - 2;
        while (cIndex > 0 ) {
            int i = o;
            c [i++] = c[i+1];
            cIndex --;
        }
    }
    return c.toString();
}
public class Solution {
    public String addBinary(String a, String b) {
        addBinary(String a, String b);
    }
}
*/

public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){      //令a为最长字符串，取消了上面算法中的多个判断语句
            String tmp = a;
            a = b;
            b = tmp;
        }
        
        int pa = a.length()-1;   //利用charAt函数进而取消数组的使用。
        int pb = b.length()-1;
        int carries = 0;
        String rst = "";      //String 赋初始值
        
        while(pb >= 0){
            int sum = (int)(a.charAt(pa) - '0') + (int)(b.charAt(pb) - '0') + carries;    //将char 换成int类型。
            rst = String.valueOf(sum % 2) + rst;   //字符串相加直接相连
            carries = sum / 2;         //进位
            pa --;
            pb --;
        }
        
        while(pa >= 0){
            int sum = (int)(a.charAt(pa) - '0') + carries;
            rst = String.valueOf(sum % 2) + rst;
            carries = sum / 2;
            pa --;
        }       
        
        if (carries == 1)
            rst = "1" + rst;    //若进位为1则需要加上
        return rst;
    }
}