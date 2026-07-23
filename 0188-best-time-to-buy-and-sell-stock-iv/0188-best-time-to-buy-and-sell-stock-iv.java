class Solution {
     int[] arr;
    int n;
    int k;
    Integer dp[][][];
    public int maxProfit(int k, int[] prices) {
    arr=prices;
        n=prices.length;
        this.k=k;
dp=new Integer[n][2][k+1];
        return fn(0,0,0);
    }
    private int fn(int index,int buy,int count){
        if(count==k) return 0;
        if(index==n) return 0;
        if(dp[index][buy][count]!=null) return dp[index][buy][count];
        if(buy==0){
            int b=fn(index+1,1,count)-arr[index];
            int nb=fn(index+1,0,count);
            return dp[index][buy][count]= Math.max(b,nb);
        }
        
            int s=arr[index]+fn(index+1,0,count+1);
            int ns=fn(index+1,1,count);
            return dp[index][buy][count]=Math.max(s,ns);
        

    }

    }
