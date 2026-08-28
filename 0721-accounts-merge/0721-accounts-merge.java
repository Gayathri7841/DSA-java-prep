class Solution {
    int parent[];
    int size[];
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        size=new int[n];
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
           for(int j = 1; j < accounts.get(i).size(); j++){
    String mail = accounts.get(i).get(j);
               if(!map.containsKey(mail)){
                map.put(mail,i);
               }else{
                int u=map.get(mail);
                disjoint(u,i);
               }
            }
        }
        List<String> arr[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            arr[i]=new ArrayList<>();
        }
        for(String mail:map.keySet()){
            int parent=getParent(map.get(mail));
arr[parent].add(mail);
        }
List<List<String>> res=new ArrayList<>();
for(int i=0;i<n;i++){
    if(arr[i].size()!=0){
       Collections.sort(arr[i]);

List<String> list = new ArrayList<>();
list.add(accounts.get(i).get(0));
list.addAll(arr[i]);

res.add(list);
    }
}
return res;
    }
private void disjoint(int u,int v){
        int parentu=getParent(u);
        int parentv=getParent(v);
        if(parentu==parentv) return;
        int sizeu=size[parentu];
        int sizev=size[parentv];
       if(sizev > sizeu){
    parent[parentu] = parentv;
    size[parentv] += size[parentu];
}
else if(sizev < sizeu){
    parent[parentv] = parentu;
    size[parentu] += size[parentv];
}
else{
    parent[parentv] = parentu;
    size[parentu] += size[parentv];
}
    }
    private int getParent(int node){
        if(parent[node]==node) return node;
        int par=getParent(parent[node]);
        parent[node]=par;
        return parent[node];
    }
}