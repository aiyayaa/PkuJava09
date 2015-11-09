public class Solution {
    List<List<Integer>> con = new ArrayList<List<Integer>>();   //define a whole var;
    public List<List<Integer>> threeSum(int[] num) {
        if(num == null || num.length < 3) 
            return con;
        
        Arrays.sort(num);  //sort num
        
        int len = num.length;
        for(int i = 0; i < len -2; i++) {
            if ( i > 0 && num[i] == num[i-1]) continue;
            find(num, i+1 , len-1,num[i]);
        }
        return con;
    }
    
    public void find(int[] num, int begin,int end, int target) {
        int l = begin, r = end;
        while(l < r) {
            if(num[l] + num[r] + target ==0) {
                List<Integer> row = new ArrayList<Integer>();
                row.add(target);
                row.add(num[l]);
                row.add(num[r]);
                con.add(row);
                //row.add
                
                while (l < r && num[l] == num[l+1]) l++;
                while (l < r && num[r] == num[r-1]) r--;
                l++;
                r--;
            }
            else if(num[l] + num[r] + target < 0) {
                l++;
            }else{
                r--;
            }
        }
    }
}