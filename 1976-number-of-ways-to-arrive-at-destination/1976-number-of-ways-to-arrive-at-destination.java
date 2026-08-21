class Solution {
    class Pair{
        int node;
        long dist;
        Pair(int node,long dist){
            this.node=node;
            this.dist=dist;

        }

    }
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->Long.compare(x.dist,y.dist));
        long distance[]=new long[n];
        long count[]=new long[n];
        List<Pair> adj[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
       final long INF = Long.MAX_VALUE;
        final long MOD= 1000000007;;
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int d=roads[i][2];
            adj[u].add(new Pair(v,d));
            adj[v].add(new Pair(u,d));
        }
        Arrays.fill(distance,INF);
        distance[0]=0;
        pq.offer(new Pair(0,0));
       count[0]=1;
  while(!pq.isEmpty()){
            Pair p=pq.poll();
            int u=p.node;
            long d=p.dist;
         
          for(Pair p1:adj[u]){
            int v=p1.node;
            long wt=p1.dist;
            if(d+wt<distance[v]){
                distance[v]=d+wt;
                pq.offer(new Pair(v,d+wt));
                count[v]=count[u];
            }
            else if(d+wt==distance[v])   count[v] = (count[v] + count[u]) % MOD;
          }


        }
         return (int)count[n-1];
    }
   
}