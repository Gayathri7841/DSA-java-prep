class Solution {
    HashMap<Integer,Integer> map=new HashMap<>();
    private boolean isInvalid(int num){
        for(int a:map.keySet()){
            int b=num-a;
            int c=num+a;
            if (map.containsKey(b)) {
                if (b != a || map.get(a) >= 2) {
                    return true;
                }
            }
if (map.containsKey(c)) {
                return true;
            }
            
            }
            return false;

    }
    public int maxSubarray(int[] nums) {
        int n=nums.length;
        int l=0;
        int ans=0;
        int r=0;
        while(r<n){
            
                
            
while(l<r&&isInvalid(nums[r])){
    int number=nums[l];
    int count=map.get(number) - 1;
    if (count == 0) {
                    map.remove(number);
                } else {
                    map.put(number, count);
                }

    l++;
}
map.put(nums[r],map.getOrDefault(nums[r],0)+1);
ans=Math.max(ans,r-l+1);
r++;
            
        }
        return ans;
    }
}