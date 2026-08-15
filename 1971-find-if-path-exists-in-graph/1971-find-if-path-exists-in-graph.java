class Solution {
    boolean visited[];
     List<Integer> adj[];
     int target;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        target=destination;
       adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
adj[u].add(v);
adj[v].add(u);
        }
        visited=new boolean[n];
        return dfs(source);
    }
    private boolean dfs(int i){
        if(i==target) return true;
        if(visited[i]) return false;
        visited[i]=true;

        for(int num:adj[i]){
            if(dfs(num)) return true;
        }
        return false;
    }
}