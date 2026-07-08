class Solution {
    int m,n;
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m=obstacleGrid.length;
        n=obstacleGrid[0].length;
        dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //obstcle cell
                 if(obstacleGrid[i][j]==1){ 
                    dp[i][j]=0;
                    }
                     //start cell
             else  if(i==0&&j==0) {
             dp[i][j]=1;
             }
               
               
                //handling if obstacle is in first row
              else if(i==0) {
              dp[i][j]=dp[i][j-1];
              }
               //handling if obstacle is in 1st col
              else if(j==0) {
              dp[i][j]=dp[i-1][j];
              }
               //normal cells
               else{
               int up=dp[i-1][j];
               int left=dp[i][j-1];
               dp[i][j]=up+left;
               }

            }
        }
        return dp[m-1][n-1];
    }
  

}