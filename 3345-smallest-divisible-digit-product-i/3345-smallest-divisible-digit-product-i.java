class Solution {
    int t;
    public int smallestNumber(int n, int t) {
        this.t=t;
        int temp=n;
    while(true){

if(check(n)){
    return n;
}
n++;
    }
    
    }
    private boolean check(int n){
        int temp=n;
        int mul=1;
        while(n>0){
            int r=n%10;
mul=mul*r;
n=n/10;
        }
        if(mul%t==0) return true;
        return false;
    }
}