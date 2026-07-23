class Solution {
   
    public int maxProfit(int[] prices) {
       
     int   n=prices.length;

     

int dp[][][]=new int[n+1][2][5];
        for(int index=n-1;index>=0;index--){
for(int buy=0;buy<=1;buy++){
    for(int count=3;count>=0;count--){
        if(buy==0){
            int b=dp[index+1][1][count+1]-prices[index];
            int nb=dp[index+1][0][count];
            dp[index][0][count]=Math.max(b,nb);

        }
        else{
             int s=dp[index+1][0][count+1]+prices[index];
            int ns=dp[index+1][1][count];
            dp[index][1][count]=Math.max(s,ns);
        }
    }
}
        }

      return dp[0][0][0];  
    }
   
}