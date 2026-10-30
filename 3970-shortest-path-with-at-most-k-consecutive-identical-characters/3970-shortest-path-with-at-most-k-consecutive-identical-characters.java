class Solution {
    class Pair{
        int node;
        int wt;
        int count;
        Pair(int node,int wt,int count){
            this.node=node;
            this.wt=wt;
            this.count=count;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int []>> list=new ArrayList<>();
       
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
          
list.get(u).add(new int[]{v,wt});
        }
        int dist[][]=new int[n][k+1];
        final int INF=(int) 1e9;
        for(int i=0;i<dist.length;i++){
            for(int j=0;j<dist[0].length;j++){
                dist[i][j]=INF;
            }
        }
        dist[0][1]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.wt,b.wt));
        pq.offer(new Pair(0,0,1));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int u=p.node;
            int weight=p.wt;
            int c=p.count;
           
           if(weight!=dist[u][c]) continue;
            if(u==n-1) {
                return weight;
               
            }

            for(int edge[]:list.get(u)){
                int v=edge[0];
                int w=edge[1];
                int newCount;
                if(labels.charAt(u)==labels.charAt(v)){
                    newCount=c+1;
                }
                else{
                    newCount=1;
                }
                if(newCount>k) continue;
                int newWeight=weight+w;
                if(newWeight<dist[v][newCount]){
                    dist[v][newCount]=newWeight;
                    pq.offer(new Pair(v,newWeight,newCount));
                }
            }
 

        }
        return -1;
    }
}