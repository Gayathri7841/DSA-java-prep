class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max=Integer.MIN_VALUE;
        
        int maxi=Integer.MIN_VALUE;
        for(int num:lights) max=Math.max(num,max);
        for(int i=0;i<arrivalTime.length;i++){
            int r=arrivalTime[i]%period;
            if(r<max){
                maxi=Math.max(maxi,0);
            }else{
                maxi=Math.max(maxi,period-r);
            }
        }
        return maxi;
    }
}