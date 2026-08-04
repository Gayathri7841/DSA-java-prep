class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res[]=new int[numCourses];
        int index=0;
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
res[index++]=node;
        for(int adjNode:adj[node]){
            indegree[adjNode]--;
            if( indegree[adjNode]==0) q.offer(adjNode);
        }
         
     }
  if(count!=numCourses) return new int[0];
  return res;
    }
}