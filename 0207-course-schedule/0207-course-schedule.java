class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // add all courses to map
        for(int i = 0; i < numCourses; i++)
            map.put(i, new ArrayList<>());

        // add prerequisites for each course
        for(int[] prerequisite: prerequisites){
            int course = prerequisite[0];
            int pre = prerequisite[1];
            map.get(course).add(pre);
        }

        // if there exists a loop in our graph that means that we cannot take the courses
        for(int[] prerequisite: prerequisites){
            int course = prerequisite[0];
            if(!dfs(map, new HashSet<>(), course))
                return false;
        }
        return true;

    }

    public boolean dfs(HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited, int course){
        if(visited.contains(course))
            return false;

        // if course doesn't have prerequisited that means that we can take it
        if(map.get(course).isEmpty())
            return true;

        // go over each prerequisite course
        visited.add(course);
        for(int i = 0; i < map.get(course).size(); i++){
            int prerequisite = map.get(course).get(i);
            if(!dfs(map, visited, prerequisite))
                return false;
        }
        
        // if we get here that means that we can take this course
        // to speed up things, we can clear its prerequisites, so that the 2nd condition picks up directly
        map.get(course).clear();
        visited.remove(course);
        return true;
    }
}