class Solution {
    class Pair{
        int row;
        int col;
        int weight;
        Pair(int row,int col, int weight){
            this.row=row;
            this.col=col;
            this.weight=weight;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        Queue<Pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[grid.length][grid.length];
       
        vis[0][0]=true;
        q.offer(new Pair(0,0,1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int i=p.row;
            int j=p.col;
            int d=p.weight;
            if(i == n-1 && j == n-1)
    return d;
            if(i-1>=0&&grid[i-1][j]!=1&&!vis[i-1][j]) {
                vis[i-1][j]=true;
                q.offer(new Pair(i-1,j,d+1));
            }

 if(i+1<n&&grid[i+1][j]!=1&&!vis[i+1][j]) {
                vis[i+1][j]=true;
                q.offer(new Pair(i+1,j,d+1));
            }
             if(j-1>=0&&grid[i][j-1]!=1&&!vis[i][j-1]) {
                vis[i][j-1]=true;
                q.offer(new Pair(i,j-1,d+1));
            }
             if(j+1<n&&grid[i][j+1]!=1&&!vis[i][j+1]) {
                vis[i][j+1]=true;
                q.offer(new Pair(i,j+1,d+1));
            }
             if(i-1>=0&&j-1>=0&&grid[i-1][j-1]!=1&&!vis[i-1][j-1]) {
                vis[i-1][j-1]=true;
                q.offer(new Pair(i-1,j-1,d+1));
            }
             if(i+1<n&&j+1<n&&grid[i+1][j+1]!=1&&!vis[i+1][j+1]) {
                vis[i+1][j+1]=true;
                q.offer(new Pair(i+1,j+1,d+1));
            }
             if(i-1>=0&&j+1<n&&grid[i-1][j+1]!=1&&!vis[i-1][j+1]) {
                vis[i-1][j+1]=true;
                q.offer(new Pair(i-1,j+1,d+1));
            }
             if(i+1<n&&j-1>=0&&grid[i+1][j-1]!=1&&!vis[i+1][j-1]) {
                vis[i+1][j-1]=true;
                q.offer(new Pair(i+1,j-1,d+1));
            }








        }
       return -1;
    }
}