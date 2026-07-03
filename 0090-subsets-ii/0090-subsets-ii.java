class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
     List<Integer> list=new ArrayList<>();
     List<List<Integer>> res=new ArrayList<>();
     fn(nums,0,list,res);
     return res; 

    }
    public void fn(int arr[],int index,List<Integer> list,List<List<Integer>> res){
        
            res.add(new ArrayList<>(list));
          
for(int i=index;i<arr.length;i++){
    if(index<i&&arr[i]==arr[i-1]) continue;
    list.add(arr[i]);
   
    fn(arr,i+1,list,res);
    list.remove(list.size()-1);
}
    }
}