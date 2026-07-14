class Solution {
    int points[];
    int n;
    Integer dp[];
    public int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
        }
        points=new int[max+1];
        n=points.length;
        Arrays.fill(points,0);
        for(int num:nums){
points[num]=points[num]+num;
        }
       dp=new Integer[n+1];
       return dfs(0); 
    }
      private int dfs(int index){
       
        if(index==n-1) return points[n-1];
        if(index>n-1) return 0;
        if(dp[index]!=null) return dp[index];
        int pick=points[index]+dfs(index+2);
        int notpick=dfs(index+1);
        return dp[index]=Math.max(pick,notpick);
    }
}