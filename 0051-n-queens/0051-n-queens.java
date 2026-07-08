class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> res=new ArrayList<>();
       String board[][]=new String[n][n];
        for (int i = 0; i < n; i++) {          
            for (int j = 0; j < n; j++) {   
              board[i][j]=".";
            }
        }
       int upperdig[]=new int[2*n-1];
        int leftrow[]=new int[2*n-1];
         int lowerdig[]=new int[2*n-1];
         fn(0,n,res,board,upperdig,leftrow,lowerdig);
         return res;
}

public void fn(int col,int n,List<List<String>> res, String board[][], int upperdig[], int leftrow[],int lowerdig[] ){

    if(col==n){
        List<String> list=new ArrayList<>();
         for (int i = 0; i < n; i++) {      
            String str="";    
            for (int j = 0; j < n; j++) {   
              str=str+board[i][j];
            }
            list.add(str);
        }
        res.add(new ArrayList<>(list));
        return;
    }

for(int row=0;row<n;row++){

if( leftrow[row]==0&&lowerdig[row+col]==0&& upperdig[n-1+col-row]==0){
    board[row][col]="Q";
    upperdig[n-1+col-row]=1;
    leftrow[row]=1;
    lowerdig[row+col]=1;
     fn(col+1,n,res,board,upperdig,leftrow,lowerdig);

  board[row][col]=".";
    upperdig[n-1+col-row]=0;
    leftrow[row]=0;
    lowerdig[row+col]=0;

}
}

}
}