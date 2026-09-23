class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int total=0;
        for(int num:nums)total+=num;
        int k=total-x;
       if(k<0) return -1;
       if(k==0) return n;
        int left=0;
        int right=0;
        int sum=0;
int maxi=Integer.MIN_VALUE;
        while(right<n){
sum+=nums[right];
while(sum>k){
    sum-=nums[left++];
}

if(sum==k){
maxi=Math.max(maxi,right-left+1);

}
right++;
        }

       if(maxi == Integer.MIN_VALUE)
    return -1;

return n - maxi;
    }
}