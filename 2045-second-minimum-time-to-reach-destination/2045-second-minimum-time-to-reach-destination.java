class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 1; i <= n; i++)
            map.put(i, new ArrayList<>());

        for(int[] edge: edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        // init queue for nodes
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        // init a map to store times for each node
        // each node should have only 2 elapsed times, visiting only twice
        Map<Integer, ArrayList<Integer>> elapsedTime = new HashMap<>();
        for(int i = 1; i <= n; i++)
            elapsedTime.put(i, new ArrayList<>());

        int res = -1;
        int currentTime = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            // nodes on same height
            for(int i = 0; i < size; i++){
                int node = queue.poll();

                if(node == n){
                    if(res != -1) // 2nd visit
                        return currentTime;

                    res = currentTime; // first visit
                }


                for(int neighbor: map.get(node)){
                    ArrayList<Integer> visitedTimes = elapsedTime.get(neighbor);
                    if(visitedTimes.size() == 0 || (visitedTimes.size() == 1 && visitedTimes.get(0) != currentTime)){
                        elapsedTime.get(neighbor).add(currentTime);
                        queue.offer(neighbor);
                    }
                }
            }
            // update time on other height
            if((int)Math.floor(currentTime / change) % 2 == 1)
                currentTime = (int)(Math.floor(currentTime / change) + 1) * change;

            currentTime += time;
            System.out.println(currentTime);
        }

        return -1;


    }
}