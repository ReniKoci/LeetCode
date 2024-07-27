class Solution {
    private static final int INF = Integer.MAX_VALUE / 2;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        if(source.length() != target.length())
            return -1;

        long finalCost = 0;
        int[][] directions = floyd(original, changed, cost);


        // for(int i = 0; i < directions.length; i++){
        //     for(int j = 0; j < directions.length; j++){
        //         System.out.print(directions[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        for(int i = 0; i < source.length(); i++){
            int s_index = source.charAt(i) - 'a';
            int t_index = target.charAt(i) - 'a';
            if(s_index != t_index){
                long tempCost = directions[s_index][t_index];
                if(tempCost >= INF){
                    return -1;
                }
                finalCost += tempCost;
            }

        }
        return finalCost;
    }

    public int[][] floyd(char[] original, char[] changed, int[] cost){
        int[][] direction = new int[26][26];

        for (int i = 0; i < 26; i++) {
            Arrays.fill(direction[i], INF);
            direction[i][i] = 0;
        }

        for(int i = 0; i < original.length; i++){
            direction[original[i] - 'a'][changed[i] - 'a'] = Math.min(direction[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

        // starting floyd warshal algo
        for(int k = 0; k < direction.length; k++){
            for(int i = 0; i < direction.length; i++){
                if(direction[i][k] < INF){
                    for(int j = 0; j < direction.length; j++){
                        if(direction[k][j] < INF){
                            direction[i][j] = Math.min(direction[i][j], direction[i][k] + direction[k][j]);
                        }
                    }
                }
            }
        }

        return direction;

    }
}