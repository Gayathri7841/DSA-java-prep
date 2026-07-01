class Solution {
    static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
       long even=(n+1)/2;
       long odd=n/2;
        return (int)((power(5,even)*power(4,odd))%MOD);
    }
    public long power(int x,long n){
         if(n==0) return 1;
   
     long ans=power(x,n/2);
     ans=(ans*ans)%MOD;
    if(n%2==1){
      ans=(ans*x)%MOD;
    }
    return ans;
    }
}