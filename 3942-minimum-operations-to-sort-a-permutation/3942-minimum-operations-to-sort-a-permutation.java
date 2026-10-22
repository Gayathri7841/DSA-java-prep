class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int asc = 0, dsc = 0;

        for (int i = 0; i < n; i++) {
            int prev = (i - 1 + n) % n;

            if (nums[i] == (nums[prev] + 1) % n) {
                asc++;
            }

            if (nums[prev] == (nums[i] + 1) % n) {
                dsc++;
            }
        }

        if (asc == n) {
            int x = nums[0];

            if (x == 0) {
                return 0;
            }

            return Math.min(n - x, x + 2);
        }

        if (dsc == n) {
            int y = nums[n - 1];
            return 1 + Math.min(y, n - y);
        }

        return -1;
    }
}