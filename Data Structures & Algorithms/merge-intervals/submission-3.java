class Solution {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    void addInterval(int start, int end) {
        System.out.println("Here at add");
        Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
        if (floorEntry != null && floorEntry.getValue() >= start) {
            start = floorEntry.getKey();
            end = Math.max(end, floorEntry.getValue());
        }

        while (true) {
            Map.Entry<Integer, Integer> ceilEntry = map.ceilingEntry(start);
            if (ceilEntry == null || ceilEntry.getKey() > end) break;
            end = Math.max(end, ceilEntry.getValue());
            map.remove(ceilEntry.getKey());
        }
        map.put(start, end);
    }
    public int[][] merge(int[][] intervals) {
        

        for (int[] interval: intervals) {
            addInterval(interval[0], interval[1]);
            System.out.println("Added interval : " + interval[0] + " - " + interval[1]);
        }

        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue();
            i++;
        }
        return res;
    }
}
