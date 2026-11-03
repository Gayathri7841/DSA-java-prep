class Solution {
    public int minMoves(int[] nums) {
       int maxi=Integer.MIN_VALUE;
        int moves=0;
        
for(int num:nums) maxi=Math.max(num,maxi);
for(int num:nums){
    moves=moves+(maxi-num);
}
return moves;
    }
}