class Solution {
public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
          List<Integer> res=new ArrayList<>();
      List<Integer> adj[]=new ArrayList[n];
        for(int i=0;i<adj.length;i++) adj[i]=new ArrayList<>();
        for(int i=0;i<invocations.length;i++){
            adj[invocations[i][0]].add(invocations[i][1]);

        }
         boolean suspicious[]=new boolean[n];
suspicious[k]=true;
    
      Queue<Integer> q=new LinkedList<>();
q.offer(k);


    while(!q.isEmpty()){
        int node=q.poll();

       
        for(int num:adj[node]){
           
            if(!suspicious[num]){
                q.offer(num);
                suspicious[num]=true;
            }
           
        }
    }
    for(int edge[]:invocations){
        int u=edge[0];
        int v=edge[1];
        if(!suspicious[u]&&suspicious[v]){
            for(int i=0;i<n;i++){
                res.add(i);
             
            }
            return res;
         }
     

    }
      for(int i=0;i<n;i++){
        if(!suspicious[i]) res.add(i);
       }
return res;
        }
    

}