class Solution {
     List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
          List<Integer> list=new ArrayList<>();
        fn(list,nums,0);
        return res;
    }
    public void fn(List<Integer> list ,int nums[],int i){
   
      res.add(new ArrayList<>(list));

 for(int k=i;k<nums.length;k++){
if(i<k&&nums[k]==nums[k-1]) continue;
    list.add(nums[k]);
    fn(list,nums,k+1);
    list.remove(list.size()-1);
   
 }
}
}