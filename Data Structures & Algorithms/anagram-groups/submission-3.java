class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {

            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]).append("#");
            }

            List<String> list = res.getOrDefault(sb.toString(), new ArrayList<>());
            list.add(str);
            res.put(sb.toString(), list);
        }

        return new ArrayList(res.values());
    }
}
