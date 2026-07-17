class Solution {
    int coins[];
    int amount;
    Integer dp[][];
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
     
       this.amount=amount;
this.coins=coins;
dp=new Integer[coins.length+1][amount+1];
int ans = dfs(0,0);
return ans==Integer.MAX_VALUE ?-1:ans;


        
    }
    private int dfs(int index,int sum){
      if(sum==amount) return 0;
        if(sum>amount) return Integer.MAX_VALUE;
        if(index==coins.length){
            if(sum==amount) return 0;
            return Integer.MAX_VALUE;
        }

if(sum==Integer.MIN_VALUE) return Integer.MAX_VALUE;
if(dp[index][sum]!=null) return dp[index][sum];
int take=Integer.MAX_VALUE;
if(dfs(index,coins[index]+sum)!=Integer.MAX_VALUE){
    take=1+dfs(index,coins[index]+sum);
}


int skip=dfs(index+1,sum);

return dp[index][sum]=Math.min(take,skip);
    }
}