class Solution {
      boolean visited[];
        int color[];
        int[][] graph;
    public boolean isBipartite(int[][] graph) {
        this.graph=graph;
      visited=new boolean[graph.length];
      color=new int[graph.length];
for(int i=0;i<visited.length;i++){
    if(!visited[i]){
        if(!dfs(i,0)) return false;
    }
  
}
return true;
    }
    public boolean dfs(int src,int c){
visited[src]=true;
color[src]=c;
for(int row:graph[src]){
    if(!visited[row]){
   if(c==0){
    if(!dfs(row,1)) return false;
   }else{
    if(!dfs(row,0)) return false;
   }
    }else{
        if(color[row]==color[src]) return false;
    }
}
return true;
    }
}