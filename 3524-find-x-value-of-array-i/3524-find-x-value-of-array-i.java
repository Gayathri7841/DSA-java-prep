class Solution {
    public long[] resultArray(int[] nums, int k) {
        long res[]=new long[k];
        int n=nums.length;
        long dp[]=new long[k];
        for(int i=0;i<n;i++){
            long ndp[]=new long[k];

            int rem=nums[i]%k;
            ndp[rem]++;
            for(int j=0;j<k;j++){
               int newrem=(int)(((long)j*nums[i])%k);
               ndp[newrem]+=dp[j];
                    
                
            }
dp=ndp;
for(int j=0;j<k;j++){
    res[j]+=dp[j];
}
        }
        return res;
    }
}