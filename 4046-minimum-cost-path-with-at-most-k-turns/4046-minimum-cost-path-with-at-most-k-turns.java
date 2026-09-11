class Solution {
    class Pair{
        int row;
        int col;
        int val;
        int cost;
        char c;
        Pair(int row,int col,int val,int cost,char c){
            this.row=row;
            this.col=col;
            this.val=val;
            this.cost=cost;
            this.c=c;
        }
    }
    public int minCost(int[][] grid, int k) {
       int n =grid.length;
       int m=grid[0].length;
       PriorityQueue<Pair> q=new PriorityQueue<>((x,y)->(x.cost-y.cost));
       q.offer(new Pair(0,0,k,grid[0][0],'n'));
       int distance[][][][]=new int[n][m][5][k+1];
       final int INF=(int)1e9;
      for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){
        for(int d = 0; d < 5; d++){
            for(int t = 0; t <= k; t++){
                distance[i][j][d][t] = INF;
            }
        }
    }
}
       distance[0][0][4][k]=grid[0][0];
while(!q.isEmpty()){
    Pair p=q.poll();
    int i=p.row;
    int j=p.col;
    int target=p.val;
    int weight=p.cost;
    char ch=p.c;
    if(i==n-1&&j==m-1) return weight;
    // up
  
    if(i-1>=0){
          int newTarget=target;
        if(ch=='l'||ch=='r') newTarget--;
        if(newTarget>=0&&distance[i-1][j][0][newTarget]>weight+grid[i-1][j]){
        distance[i-1][j][0][newTarget]=weight+grid[i-1][j];
        q.offer(new Pair(i-1,j,newTarget,distance[i-1][j][0][newTarget],'u'));
        }
    }
    //down
     if(i+1<n){
int newTarget=target;
        if(ch=='l'||ch=='r') newTarget--;
    if(newTarget>=0&&distance[i+1][j][1][newTarget]>weight+grid[i+1][j])
        {
        distance[i+1][j][1][newTarget]=weight+grid[i+1][j];
        q.offer(new Pair(i+1,j,newTarget,distance[i+1][j][1][newTarget],'d'));
        }
    }
    //left
    if(j-1>=0){
        int newTarget=target;
        if(ch=='u'||ch=='d') newTarget--;
    if(newTarget>=0&&distance[i][j-1][2][newTarget]>weight+grid[i][j-1])
        {
        distance[i][j-1][2][newTarget]=weight+grid[i][j-1];
        q.offer(new Pair(i,j-1,newTarget,distance[i][j-1][2][newTarget],'l'));
        }
    }
    //right
    if(j+1<m){
        int newTarget=target;
        if(ch=='u'||ch=='d') newTarget--;
            if(newTarget>=0&&distance[i][j+1][3][newTarget]>weight+grid[i][j+1]){
        distance[i][j+1][3][newTarget]=weight+grid[i][j+1];
        q.offer(new Pair(i,j+1,newTarget,distance[i][j+1][3][newTarget],'r'));
    }
    }

}
return -1;

    }
}