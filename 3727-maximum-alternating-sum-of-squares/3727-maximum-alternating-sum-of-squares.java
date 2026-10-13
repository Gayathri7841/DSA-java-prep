class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                nums[i]=-(nums[i]);
            }
        }
        Arrays.sort(nums);
        int arr[]=new int[n];
        int left=0;
        int right=n-1;
        int index=0;
        while(left<=right){
            if(index%2==0){
arr[index++]=nums[right--];

            }else{
arr[index++]=nums[left++];
            }
        }
        long ans=0;
        for(int i=0;i<n;i++){
            if(i%2!=0){
                ans=ans-(arr[i]*arr[i]);
            }else{
                ans=ans+(arr[i]*arr[i]);
            }
        }
        return ans;
    }
}