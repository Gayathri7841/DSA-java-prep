class Solution {
    int[][] graph;
    
      boolean visited[];
       boolean path[];
       int[] safe;
    public List<Integer> eventualSafeNodes(int[][] graph) {
     this.graph=graph;
    visited =new boolean[graph.length];
    path=new boolean[graph.length];
    safe=new int[graph.length];
       for(int i=0;i<visited.length;i++){
        if(!visited[i]){
         boolean b=   dfs(i);
        }
       }
     
       List<Integer> result=new ArrayList<>();
        for(int i=0;i<safe.length;i++){
            if(safe[i]==1) result.add(i);
        }
        return result;
        
    }
    private boolean dfs(int node){
          if(path[node]) {
         
          return false;
          
          }
          if(visited[node]){
         if(safe[node]==1){
            return true;
          }
          return false;
          }
        visited[node]=true;
        path[node]=true;
        int n=graph[node].length;
        if(n==0) {
          safe[node]=1;
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
        safe[node]=1;
        return true;
    }
}