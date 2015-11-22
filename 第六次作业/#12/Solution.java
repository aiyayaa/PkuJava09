public class Solution {
    public String intToRoman(int num) {
        String[][] roman = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
        };
        String str = "";
        int digit = 0;
        while(num != 0) {
            int remain = num %10;
            str = roman[digit][remain] + str;
            digit++;
            num = num/10;
        }
        
        return str;
    }
}