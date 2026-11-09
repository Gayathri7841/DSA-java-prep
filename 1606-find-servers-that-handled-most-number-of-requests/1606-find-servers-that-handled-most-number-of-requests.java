class Solution {
    class Node{
        int id;
        long endTime;
        Node(int id,long endTime){
            this.id=id;
            this.endTime=endTime;
        }
    }
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available=new TreeSet<>();
        int freq[]=new int[k];
        PriorityQueue<Node> busy=new PriorityQueue<>((a,b)->Long.compare(a.endTime,b.endTime));
        for(int i=0;i<k;i++){
            available.add(i);
        }
for(int i=0;i<arrival.length;i++){
    while(!busy.isEmpty()&&busy.peek().endTime<=arrival[i]){
        Node node=busy.poll();
        available.add(node.id);

    }
    if(available.isEmpty()) continue;
    Integer server=available.ceiling(i%k);
    if(server==null){
        server=available.first();
    }
    freq[server]++;
    busy.offer(new Node(server,arrival[i]+load[i]));
    available.remove(server);

}
List<Integer> res=new ArrayList<>();
int maxi=Integer.MIN_VALUE;
for(int num:freq)maxi=Math.max(maxi,num);
for(int i=0;i<freq.length;i++){
    if(freq[i]==maxi) res.add(i);
}
return res;
    }
}