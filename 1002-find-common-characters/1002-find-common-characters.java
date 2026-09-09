class Solution {
    public List<String> commonChars(String[] words) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters of the first word
        for (char ch : words[0].toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        // Compare with every other word
        for (int i = 1; i < words.length; i++) {

            HashMap<Character, Integer> temp = new HashMap<>();

            for (char ch : words[i].toCharArray()) {
                if (temp.containsKey(ch)) {
                    temp.put(ch, temp.get(ch) + 1);
                } else {
                    temp.put(ch, 1);
                }
            }

            // Keep only the minimum frequency
            for (char ch : map.keySet()) {
                if (temp.containsKey(ch)) {
                    map.put(ch, Math.min(map.get(ch), temp.get(ch)));
                } else {
                    map.put(ch, 0);
                }
            }
        }

        List<String> res = new ArrayList<>();

        for (char ch : map.keySet()) {
            int count = map.get(ch);

            while (count > 0) {
                res.add(String.valueOf(ch));
                count--;
            }
        }

        return res;
    }
}