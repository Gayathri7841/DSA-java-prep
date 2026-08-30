class Solution {
    class Pair{
        int number;
        int operations;
        Pair(int number,int operations){
            this.number=number;
            this.operations=operations;
        }
    }
    public int minOperations(int[] nums, int sum) {
        int n=nums.length;
        int dp[]=new int[sum+1];
        final int INF=Integer.MAX_VALUE;
        Arrays.fill(dp,INF);
        dp[0]=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            List<Pair> list=new ArrayList<>();
            int ops=0;
            while(num<=sum){
                list.add(new Pair(num,ops));
                num=num*2;
                ops++;
            }
            num=nums[i];
            ops=0;
            while(num>=1){
                if(num<=sum)list.add(new Pair(num,ops));
                num=num/2;
                ops++;
            }
int clonee[]=dp.clone();
for(Pair p:list){
    int sum1=p.number;
    int opss=p.operations;
for(int k=0;k<clonee.length;k++){
    if(clonee[k]!=INF){
int s=k;
int o=clonee[k];
if(s+sum1<clonee.length){
dp[s+sum1]=Math.min(dp[s+sum1],clonee[k]+opss);
}
    }
}
}

        }
        if(dp[sum]==INF) return -1;
        return dp[sum];
    }
}