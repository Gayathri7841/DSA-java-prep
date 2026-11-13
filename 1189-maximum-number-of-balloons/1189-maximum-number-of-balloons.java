class Solution {
    public int maxNumberOfBalloons(String text) {
       int n=text.length();
       int freq[]=new int[27];
       for(int i=0;i<n;i++){
char ch=text.charAt(i);
int index=ch-'a'+1;
freq[index]++;

       } 
       String s="balloon";
       int min=Integer.MAX_VALUE;
       for(int i=0;i<s.length();i++){
        char ch=s.charAt(i);
         int pos=ch-'a'+1;
         int num=Integer.MAX_VALUE;
        if(ch=='l'||ch=='o'){
        num=freq[pos]/2;
        }else{
            num=freq[pos];
        }
       
      min=Math.min(min,num);
       }
return min;
    }
}