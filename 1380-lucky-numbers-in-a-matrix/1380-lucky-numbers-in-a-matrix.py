class Solution:
    def luckyNumbers (self, matrix: List[List[int]]) -> List[int]:
        mins = []
        maxs = []
        for i in range(len(matrix)):
            mins.append(min(matrix[i]))
        
        for j in range(len(matrix[0])):
            column_values = []
            for i in range(len(matrix)):
                column_values.append(matrix[i][j])
            maxs.append(max(column_values))


        res = []
        for i in range(len(mins)):
            for j in range(len(maxs)):
                if mins[i] == maxs[j]:
                    res.append(mins[i])

        return res