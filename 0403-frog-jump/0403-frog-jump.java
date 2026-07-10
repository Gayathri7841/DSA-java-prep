class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    public boolean canCross(int[] stones) {
        int n=stones.length;
        Boolean dp[][]=new Boolean[n][n+1];//?
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
    return dfs(0,0,dp,stones);
    }
    public boolean dfs(int i,int jump,Boolean dp[][],int[] stones){
    if(i==stones.length-1) return true;
      if(dp[i][jump]!=null) return dp[i][jump];
    for(int nextjump=jump-1;nextjump<=jump+1;nextjump++){
        if(nextjump<=0) continue;
        int nextpos=stones[i]+nextjump;
        if(map.containsKey(nextpos)){
            int nextIndex=map.get(nextpos);
        if(dfs(nextIndex,nextjump,dp,stones)){
          return  dp[i][jump]=true;
        }
        }
    }
    return dp[i][jump]=false;
    }
}