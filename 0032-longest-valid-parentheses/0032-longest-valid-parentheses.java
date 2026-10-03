class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty()&&s.charAt(i)==')'&&s.charAt(st.peek())=='(')
            st.pop();
            else
            st.push(i);
        }
        int index=-1;
        int max=Integer.MIN_VALUE;
        for(int val:st){
            max=Math.max(max,val-index-1);
            index=val;
        }
        max=Math.max(max,s.length()-index-1);
        return max;
    }
}