class Solution {
    public int[][] updateMatrix(int[][] mat) {
        return updateMatrixDP(mat);
    }


    public int[][] updateMatrixDP(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        // the maximum distance a coordinate can have is the diagonal distance
        int maxDistance = m + n;
        // go from top left to bottom right while getting the minimum value of (left and top) + 1
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // if coordinate is 0 dont do anything
                if(mat[i][j] == 0)
                    continue;
                // define initial distance for left and top
                int left = maxDistance, top = maxDistance;
                // check bounds, if outside of bounds use the max distance, if not use the value stored in the matrix
                if(i - 1 >= 0) // top
                    top = mat[i-1][j];
                if(j - 1 >= 0) // left
                    left = mat[i][j-1];
                // update value
                mat[i][j] = Math.min(top, left) + 1;      
            }
        }

        // do the same thing from bottom right to top left
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(mat[i][j] == 0)
                    continue;
                // define max distance for bottom and right
                int bottom = maxDistance, right = maxDistance;
                // check bounds
                if(i + 1 <= m-1) // bottom
                    bottom = mat[i+1][j];
                if(j + 1 <= n-1) // right
                    right = mat[i][j+1];

                // update value
                // this time keep also track of the value that we already have 
                mat[i][j] = Math.min(Math.min(bottom, right) + 1, mat[i][j]); 
            }
        }

        return mat;
    }


    public int[][] updateMatrixQueue(int[][] mat) {
        // the changes are going to be in place
        // prepare the matrix so that we keep 0's and eveyrthing else will be set to -1
        // all 0's will be saved into a queue (their coordiantes)
        // the queue is going to be used to process all -1 values
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] != 0)
                    mat[i][j] = -1;
                else
                    queue.offer(new int[]{i, j});
            }
        }

        // create an array to define directions that we can move
        int[] directions = new int[]{0, 1, 0, -1, 0}; // directions -> 01, 10, 0-1, -10
        // process all other values starting from the zeros
        while(!queue.isEmpty()){
            int[] coordinates = queue.poll();
            int x = coordinates[0], y = coordinates[1];
            for(int i = 0; i < 4; i++){
                int moveX = directions[i] + x, moveY = directions[i+1] + y;
                // check bounds or if value is already processed (!= -1)
                // if the coordinate is already processed, that will be the minimum distance from 0
                if(moveX < 0 || moveY < 0 || moveX >= m || moveY >= n || mat[moveX][moveY] != -1)
                    continue;

                // add 1 to this coordinate
                mat[moveX][moveY] = 1 + mat[x][y];
                // add coordinates to queue
                queue.offer(new int[]{moveX, moveY});
            }
        }

        return mat;


    }

   
}