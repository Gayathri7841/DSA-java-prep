class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int res[][]=new int[m][n];
        boolean visited[][]=new boolean[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
q.offer(new Pair(i,j));
visited[i][j]=true;
                }
            }
        }
        int val=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair node=q.poll();
                int r=node.row;
                int c=node.col;
                res[r][c]=val;
                
                if(c-1>=0&&!visited[r][c-1]){
                 q.offer(new Pair(r,c-1));
                   visited[r][c-1]=true;
                }

                if(c+1<n&&!visited[r][c+1])
                {
                 q.offer(new Pair(r,c+1));
                   visited[r][c+1]=true;
                }
                if(r-1>=0&&!visited[r-1][c])
                {
                 q.offer(new Pair(r-1,c));
                   visited[r-1][c]=true;
                }
                if(r+1<m&&!visited[r+1][c]){
                 q.offer(new Pair(r+1,c));
                   visited[r+1][c]=true;
                }

            }
            val=val+1;
        }
return res;

    }
}