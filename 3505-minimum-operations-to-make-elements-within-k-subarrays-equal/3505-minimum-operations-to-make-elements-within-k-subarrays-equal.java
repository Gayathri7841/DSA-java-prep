
import java.util.*;

class Solution {

    class Window {
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftCount = 0, rightCount = 0;
        long leftSum = 0, rightSum = 0;

        void addMap(TreeMap<Integer, Integer> map, int num) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        void removeMap(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);

            if (count == 1) map.remove(num);
            else map.put(num, count - 1);
        }

        void add(int num) {
            if (leftCount == 0 || num <= left.lastKey()) {
                addMap(left, num);
                leftCount++;
                leftSum += num;
            } else {
                addMap(right, num);
                rightCount++;
                rightSum += num;
            }

            balance();
        }

        void remove(int num) {
            if (left.containsKey(num)) {
                removeMap(left, num);
                leftCount--;
                leftSum -= num;
            } else {
                removeMap(right, num);
                rightCount--;
                rightSum -= num;
            }

            balance();
        }

        void balance() {
            int target = (leftCount + rightCount + 1) / 2;

            while (leftCount > target) {
                int num = left.lastKey();

                removeMap(left, num);
                leftCount--;
                leftSum -= num;

                addMap(right, num);
                rightCount++;
                rightSum += num;
            }

            while (leftCount < target) {
                int num = right.firstKey();

                removeMap(right, num);
                rightCount--;
                rightSum -= num;

                addMap(left, num);
                leftCount++;
                leftSum += num;
            }
        }

        long getCost() {
            long median = left.lastKey();

            return median * leftCount - leftSum
                 + rightSum - median * rightCount;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Sliding window costs
        long[] cost = new long[n - x + 1];

        Window window = new Window();

        for (int i = 0; i < x; i++) {
            window.add(nums[i]);
        }

        cost[0] = window.getCost();

        for (int i = 1; i <= n - x; i++) {
            window.remove(nums[i - 1]);
            window.add(nums[i + x - 1]);

            cost[i] = window.getCost();
        }

        // Step 2: DP
        long INF = Long.MAX_VALUE / 2;
        long[][] dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        // Step 3: DP transitions
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                // Skip
                dp[i][j] = dp[i - 1][j];

                // Select current window
                if (i >= x && dp[i - x][j - 1] != INF) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - x][j - 1] + cost[i - x]
                    );
                }
            }
        }

        return dp[n][k];
    }
}
