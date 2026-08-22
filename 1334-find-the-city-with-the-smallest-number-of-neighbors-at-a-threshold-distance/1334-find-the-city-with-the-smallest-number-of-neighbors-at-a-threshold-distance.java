class Solution {
    class Pair{
        int node;
        int threshold;
        Pair(int node,int threshold){
            this.node=node;
            this.threshold=threshold;
        }
    }
    int count[];
    int target;
    List<Pair> adj[];
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      count=new int[n];
target=distanceThreshold;

adj=new ArrayList[n];
for (int i = 0; i < n; i++) {
    adj[i] = new ArrayList<>();
}
for(int i=0;i<edges.length;i++){
    int u=edges[i][0];
 int v=edges[i][1];
 int t=edges[i][2];
 adj[u].add(new Pair(v,t));
 adj[v].add(new Pair(u,t));
}
 for(int i=0;i<n;i++){
    fn(i);
 } 
 int min=Integer.MAX_VALUE;
 int index=-1;
 for(int i=0;i<count.length;i++){
    if(count[i]<=min){
        min=count[i];
        index=i;
    }
 }
 return index;  
    }
    private void fn(int src){
        int n = adj.length;
         int[] distance = new int[n];
          Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.threshold-y.threshold);
      distance[src] = 0;
        pq.offer(new Pair(src, 0));
           

        while(!pq.isEmpty()){
           Pair p=pq.poll();
           int u=p.node;
           int d=p.threshold;
            if (d > distance[u]) {
                continue;
            }
           for(Pair p1:adj[u]){
            int v=p1.node;
            int dist=p1.threshold;
            if(d+dist<distance[v]){
                distance[v]=d+dist;
                pq.offer(new Pair(v,dist+d));
               
            }
           } 

        }
        int ccount=0;
        for(int i=0;i<distance.length;i++){
            if(distance[i]<=target){
                ccount++;
            }
        }
        count[src]=ccount;
    }
}