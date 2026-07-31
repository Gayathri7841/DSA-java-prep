class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        int n=image.length;
        int m=image[0].length;
        boolean visited[][]=new boolean[n][m];
        Queue<Pair> q=new LinkedList<>();
int number=image[sr][sc];
q.offer(new Pair(sr,sc));
image[sr][sc]=color;
while(!q.isEmpty()){
    Pair node=q.poll();
    int i=node.row;
    int j=node.col;
    //left calculation
    if(j-1>=0&&image[i][j-1]==number){
        q.offer(new Pair(i,j-1));
        image[i][j-1]=color;
    }
    // right calculation
     if(j+1<m&&image[i][j+1]==number){
        q.offer(new Pair(i,j+1));
        image[i][j+1]=color;
    }
    // up calculation
     if(i-1>=0&&image[i-1][j]==number){
        q.offer(new Pair(i-1,j));
        image[i-1][j]=color;
    }

    //down calculation
     if(i+1<n&&image[i+1][j]==number){
        q.offer(new Pair(i+1,j));
        image[i+1][j]=color;
    }

}
return image;
    }
}