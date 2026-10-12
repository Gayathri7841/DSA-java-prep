class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long MOD = 1000000007;
        int b[]=new int[32];
        long ans=0;
        for(int x:nums){
            for(int i=0;i<32;i++){
                if((x&(1<<i))!=0) b[i]++;

            }
        }
        while(k>0){
            long x=0;
            for(int i=0;i<32;i++){
                if(b[i]>0){
                    x|=1<<i;
                    b[i]--;
                }

            }
            ans=(ans+x*x)%MOD;
            k--;
        }
        return (int) ans;

    }
}