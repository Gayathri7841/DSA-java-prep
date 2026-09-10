class Solution {
    public int countRotations(String s, int k) {
        int n=s.length();
        int count=0;
        int res=0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)) count++;
        }
        if(count==k) res++;
        for(int i=0;i<n-1;i++){
             int score = count; 
            if(s.charAt(i)==s.charAt(i+1)) score--;
            if(s.charAt(0)==s.charAt(n-1)) score++;
if(score==k) res++;
        }
        return res;
    }
}