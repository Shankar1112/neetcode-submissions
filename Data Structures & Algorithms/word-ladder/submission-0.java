class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Pre process the word list
        Map<String, List<String>> wordMap = new HashMap<>();
        for (String word : wordList) {
            int wordLen = word.length();
            for (int i = 0; i < wordLen; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLen);
                List<String> newWordList = wordMap.getOrDefault(newWord, new ArrayList<>());
                newWordList.add(word);
                wordMap.put(newWord, newWordList);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int ladderLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ladderLength++;
            for (int j = 0; j < size; j++) {
                String word = queue.poll();
                int wordLen = word.length();
                for (int i = 0; i < wordLen; i++) {
                    String newWord = word.substring(0, i) + "*" + word.substring(i + 1, wordLen);
                    if (wordMap.containsKey(newWord)) {
                        List<String> newWordList = wordMap.get(newWord);
                        for (String oneChangeWord : newWordList) {
                            if (oneChangeWord.equals(endWord)) {
                                return ladderLength + 1;
                            }
                            if (!visited.contains(oneChangeWord)) {
                                visited.add(oneChangeWord);
                                queue.add(oneChangeWord);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
