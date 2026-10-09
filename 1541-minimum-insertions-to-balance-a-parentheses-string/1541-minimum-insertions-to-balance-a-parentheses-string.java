class Solution {
    public int minInsertions(String s) {
       int open=0;
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') open++;
            else{
               if(i+1<n&&s.charAt(i+1)==')'){
                i++;
               }else{
                count++;
               }
               if(open>0){
                open--;
               }else{
                count++;
               }

}
        }
        
            count=count+open*2;
        
        return count;
    }

}