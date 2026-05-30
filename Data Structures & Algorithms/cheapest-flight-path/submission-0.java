class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] flight: flights) {
            int source = flight[0];
            int dest = flight[1];
            int cost = flight[2];
            adjList.get(source).add(new int[] {dest, cost}); 
        }

        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = Integer.MAX_VALUE;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {src, 0, 0});
        price[src] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            if (curr[1] > k) {
                continue;
            }

            for (int[] nei : adjList.get(curr[0])) {
                int currCost = curr[2] + nei[1];

                if (currCost < price[nei[0]]) {
                    price[nei[0]] = currCost;
                    queue.offer(new int[] {nei[0], curr[1] + 1, price[nei[0]]});
                }
            }

        }
        return price[dst] != Integer.MAX_VALUE? price[dst] : -1;
    }
}
