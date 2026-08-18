class Solution {
    List<List<String>> res=new ArrayList<>();
    String start;
      HashMap<String ,Integer> map=new HashMap<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        map.put(beginWord, 0);
        start=beginWord;
        Set<String> set=new HashSet<>(wordList);
        if(set.contains(beginWord)) set.remove(beginWord);
        Set<String> used=new HashSet<>();
      
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int x=0;x<size;x++){
                String s=q.poll();
              
                char c[]=s.toCharArray();
                for(int i=0;i<c.length;i++){
                    char original=c[i];
                    for(char ch='a';ch<='z';ch++){
                        c[i]=ch;
                        String newword=new String(c);
                        if(set.contains(newword)){
                           if (!used.contains(newword)) {
        q.offer(newword);
        used.add(newword);
    }

    map.put(newword, level + 1);
                        }
                    }
                    c[i]=original;
                }

            }
            level++;
            for(String str:used){
                set.remove(str);
            }
            used.clear();
        }
  if (!map.containsKey(endWord)) {
            return res;
        }

        List<String> list=new ArrayList<>();
        list.add(endWord);
       
        dfs(endWord,list);
        return res;
    }
    private void dfs(String s,List<String> list){
        if(s.equals(start)){
             List<String> path = new ArrayList<>(list);
    Collections.reverse(path);
    res.add(path);
    return;
        }
        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i++){
            char original=ch[i];
            for(char c='a';c<='z';c++){
ch[i]=c;
String newword=new String(ch);
if(map.containsKey(newword)){
    int val=map.get(s);
    if(map.get(newword)==val-1){
        list.add(newword);
        dfs(newword,list);
        list.remove(list.size()-1);
    }
}
            }
            ch[i]=original;

        }
    }

}