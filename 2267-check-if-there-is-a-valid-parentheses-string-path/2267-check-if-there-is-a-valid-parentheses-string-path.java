class Solution {
    Boolean dp[][][];
    char [][] grid;
    int m;
    int n;
    public boolean hasValidPath(char[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        if ((m + n - 1) % 2 == 1) { return false; }
        dp=new Boolean[m][n][m+n];
        if(grid[0][0]==')') return false;
        return fn(0,0,0);
    }
    private boolean fn(int i,int j,int balance){
        char ch=grid[i][j];
         if(ch=='('){
            balance++;
        }else{
            balance--;
        }
          if(balance<0) return false;
        if(i==m-1&&j==n-1){
            if(balance==0) return true;
            return false;
        }
      
        if(dp[i][j][balance]!=null) return dp[i][j][balance];

        boolean right=false;
        boolean down=false;
       if(j+1<n) right=fn(i,j+1,balance);
    if(i+1<m) down=fn(i+1,j,balance);
       return dp[i][j][balance]=right||down;
    }
}