class Solution {
    public int minOperations(String s) {
        int n=s.length();
        int ans=Integer.MAX_VALUE;
        for(int r=0;r<n;r++){
            int cost=r;
            for(int i=0;i<n/2;i++){
                char left=s.charAt((i+r)%n);
                char right=s.charAt((n-1-i+r)%n);
                int f1=(right-left+26)%26;
                int f2=(left-right+26)%26;
                cost+=Math.min(f1,f2);
            }
            ans=Math.min(ans,cost);
        }
        return ans;
    }
}