class Solution {
  
   
    public int climbStairs(int n) {
        int   dp[]=new int[n];
return fn(0,n,dp);
    }
    private int fn(int i,int n,int dp[]){
        if(i==n){
          
            return 1;
        }
        if(i>n){
            return 0;
        }
        if(dp[i]!=0) return dp[i];
    dp[i]= fn(i+1,n,dp)+fn(i+2,n,dp);
    return dp[i];
    }
}