class Solution:
    def kthFactor(self, n: int, k: int) -> int:
        if k > n:
            return -1

        lst = []
        for i in range(1, n + 1):
            if n % i == 0:
                lst.append(i)

            if len(lst) == k:
                return lst[-1]

        return -1