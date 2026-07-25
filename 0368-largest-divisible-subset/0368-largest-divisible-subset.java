class Solution {
     int[] nums;
    Integer dp[][];
    int n;
    public List<Integer> largestDivisibleSubset(int[] nums) {
      Arrays.sort(nums);
       this. nums=nums;
n=nums.length;
dp=new Integer[n+1][n];
 int x=  fn(-1,0);
 List<Integer> res=new ArrayList<>();
 int prev=-1;
 int index=0;

 while(index<n){
    int notpick=(index+1<n)?(dp[prev+1][index+1]!=null?dp[prev+1][index+1]:0):0;
    int pick=0;
    if(prev==-1||nums[index]%nums[prev]==0){
       int next = (index + 1 < n) ? (dp[index + 1][index + 1] != null ? dp[index + 1][index + 1] : 0) : 0;
        pick = 1 + next;
    }
    if (pick > 0 && pick >= notpick && pick == dp[prev + 1][index]) {
                res.add(nums[index]);
                prev = index; // Update prev to current index
            }
            index++;
 }
 return res;
    }
   public int fn(int prev,int index){
        if(index==nums.length){
            return 0;
        }
        if(dp[prev+1][index]!=null) return dp[prev+1][index];
          int notpick=fn(prev,index+1);
          int pick=0;
        if(prev==-1||nums[index]%nums[prev]==0||nums[prev]%nums[index]==0){
pick=1+fn(index,index+1);
        }
           return dp[prev + 1][index] = Math.max(pick,notpick);
    }
}