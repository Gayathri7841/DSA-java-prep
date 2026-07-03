class Solution {
     List<List<Integer>> res=new ArrayList<>();
    int k;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        k=target;
        List<Integer> list=new ArrayList<>();
        Arrays.sort(candidates);
        fn(list,candidates,0,0);
        return res;
    }
    public void fn(List<Integer> list ,int nums[],int sum,int i){
   
        if(sum==k){
res.add(new ArrayList<>(list));
return;
        }
        
    
    if(sum>k) return;
   
   for(int k=i;k<nums.length;k++){
    if(i<k&&nums[k-1]==nums[k]){
    continue;
    }else{
      
          list.add(nums[k]);
    fn(list,nums,sum+nums[k],k+1);
     list.remove(list.size()-1);
   
    }
   }  
  
   
}
}