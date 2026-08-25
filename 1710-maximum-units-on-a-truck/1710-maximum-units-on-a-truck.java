class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(a[1],b[1]));
        int n=boxTypes.length;
        int boxes=0;
        int units=0;
        for(int i=n-1;i>=0;i--){
if(boxes+boxTypes[i][0]<=truckSize){
boxes=boxes+boxTypes[i][0];
units=units+boxTypes[i][0]*boxTypes[i][1];
}else{
    int diff=truckSize-boxes;
    units=units+diff*boxTypes[i][1];
break;

}
        }
        return units;
    }
}