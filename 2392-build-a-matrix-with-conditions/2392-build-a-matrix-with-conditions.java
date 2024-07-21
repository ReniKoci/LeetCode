class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // init graphs
        List<Integer>[] row = new ArrayList[k + 1];
        List<Integer>[] col = new ArrayList[k + 1];

        for(int i = 1; i < row.length; i++)
            row[i] = new ArrayList<>();
        
        for(int i = 1; i < col.length; i++)
            col[i] = new ArrayList<>();

        // construct graphs
        for(int[] rowCondition: rowConditions)
            row[rowCondition[0]].add(rowCondition[1]);

        for(int[] colCondition: colConditions)
            col[colCondition[0]].add(colCondition[1]);
    
        // check if a topological sort can be found
        // if not return empty array
        // otherwise get the topoligal sort of numbers in queue

        // complete for row indices
        int[] visited = new int[k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 1; i < row.length; i++){
            if(!topologicalSort(row, i, visited, queue))
                return new int[0][0];
        }

        int[] rowIndices = new int[k + 1];
        for(int i = 0; i < k; i++){
            int node = queue.pollLast();
            rowIndices[node] = i;
        }

        // complete for col indices
        visited = new int[k + 1];
        queue = new LinkedList<>();
        for(int i = 1; i < col.length; i++){
            if(!topologicalSort(col, i, visited, queue))
                return new int[0][0];
        }
        
        int[] colIndices = new int[k + 1];
        for(int i = 0; i < k; i++){
            int node = queue.pollLast();
            colIndices[node] = i;
        }

        int[][] res = new int[k][k];
        for(int i = 0; i <= k; i++)
            res[rowIndices[i]][colIndices[i]] = i;
        

        return res;
    
    }

    public boolean topologicalSort(List<Integer>[] graph, int node, int[] visited, Deque<Integer> queue){
        // visited[node] == 2 -> node was visited previously, loop found
        // visited[node] == 1 -> node was visited and completed
        // visited[node] == 0 -> node not visited
        if(visited[node] == 2)
            return false;

        if(visited[node] == 0){
            // define node as visited
            visited[node] = 2;
            for(int child: graph[node]){
                if(!topologicalSort(graph, child, visited, queue))
                    return false;
            }
            // define not as visited and done
            visited[node] = 1;
            // add node to queue
            queue.offer(node);
        }

        // valid topological sort found
        return true;
    }


}