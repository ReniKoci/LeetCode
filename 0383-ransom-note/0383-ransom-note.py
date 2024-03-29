class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        dct = {}
        for c in magazine:
            if c in dct:
                dct[c] += 1
            else:
                dct[c] = 1 

        for c in ransomNote:
            if c in dct and dct[c] > 0:
                dct[c] -= 1
            else:
                return False
        return True