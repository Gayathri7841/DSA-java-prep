class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        HashMap<Character,int[]> map=new HashMap<>();
        int n=s.length();
        // map creation to store intervals
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,new int[]{i,i});
            }else{
               int arr[]= map.get(c);
               int start=arr[0];
               int end=i;
               arr[0]=start;
               arr[1]=end;
               map.put(c,arr);
            }
        }



List<int[]> intervals=new ArrayList<>();
for(char ch:map.keySet()){
    int arr[]=map.get(ch);
    int start=arr[0];
    int end=arr[1];
    boolean valid=true;
    
    for(int i=start;i<=end;i++){
        char c=s.charAt(i);
        int a[]=map.get(c);
        int start1=a[0];
        int end1=a[1];
if(start1<start){
    valid=false;
    break;
}
if(end<end1){
    end=end1;
}
    }
    if(valid) {
           intervals.add(new int[]{start,end});

    }
}
intervals.sort((a,b)->Integer.compare(a[1],b[1]));
List<String> list=new ArrayList<>();
int prevEnd=-1;
for(int[] interval:intervals){
    int start=interval[0];
    int end=interval[1];
    if(start>prevEnd){
        list.add(s.substring(start,end+1));
        prevEnd=end;
    }
}

return list;
    }
}