class Solution {
      String str1;
    String str2;
    int s1;
    int s2;
Integer dp[][];
    public int minDistance(String word1, String word2) {
        this.str1=word1;
     this.str2=word2;
     s1=str1.length();
     s2=str2.length();
     dp=new Integer[s1][s2];
     int x= fn(0,0);
     int a=s1-x;
     int b=s2-x;
    return a+b;

    }
     private int fn(int i1,int i2){
        if(i1>=s1||i2>=s2) return 0;
if(dp[i1][i2]!=null) return dp[i1][i2];
      
        if(str1.charAt(i1)==str2.charAt(i2)){
 return dp[i1][i2]=1+fn(i1+1,i2+1);
        }
      
    
 return dp[i1][i2]=Math.max(fn(i1+1,i2),fn(i1,i2+1));
    
       
    }
}