class Solution:
    def partitionString(self, s: str) -> int:
        a = set()
        cnt = 0
        for i in range(len(s)):
            if s[i] in a:
                cnt += 1
                a = set()    
            a.add(s[i])
        return cnt + 1