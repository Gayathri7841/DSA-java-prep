class Solution {
    final int MOD=1_000_000_007;
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long ans=0;
        int left=0;
        int mid=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<a){
                left++;
            }
            else if(nums[i]<=b){
                ans+=left;
                mid++;
            }else{
                ans+=left;
                ans+=mid;
            }
        }
        return (int)(ans%MOD);
    }
}