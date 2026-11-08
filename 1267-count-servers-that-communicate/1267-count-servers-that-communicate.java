class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int colindex[]=new int[m];
        int rowindex[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    colindex[j]++;
                    rowindex[i]++;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    if(colindex[j]>1||rowindex[i]>1){
                        count=count+1;
                    }
                }
            }
        }
        return count;

    }
}