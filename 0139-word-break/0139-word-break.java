class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        boolean dp[]=new boolean[len+1];
        dp[0]=true;
        Set<String> set=new HashSet<>(wordDict);
       int maxLen=0;
       for(String word:wordDict){
        maxLen=Math.max(maxLen,word.length());
       }
        for(int i=0;i<len;i++){
for(int j=i;j>=Math.max(0,i-maxLen);j--){
    if(set.contains(s.substring(j,i+1))){
        if(dp[j]){
        dp[i+1]=true;
        break;
        }
    }
}
        }

return dp[len];
    }
}