class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // prepare the directed graph
        // to make it easier to find the topological sort, the graph is directed prerequisite -> course
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        // declare a visited list that will keep track of the nodes we have visited so far and have been done visiting
        // 0 -> not visited
        // 1 -> visiting, this will be useful to track cycles if there are
        // 2 -> visited
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<>());
            visited[i] = 0; // init nodes as not visited
        }

        // add the vertices to the graph
        for(int i = 0; i < prerequisites.length; i++){
            int prerequisite = prerequisites[i][1];
            int next = prerequisites[i][0];
            graph.get(prerequisite).add(next);
        }

        // init an stack to add the result of the topological sort
        Stack<Integer> res = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            if(!topologicalSort(res, graph, visited, i)) return new int[0];
        }

        // reverse the arraylist and return result
        int[] result = new int[numCourses];
        int i = 0;
        while(!res.isEmpty())
            result[i++] = res.pop();
        
        return result;
    }

    public boolean topologicalSort(Stack<Integer> res, HashMap<Integer, ArrayList<Integer>> graph, int[]visited, int course){
        if(visited[course] == 1)
            return false;

        if(visited[course] == 2)
            return true;

        // set the current course as visiting
        visited[course] = 1;

        // explore all its neighbors
        for(int nextCourse: graph.get(course)){
            if(!topologicalSort(res, graph, visited, nextCourse)) return false;
        }

        // set the course as visited because we are done with it
        visited[course] = 2;
        // add the course to our results
        res.push(course);

        // if we get here it means that there is a topological sort
        return true;
    }
}