class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        # list of ascii values of lower case characters
        dp = [0] * 26
        for c in s:
            longest_sub = 1
            # get value of character
            curr = ord(c) - ord('a')
            for i in range(26):
                if abs(curr - i) <= k:
                    longest_sub = max(longest_sub, 1 + dp[i])

            dp[curr] = max(dp[curr], longest_sub)

        print(dp)
        return max(dp) 
