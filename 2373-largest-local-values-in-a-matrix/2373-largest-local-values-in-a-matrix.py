class Solution(object):
    def largestLocal(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: List[List[int]]
        """
        output = []
        for i in range(0, len(grid) - 2) :
            row = []
            for j in range(0, len(grid) - 2):
                max_val = grid[i][j]
                for k in range(i, i + 3):
                    for l in range(j, j + 3):
                        max_val = max(max_val, grid[k][l])
                row.append(max_val)
            output.append(row)
        print(output)

        return output