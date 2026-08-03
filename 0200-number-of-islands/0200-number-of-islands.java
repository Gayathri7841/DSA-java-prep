class Solution {
    boolean visited[][];
    char[][] grid;
    int m;
    int n;
    public int numIslands(char[][] grid) {
         m=grid.length;
         n=grid[0].length;
        int ans=0;
        visited=new boolean[m][n];
        this.grid=grid;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
             dfs(i,j);
             ans++;
                }
            }
        }
        return ans;

    }
    private void dfs(int i,int j){
        if(grid[i][j]=='0'||visited[i][j]) return;
visited[i][j]=true;
if(j+1<n) dfs(i,j+1);
if(j-1>=0) dfs(i,j-1);
if(i+1<m) dfs(i+1,j);
if(i-1>=0) dfs(i-1,j);
    }
}