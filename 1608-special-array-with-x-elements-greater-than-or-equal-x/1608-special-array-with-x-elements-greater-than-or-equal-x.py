class Solution:
    def specialArray(self, nums: List[int]) -> int:
        for i in range(len(nums) + 1):
            cnt = 0
            for num in nums:
                if i <= num:
                    cnt += 1

            if cnt == i:
                return cnt

        return -1