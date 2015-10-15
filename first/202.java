  public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }
        long ln = n;
        Set<Long> set = new HashSet<Long>();
        
        
        while(ln <= Integer.MAX_VALUE) {
            if(set.contains(ln)) {    //set.contains   remember the name of the method
                return false;
            }
            else {
                set.add(ln);
            }
            ln = digitSquare(ln);
            if(ln == 1) {
                return true;
            }
            
        }
        return false;
        
    }
    public long digitSquare(long n) {
        long temp = 0;
        while(n !=0)  {     //you can not use while(n),long can`t convert to boolean
            temp += (n%10)*(n%10);
            n = n/10;
        }
        return temp;
    }
}
/*public class Solution {  
    public boolean isHappy(int n) {  
        if(n<=0) return false;  
        long ln = n;  
        Set<Long> set = new HashSet<Long>();  
          
        while(ln<=Integer.MAX_VALUE) {  
            if(set.contains(ln) ) return false; else set.add(ln);  
            ln = digitSquare(ln);  
            if(ln == 1) return true;  
        }  
        return false;  
    }  
      
    private long digitSquare(long ln) {  
        long sum = 0;  
        while(ln!=0) {  
            sum += Math.pow(ln%10, 2);  
            ln /= 10;  
        }  
        return sum;  
    }  
}  */