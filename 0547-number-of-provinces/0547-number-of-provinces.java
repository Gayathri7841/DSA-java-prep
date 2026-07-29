class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean visited[]=new boolean[isConnected[0].length];
       for(int start=0;start<visited.length;start++){
        Queue<Integer> q=new LinkedList<>();
        if(!visited[start]){
q.offer(start);
while(!q.isEmpty()){
    int node=q.poll();
    visited[node]=true;
    for(int j=0;j<isConnected.length;j++){
        if(isConnected[node][j]==1&&!visited[j]){
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