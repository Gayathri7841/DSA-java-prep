class Solution {
    // n, meetings
    int n;
    int meetings[][];
    Long dp[];
    long result = 0;

    public long maxEarnings(int[][] meetings) {
        n = meetings.length;
        dp = new Long[n];

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        this.meetings = meetings;

        fn(0);

        return result;
    }

    private long fn(int i) {

        if (i >= n) return Long.MIN_VALUE;

        if (dp[i] != null) return dp[i];

        // Don't take current meeting
        long nottake = fn(i + 1);

        int st = meetings[i][0];
        int end = meetings[i][1];
        int revenue = meetings[i][2];

        // Find first compatible meeting
        int index = findnext(i);

        long take;

        if (index != -1) {

            take = revenue + fn(index) - end + st;

            result = Math.max(
                result,
                revenue + fn(index) - end
            );

        } else {

            take = revenue + st;

            result = Math.max(result, revenue);
        }

        dp[i] = Math.max(take, nottake);

        return dp[i];
    }

    private int findnext(int i) {

        int low = i + 1;
        int high = n - 1;
        int index = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (meetings[mid][0] >= meetings[i][1]) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }
}