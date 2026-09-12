class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n=nums.length;
        int count=0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
if(map.containsKey(nums[i])){
    map.get(nums[i]).add(i);
}else{
    List<Integer> list=new ArrayList<>();
    list.add(i);
    map.put(nums[i],list);
}
        }
        for(int num:map.keySet()){
            List<Integer> list=map.get(num);
            if(list.size()!=3) continue;
          int diff=list.get(1)-list.get(0);
          int size=list.size();
           boolean flag=true;
        if(list.get(1)-list.get(0)==list.get(2)-list.get(1)) count++;
        }
        return count;
    }
}