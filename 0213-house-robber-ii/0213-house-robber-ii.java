class Solution {
    int n;
    int[] nums;
    Integer dp1[];
    Integer dp2[];
    public int rob(int[] nums) {
        n=nums.length;
        if(n==1) return nums[0];
        this.nums=nums;
        dp1=new Integer[n];
         dp2=new Integer[n];
      int left=   dfs(0,n-2,dp1);
      int right=dfs(1,n-1,dp2);
      return Math.max(left,right);
    }
    private int dfs(int index,int i,Integer[] dp){
       
        if(index==i) return nums[i];
        if(index>i) return 0;
        if(dp[index]!=null) return dp[index];
        int pick=nums[index]+dfs(index+2,i,dp);
        int notpick=dfs(index+1,i,dp);
        return dp[index]=Math.max(pick,notpick);
    }
}
