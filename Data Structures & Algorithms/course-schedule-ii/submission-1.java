class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
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
        
        int canFinish = 0;
        int[] res = new int[numCourses];

        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[canFinish] = course;
            canFinish++;
            for (int adjCourse : adjList.get(course)) {
                indegree[adjCourse]--;
                if (indegree[adjCourse] == 0) {
                    queue.offer(adjCourse);
                }
            }
        }
        return canFinish == numCourses? res : new int[0];
    }
}
