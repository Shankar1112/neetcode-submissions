class TrieNode {
    Map<Character, TrieNode> children;
    boolean end = false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c: word.toCharArray()) {
            if (curr.children == null) {
                curr.children = new HashMap<>();
            }
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode curr = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c != '.') {
                if (curr.children == null || !curr.children.containsKey(c)){
                    return false;
                }
                curr = curr.children.get(c);
            } else {
                if (curr.children == null) {
                    return false;
                }
                for (char child : curr.children.keySet()) {
                    if (dfs(word, i + 1, curr.children.get(child))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return curr.end;
    }
}
