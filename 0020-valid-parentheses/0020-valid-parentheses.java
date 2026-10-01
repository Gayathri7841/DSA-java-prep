class Solution {
    public boolean isValid(String s) {
        int n=s.length();
          if (n % 2 != 0) return false;
     
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='['||ch=='{'){
                st.push(ch);
            }else {
                if(st.isEmpty()) return false;
                   char c=st.pop();
           
               if(c=='('&&ch!=')'||c=='['&&ch!=']'||c=='{'&&ch!='}') 
               return false;
                
            
        }
        }

        return st.isEmpty();
    }
}