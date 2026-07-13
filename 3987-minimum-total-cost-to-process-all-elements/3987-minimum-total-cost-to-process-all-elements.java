class Solution {
    public int minimumCost(int[] nums, int k) {
       
      
        long temp=k;
        long mod=1_000_000_007L;
        long total=0;
        for(int i=0;i<nums.length;i++){
            if(temp<nums[i]){
                long diff=nums[i]-temp;
           long need=(diff+k-1L)/k;
           temp=temp+need*(long)k;
               total=total+need;
               
            }
            temp-=nums[i];
        }

     long a=total%mod;
     long b=(total+1)%mod;
    long ans=(a*b)%mod;
    ans=(ans*500000004L)%mod;
    return (int)ans;
    }
}