class Solution {
     int col;
    int row;
    public boolean exist(char[][] board, String word) {
         col=board[0].length;
      row=board.length;

for(int i=0;i<row;i++){
    for(int j=0;j<col;j++){
   if(fn(i,j,0,word,board)){
    return true;
   }
    }
}
return false;
 }
    public boolean fn(int i,int j, int index,String word,char[][] board){
          if(i<0||j<0||i>=row||j>=col||board[i][j]!=word.charAt(index)||board[i][j]=='#'){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
char original=board[i][j];
        board[i][j]='#';
       boolean left= fn(i,j-1,index+1,word,board);
       
      boolean right=  fn(i,j+1,index+1,word,board);
      
        boolean up=fn(i-1,j,index+1,word,board);
       
        boolean bottom=fn(i+1,j,index+1,word,board);
       
board[i][j]=original;
return left||right||up||bottom;
    }
}