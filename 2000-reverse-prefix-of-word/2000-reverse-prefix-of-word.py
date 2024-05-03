class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        prefix = ""
        i = 0
        while i < len(word) and word[i] != ch:
            prefix = word[i] + prefix
            i += 1

        # char not found
        if i == len(word):
            return word

        return word[i] + prefix + word[i + 1:]