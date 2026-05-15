class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        long max=0,sum=0;
        for(int i=0;i<k;i++){
map.put(nums[i],map.getOrDefault(nums[i],0)+1);
  sum=sum+val;
        }
        if(map.size()==k){

              
            
            max=Math.max(max,sum);
        }
if(k==n){
    return max;
}
int left=1;
int right=k;
while(right<n){
  
   int remove=nums[left-1];
   if(map.containsKey(remove)){
    map.put(remove,map.get(remove)-1);
    if(map.get(remove)==0) map.remove(remove);
   }
    map.put(nums[right],map.getOrDefault(nums[right],0)+1);
   sum=sum-remove;
   sum=sum+nums[right];
   if(map.size()==k){
    max=Math.max(max,sum);
   }
    left++;
    right++; 


}
return max;
    }
}
