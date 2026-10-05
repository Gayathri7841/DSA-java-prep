class Solution {
    public int scoreOfParentheses(String s) {
     Stack<Integer> st=new Stack<>();
     int res=0;
     for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
        if(ch=='('){
st.push(res);
res=0;
        }else{
            res=st.pop()+Math.max(res*2,1);
        }
     }
     return res;   
    }
}