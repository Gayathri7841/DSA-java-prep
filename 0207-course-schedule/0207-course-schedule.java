class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> adj[]=new ArrayList[numCourses];
        for(int i=0;i<adj.length;i++) adj[i]=new ArrayList<>();
for(int i=0;i< prerequisites.length;i++){
       
adj[prerequisites[i][1]].add(prerequisites[i][0]);
        
}
        int indegree[]=new int[numCourses];
      for(int i=0;i<adj.length;i++){
        for(int num:adj[i]){
            indegree[num]++;
        }
      }
      int count=0;
      Queue<Integer> q=new LinkedList<>();
     for(int i=0;i<indegree.length;i++){
        if(indegree[i]==0) q.offer(i);
     }
     while(!q.isEmpty()){
        int node=q.poll();
        count++;
        for(int adjNode:adj[node]){
            indegree[adjNode]--;
            if( indegree[adjNode]==0) q.offer(adjNode);
        }
         
     }
     if(count!= numCourses) return false;
     return true;
    }
}