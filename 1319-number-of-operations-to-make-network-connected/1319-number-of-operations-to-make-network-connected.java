class Solution {
    int count=0;
int parent[];
int size[];
    public int makeConnected(int n, int[][] connections) {
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
parent[i]=i;
size[i]=1;
        }
    for(int i=0;i<connections.length;i++){
        int u=connections[i][0];
        int v=connections[i][1];
        disjointSize(u,v);
    }
   int components=0;
   for(int i=0;i<n;i++){
    if(getParent(i)==i){
        components++;
    }
   }
if(count>=components-1){
    return components-1;
}
return -1;
}
public int getParent(int node){
if(parent[node]==node){
    return node;
}
int p=getParent(parent[node]);
parent[node]=p;
return parent[node];
}
public void disjointSize(int u,int v){
    int uParent=getParent(u);
    int vParent=getParent(v);
    if(uParent==vParent) {
    count++;
    return;
    }
    if(size[uParent]<size[vParent]) {
        size[vParent]=size[vParent]+size[uParent];
        parent[uParent]=vParent;
    }
    else if(size[uParent]>size[vParent]){
         size[uParent]=size[vParent]+size[uParent];
        parent[vParent]=uParent;
    }
    else{
        parent[vParent] = uParent;
    size[uParent] += size[vParent];
    }

}
}