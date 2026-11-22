class Solution {
    public boolean checkString(String s) {
        int n=s.length();
        boolean bstarted=false;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
if(ch=='b') bstarted=true;
else{
    if(bstarted&&ch=='a') return false;
}
        }
        return true;
    }
}