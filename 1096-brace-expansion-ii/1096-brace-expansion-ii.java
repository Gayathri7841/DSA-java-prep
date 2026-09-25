class Solution {
     Stack<List<String>> st=new Stack<>();
         Stack<Character> operator=new Stack<>();
         private void compute(){
            int x=st.size()-2;
            int y=st.size()-1;
            List<String> left=st.get(x);
            List<String> right=st.get(y);
            if(operator.peek()=='+'){
                left.addAll(right);
            }
            else{
                List<String> next=new ArrayList<>();
                for(String l:left){
                    for(String r:right){
                        next.add(l+r);
                    }
                }
                st.set(x,next);
            }
            operator.pop();
            st.pop();
         }
    public List<String> braceExpansionII(String expression) {
    
    int n=expression.length();
    char prev='@';
    char curr=0;
         for(int i=0;i<n;i++){
          curr=expression.charAt(i);
          if(curr==','){
            while(!operator.isEmpty()&&operator.peek()!='{'){
                compute();
            }
            operator.push('+');
            
          }else if(curr=='{'){
            if(prev=='}'||Character.isLetter(prev)){
                operator.push('*');
            }
            operator.push('{');
          }
          else if(curr=='}'){
            while(!operator.isEmpty()&&operator.peek()!='{'){
                compute();
            }
            operator.pop();
          }else{
            if(prev=='}') {
                operator.push('*');
            }
            StringBuilder sb=new StringBuilder();
            while(i<n&&Character.isLetter(expression.charAt(i))){
                sb.append(expression.charAt(i));
                i++;
            }
List<String> s=new ArrayList<>();
s.add(sb.toString());
st.push(s);
i--;
          }
prev=curr;
         }
         while(!operator.isEmpty()){
            compute();
         }
         List<String> ans=st.peek();
         Collections.sort(ans);
         List<String> result=new ArrayList<>();
         for(String word:ans){
            if(result.isEmpty()||!result.get(result.size()-1).equals(word)){
                result.add(word);
            }
         }
return result;

       
     
    }
}