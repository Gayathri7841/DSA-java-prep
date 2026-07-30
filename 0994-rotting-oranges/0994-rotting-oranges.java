class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid[0].length;//col
        int n=grid.length;//row
     
        boolean visited[][]=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
        int time=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j]==2){
                
                    visited[i][j]=true;
                    q.offer(new Pair(i,j));
                }
            }
        }
       
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                Pair node=q.poll();
                int i=node.row;
                int j=node.col;
                //left calculation
if(j-1>=0&&grid[i][j-1]!=0&&grid[i][j-1]!=2&&!visited[i][j-1]){
    q.offer(new Pair(i,j-1));
    visited[i][j-1]=true;
    grid[i][j-1]=2;
}
//right calculation
if(j+1<m&&grid[i][j+1]!=0&&grid[i][j+1]!=2&&!visited[i][j+1]){
    q.offer(new Pair(i,j+1));
    visited[i][j+1]=true;
    grid[i][j+1]=2;
}

//down calculation
if(i+1<n&&grid[i+1][j]!=0&&grid[i+1][j]!=2&&!visited[i+1][j]){
    q.offer(new Pair(i+1,j));
    visited[i+1][j]=true;
    grid[i+1][j]=2;
}

//up calculation

if(i-1>=0&&grid[i-1][j]!=0&&grid[i-1][j]!=2&&!visited[i-1][j]){
    q.offer(new Pair(i-1,j));
    visited[i-1][j]=true;
    grid[i-1][j]=2;
}
 }


    if (!q.isEmpty()) {
        time++;
    }
        }
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1;
                
            }
        }
        return time;




    }
}