class Solution {
    public int maxValidSplits(int[] nums) {
        int n=nums.length;
int res=split(nums);
        for(int i=0;i<n;i++){
            int arr[]=new int[n-1];
            int index=0;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                 arr[index++]=nums[j];

            }
            res=Math.max(res,split(arr));
        }
        return res;
    }
    private int split(int arr[]){
        int n=arr.length;
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        int count=0;
        prefix[0]=arr[0];
        for(int i=1;i<n;i++){
            prefix[i]=gcd(prefix[i-1],arr[i]);
        }
        suffix[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=gcd(suffix[i+1],arr[i]);
        }
        for(int i=0;i<n-1;i++){
            
            if(prefix[i]==suffix[i+1]) count++;
        }
        return count;
    }
     private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}