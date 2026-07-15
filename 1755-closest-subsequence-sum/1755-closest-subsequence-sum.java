class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n=nums.length/2;
        int leftnums[]=Arrays.copyOfRange(nums,0,n);
        int rightnums[]=Arrays.copyOfRange(nums,n,nums.length);
        List<Integer> leftsum=new ArrayList<>();
          List<Integer> rightsum=new ArrayList<>();
          generate(0,0,leftnums,leftsum);
          generate(0,0,rightnums,rightsum);
          Collections.sort(rightsum);
          int ans=Integer.MAX_VALUE;
for(int i=0;i<leftsum.size();i++){
    int target=goal-leftsum.get(i);
    int index=lowerBound(rightsum,target);
    if(index<rightsum.size()){
                    int choosen=leftsum.get(i)+rightsum.get(index);
                    ans=Math.min(ans,Math.abs(choosen-goal));
                }if(index>0){
                    int choosen=leftsum.get(i)+rightsum.get(index-1);
                    ans=Math.min(ans,Math.abs(choosen-goal));
                }

}
return ans;
    }
    private void generate(int index,int sum,int arr[],List<Integer> list){
        if(index==arr.length){
            list.add(sum);
            return;
        }
        generate(index+1,sum,arr,list);
        generate(index+1,sum+arr[index],arr,list);
    }
      private int lowerBound(List<Integer> list,int target){
        int low=0;
        int high=list.size()-1;
        int ans=list.size();
        while(low<=high){
            int mid=low+(high-low)/2;
            if(list.get(mid)>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}