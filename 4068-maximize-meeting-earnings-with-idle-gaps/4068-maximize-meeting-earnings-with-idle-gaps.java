class Solution {
    int n;
    int[][] meetings;
    long[] dp;
    long result = 0;

    public long maxEarnings(int[][] meetings) {

        this.meetings = meetings;
        n = meetings.length;

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        dp = new long[n];
        Arrays.fill(dp, Long.MIN_VALUE);

        solve(0);

        return result;
    }

    private long solve(int i) {

        if (i >= n) {
            return Long.MIN_VALUE;
        }

        if (dp[i] != Long.MIN_VALUE) {
            return dp[i];
        }

        // Don't take current meeting
        long notTake = solve(i + 1);

        int st = meetings[i][0];
        int end = meetings[i][1];
        int revenue = meetings[i][2];

        // Binary search for first meeting
        // whose start >= current meeting's end
        int index = -1;

        int low = i + 1;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (meetings[mid][0] >= end) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        long take;

        if (index != -1) {

            take = revenue + solve(index) - end + st;

            result = Math.max(
                result,
                revenue + solve(index) - end
            );

        } else {

            take = revenue + st;

            result = Math.max(result, revenue);
        }

        dp[i] = Math.max(take, notTake);

        return dp[i];
    }
}