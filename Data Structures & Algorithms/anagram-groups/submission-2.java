class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            int[] charCount = new int[26];
            for (char c: str.toCharArray()) {
                charCount[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(charCount[i]).append("#");
            }

            map.computeIfAbsent(sb.toString(), k -> new ArrayList()).add(str);            
        }

        return new ArrayList<>(map.values());
    }
}
