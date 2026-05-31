class Solution {
    List<String> res;
    Map<Character, List<Character>> map = new HashMap<>();


    public List<String> letterCombinations(String digits) {
    map.put('2', Arrays.asList('a', 'b', 'c'));
    map.put('3', Arrays.asList('d', 'e', 'f'));
    map.put('4', Arrays.asList('g', 'h', 'i'));
    map.put('5', Arrays.asList('j', 'k', 'l'));
    map.put('6', Arrays.asList('m', 'n', 'o'));
    map.put('7', Arrays.asList('p', 'q', 'r', 's'));
    map.put('8', Arrays.asList('t', 'u', 'v'));
    map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        res = new ArrayList();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        backtrack(0, new StringBuilder(), digits);
        return res;
    }

    void backtrack(int start, StringBuilder currWord, String digits) {
        if (start == digits.length()) {
            res.add(currWord.toString());
            return;
        }

        int i = start;
            char c = digits.charAt(i);

            for (char a : map.get(c)) {
                currWord.append(a);
                backtrack(i + 1, currWord, digits);
                currWord.deleteCharAt(currWord.length() - 1);
            }
    }
}
