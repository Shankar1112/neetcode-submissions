class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean end = false;
}

class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            i++;
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    boolean dfs(String word, int i, TrieNode curr) {
        while (i < word.length()) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode node: curr.children) {
                    if (node != null && dfs(word, i + 1, node)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr = curr.children[c - 'a'];
            }
            i++;
        }
        return curr.end;
    }
}
