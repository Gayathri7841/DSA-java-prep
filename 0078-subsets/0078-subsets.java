class Solution {
       List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list=new ArrayList<>();
     
        fn(nums,0,list);
        return res;
    }
    public void fn(int arr[],int i,List<Integer> list){
      
            res.add(new ArrayList<>(list));
           
       
      for(int k=i;k<arr.length;k++){
        list.add(arr[k]);
        fn(arr,k+1,list);
        list.remove(list.size()-1);
      }
    
    }
}