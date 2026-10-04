class Solution {
int n;
Boolean dp[][];
    public boolean checkValidString(String s) {
         n=s.length();
        dp=new Boolean[n][n];
     
      return fn(0,0,s);  
    }
    private boolean fn(int i,int balance,String s){
        if(balance<0) return false;
        if(i>=n){
            if(balance==0)  return true;
            return false;

        }
        if(dp[i][balance]!=null) return dp[i][balance];
        if(s.charAt(i)=='(') {
           return dp[i][balance] =fn(i+1,balance+1,s);
        }
        else if(s.charAt(i)==')'){
          return dp[i][balance]=  fn(i+1,balance-1,s);
        }
            return dp[i][balance]=fn(i+1,balance+1,s)||fn(i+1,balance,s)||fn(i+1,balance-1,s);
        

    }
}