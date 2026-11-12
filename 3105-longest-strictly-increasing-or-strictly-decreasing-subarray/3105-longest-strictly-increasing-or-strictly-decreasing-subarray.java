class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int left=0;
        int right=1;
        int n=nums.length;
        int sI=1;
        int sD=1;
        int maxi=1;
        for(int i=1;i<n;i++){
            if(nums[i-1]<nums[i]) {
                sD=1;
                sI++;

            }
           else if(nums[i-1]>nums[i]){
                sI=1;
                sD++;
            }
            else{
                sI=1;
                sD=1;
            }
            
maxi=Math.max(maxi,Math.max(sI,sD));

        }
        return maxi;
    }
}