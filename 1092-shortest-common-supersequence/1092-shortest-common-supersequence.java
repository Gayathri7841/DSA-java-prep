class Solution {
    String s1;
    String s2;
    int l1;
    int l2;
    Integer dp[][];
    public String shortestCommonSupersequence(String str1, String str2) {
       s1=str1;
       s2=str2;
       l1=str1.length();
       l2=str2.length();
       dp=new Integer[l1+1][l2+1]; 
       int x=fn(0,0);
       int i=0,j=0;
       StringBuilder res=new StringBuilder();
       while(i<l1&&j<l2){
        if(s1.charAt(i)==s2.charAt(j)){
         res.append(s1.charAt(i));
i++;
j++;

        }
        else {
          int right=(dp[i][j+1]==null)?0:dp[i][j+1];
          int left=(dp[i+1][j]==null)?0:dp[i+1][j];
            if (right > left) {
                    res.append(s2.charAt(j));
                    j++;
                } else {
                    res.append(s1.charAt(i));
                    i++;
                }
       }
       }
       while(i<l1) res.append(s1.charAt(i++));
        while(j<l2) res.append(s2.charAt(j++));
       return res.toString();

    }
private int fn(int i,int j){
    if(i>=l1||j>=l2) {
        dp[i][j]=0;
        return 0;
    }
    if(dp[i][j]!=null) return dp[i][j];
    if(s1.charAt(i)==s2.charAt(j)) {
        dp[i][j]=1+fn(i+1,j+1);
    }else{
        dp[i][j]=Math.max(fn(i+1,j),fn(i,j+1));
    }
    return dp[i][j];

}

}