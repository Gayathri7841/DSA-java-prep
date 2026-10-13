
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        int[] arr = new int[n];
        int left = 0, right = n - 1;
        int index = 0;

        while (left <= right) {
            if (index % 2 == 0) {
                arr[index++] = nums[right--];
            } else {
                arr[index++] = nums[left++];
            }
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long square = (long) arr[i] * arr[i];

            if (i % 2 == 0) {
                ans += square;
            } else {
                ans -= square;
            }
        }

        return ans;
    }
}
