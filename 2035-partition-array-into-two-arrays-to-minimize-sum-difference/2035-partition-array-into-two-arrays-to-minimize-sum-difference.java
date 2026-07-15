class Solution {
    public int minimumDifference(int[] nums) {
        // step1-partition the array into 2 halves
        int n=nums.length/2;
        int leftnums[]=Arrays.copyOfRange(nums,0,n);
        int rightnums[]=Arrays.copyOfRange(nums,n,nums.length);
        //step 2-Generate all possible subset for both the arrays
        List<Integer> left[]=new ArrayList[n+1];
        List<Integer> right[]=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            left[i]=new ArrayList<>();
            right[i]=new ArrayList<>();

        }
        generate(leftnums,0,0,0,left);
        generate(rightnums,0,0,0,right);
        // step-3 to find out the min sum difference
        int ans=Integer.MAX_VALUE;
        int total=0;
        for(int num:nums) total+=num;
        for(int i=0;i<=n;i++) Collections.sort(right[i]);
        for(int leftsize=0;leftsize<=n;leftsize++){
            List<Integer> L=left[leftsize];
            List<Integer> R= right[n-leftsize];
            for(int leftnum:L){
                double target=total/2.0-leftnum;
                int indx=lowerBound(R,target);
                if(indx<R.size()){
                    int choosen=leftnum+R.get(indx);
                    ans=Math.min(ans,Math.abs(total-2*choosen));
                }if(indx>0){
                    int choosen=leftnum+R.get(indx-1);
                    ans=Math.min(ans,Math.abs(total-2*choosen));
                }
            }
        }
return ans;
    }
    private void generate(int[] arr,int index,int count,int sum,List<Integer>[] lists){
        if(index==arr.length){
            lists[count].add(sum);
            return;
        }
        generate(arr,index+1,count,sum,lists);
        generate(arr,index+1,count+1,sum+arr[index],lists);
    }
    private int lowerBound(List<Integer> list,double target){
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