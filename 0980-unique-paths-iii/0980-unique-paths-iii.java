class Solution {
    int count=0;
    public int uniquePathsIII(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) count++;
            }
        }
int index1=0,index2=0;
        for(int i=0;i<grid.length;i++){
             for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                   index1=i;
                   index2=j; 
            } 
        }
   
      
    }
     return fn(index1,index2,grid,-1);
    }
    public int fn(int i,int j,int[][] grid,int steps){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==3||grid[i][j]==-1){
            return 0;
        }if(grid[i][j]==2) {
            if(steps==count) return 1;
            return 0;
        }
        
        
      
        int original=grid[i][j];
        grid[i][j]=3;
       int left= fn(i,j-1,grid,steps+1);
       int right= fn(i,j+1,grid,steps+1);
       int up= fn(i-1,j,grid,steps+1);
      int down=  fn(i+1,j,grid,steps+1);
        grid[i][j]=original;
        return left+right+up+down;
    }
}