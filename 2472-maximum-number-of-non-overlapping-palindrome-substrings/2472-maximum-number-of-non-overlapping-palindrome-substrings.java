class Solution {
    int dp[];
    int n;
    boolean palindrome[][];
    public int maxPalindromes(String s, int k) {
         n=s.length();
        dp=new int[n+1];
       palindrome =new boolean[n][n];
        for(int len=1;len<=n;len++){
for(int i=0;i+len-1<n;i++){
   int j=i+len-1;
    if(s.charAt(i)==s.charAt(j)){
        if(len<=2) palindrome[i][j]=true;
        else palindrome[i][j]=palindrome[i+1][j-1];
    }

}
        }
for(int i=0;i<n;i++)
{
    fn(i,s,k);
}
return dp[0];
    }
    private int fn(int i,String str,int k){
        if(i==n) return 0;
        if(dp[i]!=0) return dp[i];
int nottake=fn(i+1,str,k);
dp[i]=nottake;
int take=0;
for(int j=i+k-1;j<n;j++){
    if(palindrome[i][j]) dp[i]=Math.max(dp[i],1+fn(j+1,str,k));
}
return dp[i];
    }
}