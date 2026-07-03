//Brute Force using Backtracking
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    int k;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
k=target;
        List<Integer> list=new ArrayList<>();
        fn(list,candidates,0,0);
        return res;
    }
public void fn(List<Integer> list ,int nums[],int sum,int i){
    if(i==nums.length){
        if(sum==k){
res.add(new ArrayList<>(list));

        }
        return;
    }
    if(sum>k) return;
    list.add(nums[i]);
    fn(list,nums,sum+nums[i],i);
    list.remove(list.size()-1);
  
   
    fn(list,nums,sum,i+1);
}
}