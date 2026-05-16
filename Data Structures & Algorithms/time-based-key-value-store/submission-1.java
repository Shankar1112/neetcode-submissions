class TimeMap {

    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> list = new ArrayList<>();
        if (map.containsKey(key)) {
            list = map.get(key);
        }
        list.add(new Pair(timestamp, value));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<Integer, String>> list = map.get(key);
        int left = 0, right = list.size() - 1;

        String res = "";
        while (left <= right) {
            int mid = (left + right)/2;

            Pair<Integer, String> curr = list.get(mid);

            if (curr.getKey() <= timestamp) {
                res = curr.getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
