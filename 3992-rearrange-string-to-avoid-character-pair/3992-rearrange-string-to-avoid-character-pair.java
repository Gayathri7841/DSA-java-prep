class Solution {
    public String rearrangeString(String s, char x, char y) {
       
        int ycount=0;
       
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==y) ycount++;
           
            
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ycount;i++){
            sb.append(y);
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=y){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}