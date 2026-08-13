class Solution {
    int[][] graph;
    Set<Integer> res=new HashSet<>();
      boolean visited[];
       boolean path[];
    public List<Integer> eventualSafeNodes(int[][] graph) {
     this.graph=graph;
    visited =new boolean[graph.length];
    path=new boolean[graph.length];
       for(int i=0;i<visited.length;i++){
        if(!visited[i]){
         boolean b=   dfs(i);
        }
       }
     
       List<Integer> result=new ArrayList<>(res);
         Collections.sort(result);
       return result;
        
    }
    private boolean dfs(int node){
          if(path[node]) {
         
          return false;
          
          }
          if(visited[node]){
         if(res.contains(node)){
            return true;
          }
          return false;
          }
        visited[node]=true;
        path[node]=true;
        int n=graph[node].length;
        if(n==0) {
            res.add(node);
            path[node]=false;
        return true;
        }
      
        for(int i=0;i<n;i++){
            if(!dfs(graph[node][i]))
            {
               
             return false;
            }
        }
        path[node]=false;
        res.add(node);
        return true;
    }
}