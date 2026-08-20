class Solution {
   
    class Pair{
        int n;
        int d;
        Pair(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Pair> adj[]=new ArrayList[n];
        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int cost=flights[i][2];
            adj[u].add(new Pair(v,cost));
        }
        int[] distance=new int[n];
        final int INF=(int)1e9;
      Arrays.fill(distance,INF);
      distance[src]=0;
        Queue<Pair> pq=new LinkedList<>();
      pq.offer(new Pair(src,0));

      int flightsTaken=0;
      while(!pq.isEmpty()&&flightsTaken<=k){
        int size=pq.size();

        while(size>0){
 Pair p=pq.poll();
        int f=p.n;
       
        int c=p.d;
         for(Pair pp:adj[f]){
            int node=pp.n;
            int price=pp.d;
        if( c+price<distance[node]){
                distance[node]= c+price;
                pq.offer(new Pair(node,distance[node]));
            }
        }
        size--;
        }
        flightsTaken++;
    }
     return distance[dst]==INF?-1:distance[dst];
    }
}