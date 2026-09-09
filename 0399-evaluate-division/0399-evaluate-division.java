class Solution {
    class Pair{
        String node;
        double weight;
        Pair(String node,double weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
     
        HashMap<String,List<Pair>> map=new HashMap<>();
       int size=values.length;
       for(int i=0;i<size;i++){
        String u=equations.get(i).get(0);
        String v=equations.get(i).get(1);
        double wt=values[i];
        if(map.containsKey(u)){
          map.get(u).add(new Pair(v,wt));
        }else{
            List<Pair> list = new ArrayList<>();
list.add(new Pair(v, wt));
map.put(u, list);
          
        }
        if(map.containsKey(v)){
            map.get(v).add(new Pair(u,1/wt));
        }
        else{

            List<Pair> list = new ArrayList<>();
list.add(new Pair(u, 1/wt));
map.put(v, list);
        }
       }
       int s=queries.size();
       double res[]=new double[s];
       for(int i=0;i<queries.size();i++){
         String u=queries.get(i).get(0);
        String v=queries.get(i).get(1);
         HashSet<String> visited = new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(u,1.0));
        visited.add(u);
           res[i] = -1.0;

while(!q.isEmpty()){
    Pair p=q.poll();
    String node=p.node;
    double w=p.weight;
    if(!map.containsKey(node)){
       
        break;
    }
    if(node.equals(v)){
        res[i]=w;
        break;
    }
    for(Pair pp:map.get(node)){
        String str=pp.node;
        double d=pp.weight;
         if (!visited.contains(str)) {
                        visited.add(str);
                        q.offer(new Pair(str, w * d));
                    }
    }


}

       }
       return res;
    }
}