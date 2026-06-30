class Solution {
    int start=0;
    int end=0;
    public String longestPalindrome(String s) {
        int len=s.length();
        int max=Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            expand(s,i,i);
            expand(s,i,i+1);
          
        }
        return s.substring(start,end+1);
    }
    public void expand(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
           
                left--;
                right++;
            }
left++;
right--;
if(right-left>end-start){
    start=left;
    end=right;
}
        }
    }
