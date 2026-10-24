class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arr[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String dates[]=new String[4];
        dates[0]=arriveAlice;
        dates[1]=leaveAlice;
        dates[2]=arriveBob;
        dates[3]=leaveBob;
        int aa=0,al=0,ba=0,bl=0;
        for(int i=0;i<4;i++){
            String s=dates[i];
            StringBuilder date=new StringBuilder();
            StringBuilder month=new StringBuilder();
            month.append(s.charAt(0));
            month.append(s.charAt(1));
            date.append(s.charAt(3));
            date.append(s.charAt(4));
            int m=Integer.parseInt(month.toString());
            int d=Integer.parseInt(date.toString());
            int sum=0;
            for(int j=0;j<m-1;j++){
                sum=sum+arr[j];
            }
            sum=sum+d;
            if(i==0) aa=sum;
            else if(i==1) al=sum;
            else if(i==2) ba=sum;
            else bl=sum;


        }
        int min=Math.max(aa,ba);
        int max=Math.min(al,bl);
        return Math.max(0,max-min+1);

    }
}
