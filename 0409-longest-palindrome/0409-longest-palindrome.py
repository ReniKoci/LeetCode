class Solution:
    def longestPalindrome(self, s: str) -> int:
        dct = {}
        nr_odds = 0
        for c in s:
            if c in dct:
                dct[c] += 1
            else:
                dct[c] = 1

            if dct[c] % 2 == 1:
                nr_odds += 1
            else:
                nr_odds -= 1

        if nr_odds > 0:
            return len(s) - nr_odds + 1
        return len(s)