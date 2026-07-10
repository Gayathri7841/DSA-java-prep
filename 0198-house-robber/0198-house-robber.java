class Solution {
    int n;
    int[] nums;
    Integer dp[];
    public int rob(int[] nums) {
        n=nums.length;
        this.nums=nums;
        dp=new Integer[n];
        return dfs(0);
    }
    private int dfs(int index){
       
        if(index==n-1) return nums[n-1];
        if(index>n-1) return 0;
        if(dp[index]!=null) return dp[index];
        int pick=nums[index]+dfs(index+2);
        int notpick=dfs(index+1);
        return dp[index]=Math.max(pick,notpick);
    }
}