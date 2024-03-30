class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        majorElement = nums[0]
        cnt = 1

        for i in range(1, len(nums)):
            if nums[i] == majorElement:
                cnt += 1
            else:
                cnt -= 1
                
            if cnt <= 0:
                majorElement = nums[i]
                cnt = 1
        
        return majorElement