class KthLargest {

    PriorityQueue<Integer> pq;
    int maxCapacity;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        maxCapacity = k;
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > maxCapacity) {
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
            pq.offer(val);
            if (pq.size() > maxCapacity) {
                pq.poll();
            }
            return pq.peek();     
    }
}
