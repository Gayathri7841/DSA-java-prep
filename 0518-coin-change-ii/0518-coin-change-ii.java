class Solution {
    int amount;
    int coins[];
    Integer dp[][];
public int change(int amount, int[] coins) {
    this.coins=coins;
    this.amount=amount;
    dp=new Integer[coins.length][amount+1];
    return fn(0,0);    
    }
    private int fn(int index,int sum){
        if(sum>amount) return 0;
        if(index==coins.length) return sum==amount?1:0;
        if(dp[index][sum]!=null) return dp[index][sum];
        int left=fn(index,sum+coins[index]);
        int right=fn(index+1,sum);
        return dp[index][sum]=left+right;
    }
}