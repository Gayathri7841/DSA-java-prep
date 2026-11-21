class Solution {
    int parent[];
    String s;
    int [] size;
    List<Integer> adj[];
    int seen[];
    public int[] findSubtreeSizes(int[] parent, String s) {
int n=parent.length;
this. parent=parent;
this.s=s;
size=new int[n];
adj=new ArrayList[n];
seen=new int[26];
Arrays.fill(size,1);
Arrays.fill(seen,-1);
for(int i=0;i<n;i++){
    adj[i]=new ArrayList<>();
}
for(int i=0;i<n;i++){
    if(parent[i]!=-1){
       
        adj[parent[i]].add(i);
    }
}
dfs(0);
return size;
}
private void dfs(int node){
   
    int i=s.charAt(node)-'a';
    int na=seen[i];
    if(na!=-1){
        parent[node]=na;
        }
        seen[i]=node;
        for(int child:adj[node]){
            dfs(child);
            int num=parent[child];
            size[num]+=size[child];
        }
        seen[i]=na;
       
}

}