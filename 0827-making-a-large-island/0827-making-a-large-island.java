class Solution {
    int parent[];
    int size[];
    public int largestIsland(int[][] grid) {
      int n=grid.length;
      int m=grid[0].length;
      int count=0;
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==1) count++;
        }
      }
      if(count==m*n) return count;
      parent=new int[n*m];
      size=new int[n*m];
      for(int i=0;i<n*m;i++){
        parent[i]=i;
        size[i]=1;
      }
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==0) continue;
            if(j-1>=0&&grid[i][j-1]==1){
                disjoint(i*m+j,i*m+(j-1));
            }
            if(j+1<m&&grid[i][j+1]==1){
                disjoint(i*m+j,i*m+(j+1));
            }
            if(i-1>=0&&grid[i-1][j]==1){
                disjoint(i*m+j,(i-1)*m+j);
            }
            if(i+1<n&&grid[i+1][j]==1){
                disjoint(i*m+j,(i+1)*m+j);
            }

        }
      }
    
      int max=Integer.MIN_VALUE;
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
           int size1=0,size2=0,size3=0,size4=0;
            if(grid[i][j]==0){
                  Set<Integer> set=new HashSet<>();
               if(j-1>=0&&grid[i][j-1]==1&&!set.contains(getParent(i*m+(j-1)))){
                int parent=getParent(i*m+(j-1));
                 size1=size[parent];
                set.add(parent);
            }
            if(j+1<m&&grid[i][j+1]==1&&!set.contains(getParent(i*m+(j+1)))){

  int parent=getParent(i*m+(j+1));
                 size2=size[parent];
                set.add(parent);
               
            }

            if(i-1>=0&&grid[i-1][j]==1&&!set.contains(getParent((i-1)*m+j))){
                 int parent=getParent((i-1)*m+j);
                 size3=size[parent];
                set.add(parent);
               
            }
            if(i+1<n&&grid[i+1][j]==1&&!set.contains(getParent((i+1)*m+j))){
                 int parent=getParent((i+1)*m+j);
                 size4=size[parent];
                set.add(parent);
               
            }  
max=Math.max(max,size1+size2+size3+size4+1);
            }
        }
      }
      return max;  
    }
    private void disjoint(int u,int v){
        int parentu=getParent(u);
        int parentv=getParent(v);
        if(parentu==parentv) return;
        int sizeu=size[parentu];
        int sizev=size[parentv];
       if(sizev > sizeu){
    parent[parentu] = parentv;
    size[parentv] += size[parentu];
}
else if(sizev < sizeu){
    parent[parentv] = parentu;
    size[parentu] += size[parentv];
}
else{
    parent[parentv] = parentu;
    size[parentu] += size[parentv];
}
    }
    private int getParent(int node){
        if(parent[node]==node) return node;
        int par=getParent(parent[node]);
        parent[node]=par;
        return parent[node];
    }
}
