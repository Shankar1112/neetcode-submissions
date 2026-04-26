class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int canFinish = 0;

        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            indegree[prereq[0]]++;
            adjList.get(prereq[1]).add(prereq[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            canFinish++;
            for (int adjCourse : adjList.get(course)) {
                indegree[adjCourse]--;
                if (indegree[adjCourse] == 0) {
                    queue.offer(adjCourse);
                }
            }
        }

        return canFinish == numCourses;
    }
}
