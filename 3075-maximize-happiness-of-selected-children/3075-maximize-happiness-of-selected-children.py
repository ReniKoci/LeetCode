class Solution(object):
    def maximumHappinessSum(self, happiness, k):
        """
        :type happiness: List[int]
        :type k: int
        :rtype: int
        """
        happiness.sort(reverse = True)

        res = 0
        for i, happy in enumerate(happiness):
            if i == k:
                break
            res += max((happy - i), 0)

        return res
        