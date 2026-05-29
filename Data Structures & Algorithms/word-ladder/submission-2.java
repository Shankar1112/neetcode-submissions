class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Pre processing
        Map<String, List<String>> wordMap = new HashMap<>();

        for (String word: wordList) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, len);

                List<String> allCombs = wordMap.getOrDefault(newWord, new ArrayList<>());
                allCombs.add(word);
                wordMap.put(newWord, allCombs);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int ladderLen = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                int currLen = currWord.length();
                for (int j = 0; j < currLen; j++) {
                    String newWord = currWord.substring(0, j) + "*" + currWord.substring(j + 1, currLen);
                    List<String> allCombs = wordMap.getOrDefault(newWord, new ArrayList<>());
                    for (String comb : allCombs) {
                        if (comb.equals(endWord)) {
                            return ladderLen + 1;
                        }
                        if (visited.contains(comb)) {
                            continue;
                        }
                        visited.add(comb);
                        queue.offer(comb);
                    }              
                }
            }
            ladderLen++;
        }
        return 0;

    }
}
