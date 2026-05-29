class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean end = false;

}
class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();         
    }

    public void insert(String word) {
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
        TrieNode curr = root;
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            } 
            curr = curr.children[c - 'a'];
            i++;
        }
        return curr.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int i = 0;
        while (i < prefix.length()) {
            char c = prefix.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            } 
            curr = curr.children[c - 'a'];
            i++;
        }
        return true;
    }
}
