class Solution {
    String s1;
    String s2;
    int n;
    int m;
    Integer dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
      s1=text1;
      s2=text2;
      n=s1.length();
      m=s2.length();
dp=new Integer[n][m];
      return fn(0,0);
    }
    private int fn(int i,int j){
        if(i==n||j==m) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) {
            return dp[i][j]=1+fn(i+1,j+1);
        }
        return dp[i][j]=Math.max(fn(i+1,j),fn(i,j+1));
    }

}