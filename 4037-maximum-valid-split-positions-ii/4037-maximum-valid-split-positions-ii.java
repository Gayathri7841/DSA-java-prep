class Solution {

    int[] seg;
    int n;

    // Used while searching the segment tree
    int currentGcd;

    public int maxValidSplits(int[] nums) {

        n = nums.length;
        seg = new int[4 * n];

        build(1, 0, n - 1, nums);

        // Prefix and suffix gcds
        int[] pref = new int[n];
        int[] suff = new int[n];

        for (int i = 0; i < n; i++) {
            pref[i] = gcd(i == 0 ? 0 : pref[i - 1], nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            suff[i] = gcd(i == n - 1 ? 0 : suff[i + 1], nums[i]);
        }

        int ans = 0;

        /*
         * remove = 0 ... n-1  -> remove that element
         * remove = n           -> remove nothing
         */
        for (int remove = 0; remove <= n; remove++) {

            // GCD of the entire remaining array
            int totalGcd;

            if (remove == n) {
                totalGcd = pref[n - 1];
            } else {
                int left = (remove == 0) ? 0 : pref[remove - 1];
                int right = (remove == n - 1) ? 0 : suff[remove + 1];

                totalGcd = gcd(left, right);
            }

            /*
             * First remaining position where
             * prefix GCD becomes totalGcd.
             */
            int first = findFirst(remove, totalGcd);

            /*
             * Last remaining position from which
             * suffix GCD is totalGcd.
             */
            int last = findLast(remove, totalGcd);

            if (first == -1 || last == -1 || first >= last)
                continue;

            /*
             * Every remaining split between first and last
             * is valid.
             *
             * Normally there are (last - first) splits.
             *
             * If the deleted element lies between first and last,
             * one original position disappeared, so subtract 1.
             */
            int count = last - first;

            if (first <= remove && remove <= last)
                count--;

            ans = Math.max(ans, count);
        }

        return ans;
    }

    // ---------------------------------------------------------
    // Segment Tree
    // ---------------------------------------------------------

    private void build(int node, int low, int high, int[] nums) {

        if (low == high) {
            seg[node] = nums[low];
            return;
        }

        int mid = low + (high - low) / 2;

        build(node * 2, low, mid, nums);
        build(node * 2 + 1, mid + 1, high, nums);

        seg[node] = gcd(seg[node * 2], seg[node * 2 + 1]);
    }

    // ---------------------------------------------------------
    // Find first remaining index whose prefix GCD == target
    // ---------------------------------------------------------

    private int findFirst(int remove, int target) {

        currentGcd = 0;

        return findFirst(1, 0, n - 1, remove, target);
    }

    private int findFirst(
        int node,
        int low,
        int high,
        int remove,
        int target
    ) {

        if (low == high) {

            if (low == remove)
                return -1;

            currentGcd = gcd(currentGcd, seg[node]);

            if (currentGcd == target)
                return low;

            return -1;
        }

        /*
         * If this entire segment does NOT contain the removed
         * element, we can use its stored GCD directly.
         *
         * If adding this whole segment doesn't reach target,
         * no prefix inside this segment can reach target.
         */
        if (remove < low || remove > high) {

            int combined = gcd(currentGcd, seg[node]);

            if (combined != target) {
                currentGcd = combined;
                return -1;
            }
        }

        int mid = low + (high - low) / 2;

        // Search left first because we want the FIRST position.
        int left = findFirst(
            node * 2,
            low,
            mid,
            remove,
            target
        );

        if (left != -1)
            return left;

        return findFirst(
            node * 2 + 1,
            mid + 1,
            high,
            remove,
            target
        );
    }

    // ---------------------------------------------------------
    // Find last remaining index from which suffix GCD == target
    // ---------------------------------------------------------

    private int findLast(int remove, int target) {

        currentGcd = 0;

        return findLast(1, 0, n - 1, remove, target);
    }

    private int findLast(
        int node,
        int low,
        int high,
        int remove,
        int target
    ) {

        if (low == high) {

            if (low == remove)
                return -1;

            currentGcd = gcd(currentGcd, seg[node]);

            if (currentGcd == target)
                return low;

            return -1;
        }

        if (remove < low || remove > high) {

            int combined = gcd(currentGcd, seg[node]);

            if (combined != target) {
                currentGcd = combined;
                return -1;
            }
        }

        int mid = low + (high - low) / 2;

        // Search right first because we want the LAST position.
        int right = findLast(
            node * 2 + 1,
            mid + 1,
            high,
            remove,
            target
        );

        if (right != -1)
            return right;

        return findLast(
            node * 2,
            low,
            mid,
            remove,
            target
        );
    }

    // ---------------------------------------------------------
    // GCD
    // ---------------------------------------------------------

    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}