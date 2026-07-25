class Solution {
    
public int lengthOfLIS(int[] nums) {
       
int n=nums.length;
 int dp[][]=new int[n+1][n+1];
 for(int index=n-1;index>=0;index--){
    for(int prev=index-1;prev>=-1;prev--){
  int notpick=dp[prev+1][index+1];
  int pick=0;
   if(prev==-1||nums[index]>nums[prev]){
    pick=1+dp[index+1][index+1];
   }
dp[prev + 1][index] = Math.max(pick, notpick);
    }
 }
return dp[0][0];
    }
    
}