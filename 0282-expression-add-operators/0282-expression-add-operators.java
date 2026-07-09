class Solution {
  private  List<String> ans=new ArrayList<>();
  private  long t;
 private   String s;
    public List<String> addOperators(String num, int target) {
        s=num;
        t=target;
        dfs(0,"",0,0);
        return ans;
    }
private void dfs(int i,String path,long res,long prev){
    if(i==s.length()){
if(res==t) ans.add(path);
return;
    }

    for(int  j=i;j<s.length();j++){
        if(j>i&&s.charAt(i)=='0') return;

        long currnum=Long.parseLong(s.substring(i,j+1));
        if(i==0){
            dfs(j+1,path+currnum,currnum,currnum);
        }else{
              dfs(j+1,path+"+"+currnum,res+currnum,currnum);
                dfs(j+1,path+"-"+currnum,res-currnum,-currnum);
                  dfs(j+1,path+"*"+currnum,(res-prev)+(prev*currnum),prev*currnum);
        }
    }
}
}