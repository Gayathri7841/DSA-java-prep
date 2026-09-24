class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
if(i==fn(nums[i])){
    return i;
}
        }
        return -1;
    }
    private int fn(int num){
      
        int sum=0;
        while(num>0){
            int rem=num%10;
            sum=sum+rem;
            num=num/10;

        }
        return sum;
    }
}