class Solution {
    public int sumDecoded(long[] nums) {
        long sum=0;
         long MOD=1000000007;
        for(int i=0;i<nums.length;i++){
        long num=nums[i];
            int width=(int)(num%10);
            long d=num/10;
            String s=String.valueOf(d);
          Long  x=Long.parseLong(s.substring(0,width));
            Long y=Long.parseLong(s.substring(width));

            sum=(sum+power(x,y))%MOD;
        }
        return (int)sum;
    }
    private long power(long x,long y){
            long MOD=1000000007;
        long result=1;
        while(y>0){
            if(y%2==1){
                result=(result*x)%MOD;
            }
            x=(x*x)%MOD;
            y=y/2;
        }
        return result;
    }
}