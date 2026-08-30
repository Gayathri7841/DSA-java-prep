class Solution {
    public int countSpecialIntegers(int[] nums) {
       HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> notspecial=new HashSet<>();
        int left=0;
        int right=1;
        while(right<nums.length){
            if(nums[left]==nums[right]){
                right++;
            }else{
                if(set.contains(nums[left])){
                    set.remove(nums[left]);
                    notspecial.add(nums[left]);
                    
                }else if(!set.contains(nums[left])&&!notspecial.contains(nums[left])){
                    set.add(nums[left]);
                }
                left=right;
                right++;
            }
            
        }
        if(set.contains(nums[left])){
                    set.remove(nums[left]);
            notspecial.add(nums[left]);
                }else if(!set.contains(nums[left])&&!notspecial.contains(nums[left])){
                    set.add(nums[left]);
                }
        return set.size();
    }
}