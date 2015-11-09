public class Solution {
    public int romanToInt(String s) {
        Map <Character, Integer> map = new HashMap <Character ,Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

/*        char[] symbol = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
        int[] val = { 1, 5, 10, 50, 100, 500, 1000 };
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < symbol.length; i++)
            map.put(symbol[i], val[i]);
  */          
        int result = 0;
        
        for(int i = s.length()-1; i >= 0; i--) {
            if(i == s.length() - 1) {
                result = map.get(s.charAt(i));
                continue;
            }
            if(map.get(s.charAt(i)) >= map.get(s.charAt(i+1))) {
                result = result + map.get(s.charAt(i));
            } else {
                result = result - map.get(s.charAt(i));
            }
        }
        
        return result;
    }
}