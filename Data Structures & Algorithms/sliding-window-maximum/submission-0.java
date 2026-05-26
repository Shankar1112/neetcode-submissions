class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        List<Integer> res = new ArrayList<>();
        res.add(nums[dq.getFirst()]);

        for (int i = k; i < nums.length; i++) {
            if (dq.getFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            res.add(nums[dq.getFirst()]);       
        }
        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
