class TimeMap {

    private Map<String, List<Pair<Integer, String>>> keyStore;
    public TimeMap() {
        keyStore = new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<Integer, String>> res = keyStore.getOrDefault(key, new ArrayList<>());
        int l = 0, r = res.size() - 1;
        String result = "";
        while (l <= r) {
            int m = l + (r - l)/2;
            if (res.get(m).getKey() <= timestamp) {
                result = res.get(m).getValue();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return result;
    }

    private static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
