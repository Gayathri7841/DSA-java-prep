class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n=s.length();
        HashMap<String,String> map=new HashMap<>();
        for(int i=0;i<knowledge.size();i++){
            map.put(knowledge.get(i).get(0),knowledge.get(i).get(1));
        }
int i=0;
StringBuilder res=new StringBuilder();
while(i<n){
    char ch=s.charAt(i);
    if(ch=='('){
i++;
StringBuilder sb=new StringBuilder();
while(s.charAt(i)!=')'){
    sb.append(s.charAt(i));
    i++;
}
i++;
if(map.containsKey(sb.toString())){
    String str=map.get(sb.toString());
    res.append(str);

}else{
    res.append('?');
}

}else{
res.append(s.charAt(i));
i++;
    }
}
return res.toString();
    }
}