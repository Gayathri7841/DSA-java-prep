class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int ops=-1;
        for(int i=0;i<n;i++){
            if(nums[i]!=i) ops=ops&nums[i];
        }
        return ops==-1?0:ops;

    }
}