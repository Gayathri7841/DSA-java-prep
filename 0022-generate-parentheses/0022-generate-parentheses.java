class Solution {
    List<String> res=new ArrayList<>();
    int N;

    public List<String> generateParenthesis(int n) {
        N=n;
        fn("",0,0,0);
        return res;
    }
    public void fn(String temp,int oc,int cc,int size){
        if(size==N*2&&oc==cc){
            res.add(temp);
            return ;
        }
        if(oc<N){
          fn(temp+'(',oc+1,cc,size+1);
        }
        if(cc<oc){
            fn(temp+')',oc,cc+1,size+1);
        }
      
    }
}