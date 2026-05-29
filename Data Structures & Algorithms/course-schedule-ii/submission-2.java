class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] prereq : prerequisites) {
            adjList.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        int canFinish = 0;
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[canFinish++] = curr;

            for (int nei : adjList.get(curr)) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        return canFinish == numCourses? res : new int[0];
    }
}
