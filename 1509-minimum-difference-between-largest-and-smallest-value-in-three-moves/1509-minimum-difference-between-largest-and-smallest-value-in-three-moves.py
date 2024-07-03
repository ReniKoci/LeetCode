class Solution:
    def minDifference(self, nums: List[int]) -> int:
        if len(nums) <= 4:
            return 0

        nums.sort()
        min_val = math.inf
        for i in range(4):
            min_val = min(min_val, nums[len(nums) - 4 + i] - nums[i])
        
        return min_val