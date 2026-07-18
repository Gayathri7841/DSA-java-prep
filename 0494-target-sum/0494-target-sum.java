class Solution {
    int nums[];
    int target;
    Integer dp[][];
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        for(int num:nums) total+=num;
        this.nums=nums;
        this.target=target;
        dp=new Integer[nums.length][2*total+1];
    return fn(0,0);
    }
    private int fn(int index,int sum){
        if(index==nums.length){
            if(sum==target) return 1;
            return 0;
        }
        if(dp[index][sum+total]!=null) return dp[index][sum+total];
        int add=fn(index+1,sum+nums[index]);
        int sub=fn(index+1,sum-nums[index]);
        return dp[index][total+sum]=add+sub;
    }

}