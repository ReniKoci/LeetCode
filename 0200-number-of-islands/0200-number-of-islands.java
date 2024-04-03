class Solution {
    int[] directions = {0, 1, 0, -1, 0};
    public int numIslands(char[][] grid) {
        int nrIslands = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    nrIslands++;
                    DFS(grid, i, j);
                }
            }
        }

        return nrIslands;
    }

    public void DFS(char[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] == '0' )
            return;

        grid[x][y] = '0';
        for(int i = 1; i < directions.length; i++){
            DFS(grid, x + directions[i-1], y + directions[i]);
        }
    }
}