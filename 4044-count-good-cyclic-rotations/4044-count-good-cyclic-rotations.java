class Solution {
    public int countGoodRotations(int[] nums) {
        int n=nums.length;
        long sum=0;
        int count=0;
        for(int num:nums) sum=sum+num;

        int arr[]=new int[n*2];
        for(int i = 0; i < n * 2; i++){
    arr[i] = nums[i % n];
}
        int mid=n/2;
        long lsum=0;
        for(int i=0;i<mid;i++) lsum=lsum+nums[i];
        long rsum=sum-lsum;
          if(lsum>rsum) count++;
        for(int i=0;i<n-1;i++){
             lsum=lsum-arr[i]+arr[i+mid];
             rsum=sum-lsum;
            if(lsum>rsum) count++;

        }
        return count;
    }
}