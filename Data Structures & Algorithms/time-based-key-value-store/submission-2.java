class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(timestamp, value));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        if (map.containsKey(key)) {
            List<Pair<Integer, String>> list = map.get(key);
            
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right)/2;
                Pair<Integer, String> pair = list.get(mid);
                if (pair.getKey() <= timestamp) {
                    res = pair.getValue();
                    left = mid + 1;
                } else {
                    right = mid - 1; 
                }
            }
        }
        return res;
    }
}
