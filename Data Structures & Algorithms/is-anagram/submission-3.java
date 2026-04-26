class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> letterCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!letterCount.containsKey(c) || letterCount.get(c) == 0) {
                return false;
            }
            letterCount.put(c, letterCount.get(c) - 1);
        }

        for (char c : letterCount.keySet()) {
            if (letterCount.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
