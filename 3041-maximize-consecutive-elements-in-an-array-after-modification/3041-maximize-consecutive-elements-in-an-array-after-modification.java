class Solution {
    Integer dp[][];
    public int maxSelectedElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int result=1;
        dp=new Integer[n+1][2];
        for(int i=0;i<n;i++){
        result=Math.max(result,Math.max(fn(i,0,nums),fn(i,1,nums)));
        }
        return result;
    }
    private int fn(int i,int inc,int[] nums){
        if(dp[i][inc]!=null) return dp[i][inc];
        int curr=nums[i]+inc;
        int len=1;
        int j=find(nums,i+1,curr+1);
        if(j!=-1) {
            len=Math.max(len,1+fn(j,0,nums));
        }
        j=find(nums,i+1,curr);
        if(j!=-1) {
            len=Math.max(len,1+fn(j,1,nums));
        }
return dp[i][inc]=len;
    }
    private int  find(int nums[],int start,int target){

int left=start;
int right=nums.length-1;
int ans=-1;
while(left<=right){
    int mid=left+(right-left)/2;
    if(nums[mid]>=target){
        if(nums[mid]==target) ans=mid;
        right=mid-1;
    }
    else{
left=mid+1;
    }

}
return ans;
    }

}