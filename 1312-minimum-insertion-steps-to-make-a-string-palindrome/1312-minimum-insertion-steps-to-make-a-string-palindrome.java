class Solution {
     String s1;
      String s2;
    int len;
Integer dp[][];
    public int minInsertions(String s) {
       this.s1=s;
        len=s.length();
        this.s2=new StringBuilder(s).reverse().toString();
         dp=new Integer[len][len];
           int x= fn(0,0);  
           return len-x;
    }
     private int fn(int i1,int i2){
        if(i1>=len||i2>=len) return 0;
if(dp[i1][i2]!=null) return dp[i1][i2];
      
        if(s1.charAt(i1)==s2.charAt(i2)){
 return dp[i1][i2]=1+fn(i1+1,i2+1);
        }
      
    
 return dp[i1][i2]=Math.max(fn(i1+1,i2),fn(i1,i2+1));
    
       
    }
}