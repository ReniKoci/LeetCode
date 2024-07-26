class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        distances = self.floyd(n, edges)


        lowest_conn_edge = 0
        lowest_connections = 100000
        for i in range(n):
            temp_lowest_connections = 0
            for j in range(n):
                if(distances[i][j] <= distanceThreshold):
                    temp_lowest_connections += 1

            if temp_lowest_connections <= lowest_connections:
                lowest_connections = temp_lowest_connections
                lowest_conn_edge = i

        return lowest_conn_edge

    def floyd(self, n: int, edges: List[List[int]]):
        distance = [[float('inf')] * n for _ in range(n)]

        # Set the distance from a node to itself to 0
        for i in range(n):
            distance[i][i] = 0

        for edge in edges:
            start, end, weight = edge
            distance[start][end] = weight
            distance[end][start] = weight

        # print(distance)
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if distance[i][j] > distance[i][k] + distance[k][j]:
                        distance[i][j] = distance[i][k] + distance[k][j]

        return distance