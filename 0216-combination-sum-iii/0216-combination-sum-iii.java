class Solution {
    List<List<Integer>> res=new ArrayList<>();
    int K,N;
    public List<List<Integer>> combinationSum3(int k, int n) {
        K=k;
        N=n;
        List<Integer> list=new ArrayList<>();
        fn(1,0,list);
        return res;
    }
    public void fn(int index,int sum,List<Integer> list){
       if(list.size()==K){
        if(sum==N){
            res.add(new ArrayList<>(list));
        }
        return;
       }
       for(int i=index;i<=9;i++){
        list.add(i);
        fn(i+1,sum+i,list);
        list.remove(list.size()-1);
       
       }

    }
}