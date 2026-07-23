class Solution {
    int[] arr;
    int n;
    Integer dp[][][];
    public int maxProfit(int[] prices) {
        arr=prices;
        n=prices.length;
dp=new Integer[n][2][5];
        return fn(0,0,0);
    }
    private int fn(int index,int buy,int count){
        if(count==4) return 0;
        if(index==n) return 0;
        if(dp[index][buy][count]!=null) return dp[index][buy][count];
        if(buy==0){
            int b=fn(index+1,1,count+1)-arr[index];
            int nb=fn(index+1,0,count);
            return dp[index][buy][count]= Math.max(b,nb);
        }
        
            int s=arr[index]+fn(index+1,0,count+1);
            int ns=fn(index+1,1,count);
            return dp[index][buy][count]=Math.max(s,ns);
        

    }
}