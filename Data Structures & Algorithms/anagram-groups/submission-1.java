class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> map = new HashMap<>();

        for (String str: strs) {
            int[] freqMap = new int[26];
            for (char c: str.toCharArray()) {
                freqMap[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(freqMap[i]).append("#");
            }
            List<String> curr = map.getOrDefault(sb.toString(), new ArrayList<>());
            curr.add(str);
            map.put(sb.toString(), curr);
        }

        return new ArrayList<>(map.values());

    }
}
