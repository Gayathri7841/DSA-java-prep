class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;
        int count = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                count++;
            } 
            else {
                int u = Math.min(nums[i], nums[i + 1]);
                int v = Math.max(nums[i], nums[i + 1]);

                String key = u + " " + v;

                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int maxi = 0;

        for (String s : map.keySet()) {
            maxi = Math.max(maxi, map.get(s));
        }

        return count + maxi;
    }
}