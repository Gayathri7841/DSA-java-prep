class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums)sum=sum+num;
       
        int mid=n/2;
        int left[]=new int[mid];
        int right[]=new int[n-mid];
        for(int i=0;i<mid;i++){
            left[i]=nums[i];
        }
        int index=0;
        for(int i=mid;i<n;i++){
right[index++]=nums[i];
        }

        List<int[]> leftSubset=generate(left);
        List<int[]> rightSubset=generate(right);
        HashSet<Integer> set = new HashSet<>();

for(int r[] : rightSubset) {
    set.add(r[0] * 100000 + r[1]);
}
for(int k=1;k<=mid;k++){
    if ((k * sum) % n != 0) {
    continue;
}
    int requiredSum=(k * sum) / n;
    for(int l[]:leftSubset){
        int leftCount=l[0];
        int leftSum=l[1];
        int rightCount=k-leftCount;
        int rightSum=requiredSum-leftSum;
       if(set.contains(rightCount * 100000 + rightSum)) {
    return true;
}
    }
}
return false;
    }
private List<int[]> generate(int arr[]){
    List<int[]> res=new ArrayList<>();
    dfs(arr,0,0,0,res);
    return res;
}
private void dfs(int[] arr,int i, int count, int sum,List<int[]> res){
    if(i==arr.length){
        res.add(new int[]{count,sum});
        return;
    }
    dfs(arr,i+1,count+1,sum+arr[i],res);
     dfs(arr,i+1,count,sum,res);

}
}