class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        max_so_far = max_here = -inf
        for num in nums:
            max_here = max(num, max_here + num)
            max_so_far = max(max_so_far, max_here)
        return max_so_far