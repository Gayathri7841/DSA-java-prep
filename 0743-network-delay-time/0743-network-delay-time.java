class Solution {
    class Pair{
        int node;
        int time;
        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
       List<Pair> adj[]=new ArrayList[n+1];
       for(int i=0;i<n+1;i++){
        adj[i]=new ArrayList<>();
       }
       for(int i=0;i<times.length;i++){
int u=times[i][0];
int v=times[i][1];
int d=times[i][2];
adj[u].add(new Pair(v,d));
       } 
       int distance[]=new int[n+1];
       final int INF=(int) 1e9;
       Arrays.fill(distance,INF);
       distance[0]=0;
       distance[k]=0;
       PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.time-y.time);
       pq.offer(new Pair(k,0));
       while(!pq.isEmpty()){
        Pair p=pq.poll();
        int u=p.node;
        int dist=p.time;
        for(Pair p1:adj[u]){
            int v=p1.node;
            int d=p1.time;
            if(dist+d<distance[v]) {
            distance[v]=dist+d;
pq.offer(new Pair(v,distance[v]));
            }


        }
       }
       int max=Integer.MIN_VALUE;
       for(int i=0;i<n+1;i++){
max=Math.max(distance[i],max);

       }
       if(max==INF) return -1;
       return max;
    }
}