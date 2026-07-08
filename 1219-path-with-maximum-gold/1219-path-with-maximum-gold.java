class Solution {
    public int getMaximumGold(int[][] grid) {
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                int sum= fn(i,j,grid);
                maxsum=Math.max(maxsum,sum);
                }
            }
        }
        if(maxsum==Integer.MIN_VALUE) return 0;
        return maxsum;

    }
    public int fn(int i,int j,int grid[][]){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||grid[i][j]==-1) return 0;
int sum=grid[i][j];
int original=grid[i][j];
grid[i][j]=-1;
int left=fn(i,j+1,grid);
int right=fn(i,j-1,grid);
int top=fn(i-1,j,grid);
int bottom=fn(i+1,j,grid);
grid[i][j]=original;
int max=Integer.MIN_VALUE;
max=Math.max(max,sum+left);
max=Math.max(max,sum+right);
max=Math.max(max,sum+top);
max=Math.max(max,sum+bottom);
return max;
    }
}