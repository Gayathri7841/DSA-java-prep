class Solution {
    public int minInsertions(String s) {
        Stack<Character> st=new Stack<>();
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') st.push(ch);
            else{
               if(i+1<n&&s.charAt(i+1)==')'){
                i++;
               }else{
                count++;
               }
               if(!st.isEmpty()){
                st.pop();
               }else{
                count++;
               }

}
        }
        
            count=count+(st.size()*2);
        
        return count;
    }

}