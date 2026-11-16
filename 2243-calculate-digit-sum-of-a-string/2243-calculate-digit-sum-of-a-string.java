class Solution {
    public String digitSum(String s, int k) {

        while (s.length() > k) {
            int n = s.length();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i += k) {
                int sum = 0;

                for (int j = i; j < Math.min(i + k, n); j++) {
                    int num = s.charAt(j) - '0';
                    sum += num;
                }

                sb.append(sum);
            }

            s = sb.toString();
        }

        return s;
    }
}