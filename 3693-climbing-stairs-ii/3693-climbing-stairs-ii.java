class Solution {
    public int climbStairs(int n, int[] costs) {
      int dp[]=new int[n+1];
      dp[0]=0;
      for(int j=1;j<n+1;j++){
        int mini=Integer.MAX_VALUE;
        for(int i=j-3;i<j;i++){
            if(i<0) continue;
            int cost=costs[j-1]+(j-i)*(j-i);
            int total=cost+dp[i];
            mini=Math.min(mini,total);
        }
        dp[j]=mini;
      }  
      return dp[n];
    }
}