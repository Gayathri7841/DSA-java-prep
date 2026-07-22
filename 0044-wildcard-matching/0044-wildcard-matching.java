class Solution {
    String s;
    String p;
    int n;
    int m;
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        this.s=s;
        this.p=p;
        n=s.length();
     
        m=p.length();
          
        dp=new Boolean[n][m];
        return fn(0,0);
    }
    private boolean fn(int i,int j){
        if(j==m&&i==n) return true;
        if(j==m&&i<n) return false;
    if(i==n){
        for(int k=j;k<m;k++){
            if(p.charAt(k)=='*') continue;
            else return false;
        }
        return true;
    }

        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?'){
            return dp[i][j]=fn(i+1,j+1);
        }
        if(p.charAt(j)=='*'){
           
        return    dp[i][j]=fn(i,j+1)||fn(i+1,j);
           
           
          
        }
        return  false;
    }
}