class Solution {
    String s1;
    String s2;
    int m;
    int n;
    Integer dp[][];
   
    public int numDistinct(String s, String t) {
        s1=s;
        s2=t;
        m=s.length();
        n=t.length();
        dp=new Integer[m][n];
        return fn(0,0);
      
    }
    private int fn(int i,int j){
        if(j>=n){
        return 1;
        }
        if(i>=m) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
           return  dp[i][j]=fn(i+1,j+1)+fn(i+1,j);
        } 
           return dp[i][j]=fn(i+1,j);
        
      
    }
}