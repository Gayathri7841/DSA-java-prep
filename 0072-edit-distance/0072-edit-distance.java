class Solution {
    String s;
    String t;
    int n;
    int m;
    Integer dp[][];
    public int minDistance(String word1, String word2) {
        s=word1;
        t=word2;
        n=s.length();
        m=t.length();
        dp=new Integer[n][m];
        return fn(0,0);
    }
    private int fn(int i,int j){
        if(i==n) return m-j;
        if(j==m) return n-i;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==t.charAt(j)) {
           return  dp[i][j]=fn(i+1,j+1);
        }
        int insert=1+fn(i,j+1);
        int del=1+fn(i+1,j);
        int replace=1+fn(i+1,j+1);
        return dp[i][j]= Math.min(insert,Math.min(del,replace));
    }
}