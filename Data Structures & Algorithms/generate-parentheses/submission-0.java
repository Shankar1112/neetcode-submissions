class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return res;
    }

    void backtrack(int open, int close, int n, StringBuilder curr) {
        if (open == n && open == close) {
            res.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append("(");
            backtrack(open + 1, close, n, curr);
            curr.deleteCharAt(curr.length()-1);
        }

        if (close < open) {
            curr.append(")");
            backtrack(open, close + 1, n, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
