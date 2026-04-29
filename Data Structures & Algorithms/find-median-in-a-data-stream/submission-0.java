class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if (maxHeap.size() - minHeap.size() > 1 || (!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek())) {
            minHeap.add(maxHeap.poll());
        }

        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek())/2;
        } else if (minHeap.size() > maxHeap.size()){
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    }
}
