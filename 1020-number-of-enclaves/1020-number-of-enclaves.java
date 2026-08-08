class Solution {
     class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int numEnclaves(int[][] board) {
      int n=board.length;
        int m=board[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean visited[][]=new boolean[n][m];
         for(int i=0;i<n;i++){
         if(board[i][0]==1){
visited[i][0]=true;
          q.offer(new Pair(i,0));
         }
         if(board[i][m-1]==1) {
            visited[i][m-1]=true;
         q.offer(new Pair(i,m-1));
         }
        }
        for(int j=0;j<m;j++){
            if(board[0][j]==1){
                visited[0][j]=true;
             q.offer(new Pair(0,j));
            }
            if(board[n-1][j]==1){
                visited[n-1][j]=true;
             q.offer(new Pair(n-1,j));
            }
        }
        while(!q.isEmpty()){
 Pair node=q.poll();
    int i=node.row;
    int j=node.col;
      if(j-1>=0&&board[i][j-1]==1&&!visited[i][j-1]){
        visited[i][j-1]=true;
        q.offer(new Pair(i,j-1));
    }
 if(j+1<m&&board[i][j+1]==1&&!visited[i][j+1]){
        visited[i][j+1]=true;
        q.offer(new Pair(i,j+1));
    }
     if(i-1>=0&&board[i-1][j]==1&&!visited[i-1][j]){
        visited[i-1][j]=true;
        q.offer(new Pair(i-1,j));
    }
     if(i+1<n&&board[i+1][j]==1&&!visited[i+1][j]){
        visited[i+1][j]=true;
        q.offer(new Pair(i+1,j));
    }
 }
 int count=0;
 for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
       if(board[i][j] == 1 && !visited[i][j]){
            count++;
        }
      
    }
}   
return count; 
    }
}