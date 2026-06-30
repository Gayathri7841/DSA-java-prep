class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int len=s.length();
        
        int curr=map.get(s.charAt(len-1));
        int sum=curr;
        for(int i=len-2;i>=0;i--){
            int val=map.get(s.charAt(i));
if(curr>val){
    sum=sum-val;
}else{
    sum=sum+val;
}
curr=val;
        }
        return sum;
    }
}