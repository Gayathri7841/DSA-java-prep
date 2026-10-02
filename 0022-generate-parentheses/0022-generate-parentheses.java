class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        fn(0,0,res,n,"");
        return res;
    }
    public void fn(int open,int close,List<String> res,int n,String temp){
        if(temp.length()==n*2){
            res.add(temp);
            return;
        }
        if(open<n){
            
            fn(open+1,close,res,n,temp+"(");
        }
        if(close<open){
           
            fn(open,close+1,res,n,temp+")");
        }
    }
}