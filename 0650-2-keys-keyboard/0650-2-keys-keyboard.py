class Solution:
    def minSteps(self, n: int) -> int:
        dp = [0 for _ in range(n + 1)]
        for i in range(n+1):
            for j in range(i - 1, 0, -1):
                if i % j == 0:
                    dp[i] = int(dp[j] + (i / j))
                    break

        return dp[n]