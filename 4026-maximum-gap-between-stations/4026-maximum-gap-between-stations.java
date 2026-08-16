class Solution {
    public int maximumGap(String skill, String station) {
        int n=skill.length();
        int m=station.length();
        if(n==1||m==1) return 0;
        int left[]=new int[n];
        int right[]=new int[n];
        int p1=0;
        int p2=0;
        int index=0;
        
        while(p1<n&&p2<m){
            char c=skill.charAt(p1);
            char ch=station.charAt(p2);
            if(c==ch){
left[index++]=p2;
p1++;
p2++;
            }else{
                p2++;
            }
        }
       p1=n-1;
       p2=m-1;
       index=n-1;
while(p1>=0&&p2>=0){
            char c=skill.charAt(p1);
            char ch=station.charAt(p2);
            if(c==ch){
right[index--]=p2;
p1--;
p2--;
            }else{
                p2--;
            }
        }
        int max=Integer.MIN_VALUE;
int p=0;
int q=p+1;
while(p<n&&q<n){
    max=Math.max(max,Math.abs(left[p]-right[q]));
    p++;
    q++;
}
return max;
    }
}