class Solution {
    int[] arr;
    int n;
    Integer dp[][];
    int fees;
    public int maxProfit(int[] prices,int fees) {
        this.fees=fees;
        arr=prices;
        n=prices.length;
dp=new Integer[n][2];
        return fn(0,0);
    }
    private int fn(int index,int buy){
      
        if(index>=n) return 0;
        if(dp[index][buy]!=null) return dp[index][buy];
        if(buy==0){
            int b=fn(index+1,1)-arr[index];
            int nb=fn(index+1,0);
            return dp[index][buy]= Math.max(b,nb);
        }
        
            int s=arr[index]-fees+fn(index+1,0);
            int ns=fn(index+1,1);
            return dp[index][buy]=Math.max(s,ns);
        

    }
}