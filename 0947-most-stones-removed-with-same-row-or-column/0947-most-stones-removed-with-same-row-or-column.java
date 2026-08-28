class Solution {
    int parent[];
    int size[];
    public int removeStones(int[][] stones) {
   int rows=0;
   int cols=0;
   for(int i=0;i<stones.length;i++){
   
        int val1=stones[i][0];
        int val2=stones[i][1];
    if(val1>rows) rows=val1;
    if(val2>cols) cols=val2;
   }
  int offset=rows+1;

   parent=new int[rows+cols+2];
   size=new int[rows+cols+2];

   for(int i=0;i<parent.length;i++){
    parent[i]=i;
    size[i]=1;
   }
   for(int i=0;i<stones.length;i++){
    int u=stones[i][0];
    int v=stones[i][1]+offset;
    disjoint(u,v);
   }
  Set<Integer> set = new HashSet<>();

for(int i=0;i<stones.length;i++){
    int u=stones[i][0];
    int v=stones[i][1]+offset;

    set.add(getParent(u));
    set.add(getParent(v));
}

int components=set.size();

return stones.length-components;
    }
    private void disjoint(int u,int v){
        int parentu=getParent(u);
        int parentv=getParent(v);
        if(parentu==parentv) return;
        int sizeu=size[parentu];
        int sizev=size[parentv];
        if(sizev>sizeu){
            parent[parentv]=parentu;
            size[parentu]+=size[parentv];
        }else if(sizev<sizeu){
        parent[parentu]=parentv;
            size[parentv]+=size[parentu];
        }else{
            parent[parentv]=parentu;
            size[parentu]+=size[parentv]; 
        }
    }
    private int getParent(int node){
        if(parent[node]==node) return node;
        int par=getParent(parent[node]);
        parent[node]=par;
        return parent[node];
    }
}