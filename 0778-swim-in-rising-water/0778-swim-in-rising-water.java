class Solution {
    class Pair{
        int row;
        int col;
        int distance;
        Pair(int row,int col,int distance){
            this.row=row;
            this.col=col;
            this.distance=distance;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int dist[][]=new int[n][m];
        final int INF=Integer.MAX_VALUE;
for(int i=0;i<n;i++){
    Arrays.fill(dist[i],INF);
}
dist[0][0]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        pq.offer(new Pair(0,0,0));
while(!pq.isEmpty()){
    Pair p=pq.poll();
    int i=p.row;
    int j=p.col;
    int d=p.distance;
int maxi=Math.max(grid[i][j],d);
// left
if(j - 1 >= 0) {
    int newDist = Math.max(maxi, grid[i][j - 1]);

    if(dist[i][j - 1] > newDist) {
        dist[i][j - 1] = newDist;
        pq.offer(new Pair(i, j - 1, newDist));
    }
}

// right
if(j + 1 < m) {
    int newDist = Math.max(maxi, grid[i][j + 1]);

    if(dist[i][j + 1] > newDist) {
        dist[i][j + 1] = newDist;
        pq.offer(new Pair(i, j + 1, newDist));
    }
}

// up
if(i - 1 >= 0) {
    int newDist = Math.max(maxi, grid[i - 1][j]);

    if(dist[i - 1][j] > newDist) {
        dist[i - 1][j] = newDist;
        pq.offer(new Pair(i - 1, j, newDist));
    }
}

// down
if(i + 1 < n) {
    int newDist = Math.max(maxi, grid[i + 1][j]);

    if(dist[i + 1][j] > newDist) {
        dist[i + 1][j] = newDist;
        pq.offer(new Pair(i + 1, j, newDist));
    }
}
}
return dist[n-1][m-1];

    }
}