class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        res = []

        def dfs(row, col) -> (int, int):
            if row >= len(land) or col >= len(land[0]) or land[row][col] == 0:
                return (0, 0)

            land[row][col] = 0

            h_temp_row1, h_temp_col1 = dfs(row + 1, col)
            h_temp_row2, h_temp_col2 = dfs(row, col + 1)

            h_row = max(h_temp_row1, h_temp_row2, row)
            h_col = max(h_temp_col1, h_temp_col2, col)

            return (h_row, h_col)

        for i in range(len(land)):
            for j in range(len(land[0])):
                if land[i][j] == 1:
                    x, y = dfs(i, j)
                    res.append([i, j, x, y])

        return res