class Solution {
    public int minMoves(int[] nums) {
        int mini=Integer.MAX_VALUE;
        int moves=0;
        for(int num:nums)mini=Math.min(num,mini);
        for(int num:nums) moves=moves+(num-mini);
        return moves;
    }
}