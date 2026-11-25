
class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int low = 1;
        int high = nums.length;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean check(int nums[], int len) {
        HashMap<String, Integer> map = new HashMap<>();

        int n = nums.length;

        long base1 = 31, base2 = 37;
        long mod1 = 1000000007L, mod2 = 1000000009L;

        long hash1 = 0, hash2 = 0;
        long power1 = 1, power2 = 1;

        for (int i = 1; i < len; i++) {
            power1 = (power1 * base1) % mod1;
            power2 = (power2 * base2) % mod2;
        }

        // First window
        for (int i = 0; i < len; i++) {
            hash1 = (hash1 * base1 + nums[i]) % mod1;
            hash2 = (hash2 * base2 + nums[i]) % mod2;
        }

        String key = hash1 + "#" + hash2;
        map.put(key, 1);

        // Remaining windows
        for (int i = len; i < n; i++) {

            hash1 = (hash1 - (nums[i-len] * power1) % mod1 + mod1) % mod1;
            hash1 = (hash1 * base1 + nums[i]) % mod1;

            hash2 = (hash2 - (nums[i-len] * power2) % mod2 + mod2) % mod2;
            hash2 = (hash2 * base2 + nums[i]) % mod2;

            key = hash1 + "#" + hash2;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) return true;
        }

        return false;
    }
}
