class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append(count[i]).append("#");
            }

            List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);

            map.put(sb.toString(), list);

        }

        return new ArrayList(map.values());
    }
}
