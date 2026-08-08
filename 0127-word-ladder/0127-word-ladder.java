class Solution {
    class Pair{
        String str;
        int val;
        Pair(String str,int val){
            this.str=str;
            this.val=val;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        for(String s:wordList){
            set.add(s);
        }
        q.offer(new Pair(beginWord,1));
        if(set.contains(beginWord)) set.remove(beginWord);
        while(!q.isEmpty()){
            Pair node=q.poll();
            String s=node.str;
            int val=node.val;
            if(s.equals(endWord)) return val;
            for(int i=0;i<s.length();i++){
                char c[]=s.toCharArray();
                char original=c[i];
                for(char ch='a';ch<='z';ch++){
                    c[i]=ch;
                    String newword=new String(c);
                    if(set.contains(newword)){
                        set.remove(newword);
                        q.offer(new Pair(newword,val+1));
                    }

                }
                c[i]=original;
            }
                    }
                    return 0;
    }
}