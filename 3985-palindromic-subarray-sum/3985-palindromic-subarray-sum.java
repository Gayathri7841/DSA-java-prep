class Solution {

    private int[] manacher(int[] nums) {
        int n = nums.length;

        // Transform: # num # num # ...
        long[] t = new long[2 * n + 1];
        for (int i = 0; i < t.length; i++) {
            if ((i & 1) == 0)
                t[i] = Long.MIN_VALUE;   // separator
            else
                t[i] = nums[i / 2];
        }

        int[] p = new int[t.length];

        int center = 0;
        int right = 0;

        for (int i = 0; i < t.length; i++) {

            if (i < right) {
                int mirror = 2 * center - i;
                p[i] = Math.min(right - i, p[mirror]);
            }

            while (i - (p[i] + 1) >= 0 &&
                   i + (p[i] + 1) < t.length &&
                   t[i - (p[i] + 1)] == t[i + (p[i] + 1)]) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        return p;
    }

    public long getSum(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        int[] p = manacher(nums);

        long ans = 0;

        for (int i = 0; i < p.length; i++) {

            int L = (i - p[i]) / 2;
            int R = (i + p[i]) / 2 - 1;

            if (L <= R) {
                ans = Math.max(ans, prefix[R + 1] - prefix[L]);
            }
        }

        // Single element palindrome
        for (int x : nums)
            ans = Math.max(ans, (long) x);

        return ans;
    }
}