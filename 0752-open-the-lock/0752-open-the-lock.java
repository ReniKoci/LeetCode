class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deadendsSet = new HashSet<>(Arrays.asList(deadends));

        int minSteps = 0;
        boolean flag = false;
        // add initial node
        queue.offer("0000");

        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                String node = queue.poll();
                if(deadendsSet.contains(node))
                    continue;

                // check if target found
                if(node.equals(target))
                    return minSteps;

                // add new nodes to queue
                StringBuilder sb = new StringBuilder(node);
                for(int j = 0; j < 4; j++){
                    char currentNumber = sb.charAt(j);
                    // we create 2 substrings, 1 incrementing and 1 decrementing the number
                    String inc = sb.substring(0, j) + (currentNumber == '9' ? 0 : currentNumber - '0' + 1) + sb.substring(j + 1);
                    String dec = sb.substring(0, j) + (currentNumber == '0' ? 9 : currentNumber - '0' - 1) + sb.substring(j + 1);

                    // check if these numbers are visited or deadends
                    if(!visited.contains(inc) && !deadendsSet.contains(inc)){
                        queue.offer(inc);
                        visited.add(inc);
                    }
                    if(!visited.contains(dec) && !deadendsSet.contains(dec)){
                        queue.offer(dec);
                        visited.add(dec);
                    }
                }
            }
            minSteps++;
        }

        return -1;

    }
}