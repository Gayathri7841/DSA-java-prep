class Solution {
    public int countRotations(String s, int k) {
        int count=0;
        int n=s.length();
        int sc=0;
        for(int i=0;i<n-1;i++){
            
            if(s.charAt(i)==s.charAt(i+1)) {
                sc++;
               }
                
        }
        if(sc==k) count++;
        for(int i=0;i<n-1;i++){
            int score=0;
StringBuilder sb=new StringBuilder();
sb.append(s.substring(i+1,n));
sb.append(s.substring(0,i+1));
 for(int j=0;j<n-1;j++){
            
            if(sb.charAt(j)==sb.charAt(j+1)) {
                score++;
               
            }
        }
         if(score==k) count++;
        }
        return count;
    }
}