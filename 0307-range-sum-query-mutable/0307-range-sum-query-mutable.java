class NumArray {
    int nums[];
int n;
 int BIT[];
    public NumArray(int[] nums) {
        this.nums=nums;
         n=nums.length;
       BIT=new int[n+1];
       for(int i=0;i<n;i++){
       init(i+1,nums[i]);
       }
    }
    public void init(int i,int val){
while(i<=n){
    BIT[i]=BIT[i]+val;

i=i+(i& (-i));
}
    }
    public void update(int index, int val) {
        int diff=val-nums[index];
        nums[index]=val;
        init(index+1,diff);

    }
    
    public int sumRange(int left, int right) {
        
        return sum(right+1)-sum(left);
    }
    public int sum(int index){
      
        int sum=0;
        while(index>0){
            sum+=BIT[index];
            index=index-(index & (-index));
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */