class Solution {
    public boolean canPartition(int[] nums) {
       int sum=0;
       int n=nums.length;
       for(int i=0;i<n;i++){
        sum=sum+nums[i];
       } 
       if(sum%2!=0) return false;
       int m=sum/2;
       int dp[][]=new int[n][m+1];
       for(int i=0;i<n;i++){
        for(int j=0;j<m+1;j++){
            dp[i][j]=-1;
        }
       }
       boolean res=fn(n-1,m,nums,dp);
       return res;
    }
    public boolean fn(int index,int target,int nums[],int dp[][]){
       
        if(target==0) return true;
        if(index==0) return (nums[index]==target);
        if(dp[index][target]!=-1) return dp[index][target]==1;
        boolean notTake=fn(index-1,target,nums,dp);
        boolean taken=false;
        if(nums[index]<=target)
        taken=fn(index-1,target-nums[index],nums,dp);
        dp[index][target]=(notTake||taken)?1:0;
        return notTake||taken;

    }
}