class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str: strs) {
            sb.append(str.length()).append("#").append(str).append("#");
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;

        List<String> res = new ArrayList<>();
        while (i < str.length()) {
            int start = i;
            while (i < str.length() && str.charAt(i) != '#') {
                i++;
            }
            int num = Integer.parseInt(str.substring(start, i));
            i++;
            res.add(str.substring(i, i + num));
            i = i + num + 1;
        }
        return res;
    }
}
