class Solution {
    int min;
    String s;
    List<String> res=new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
       min=s.length();
       this.s=s;
       
       fn(0,"",0);
       return res;

    }
    private void fn(int i,String temp,int removed){
        if(removed>min) return;
        if(i==s.length()){
        if(isValid(temp)){
            if(removed<min){
         min=removed;
         res.clear();
         res.add(temp);
            }else if(removed==min){
                if(!res.contains(temp))res.add(temp);

            }
        }
        return;
        }
        char ch=s.charAt(i);
        fn(i+1,temp+ch,removed);
        if(ch=='('||ch==')'){
            fn(i+1,temp,removed+1);
        }
        
    }

    private boolean isValid(String s){

int balance=0;
for(char ch:s.toCharArray()){
    if(ch=='(') balance++;
    else if(ch==')') balance--;
    if(balance<0) return false;
}
return balance==0;
    }
}