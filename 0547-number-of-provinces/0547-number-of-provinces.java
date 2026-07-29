class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean visited[]=new boolean[isConnected[0].length];
       for(int start=0;start<visited.length;start++){
      
        if(!visited[start]){
              Queue<Integer> q=new ArrayDeque<>();
            visited[start]=true;
q.offer(start);
while(!q.isEmpty()){
    int node=q.poll();
    
    for(int j=0;j<isConnected.length;j++){
        if(isConnected[node][j]==1&&!visited[j]){
            visited[j]=true;
            q.offer(j);

        }
    }
}
count++;
        }
       }
        return count;
    }
}