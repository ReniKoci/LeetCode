class Solution(object):
    def sortArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """

        if len(nums) > 1:
            half_size = len(nums) // 2
            left_side = nums[half_size:]
            right_side = nums[:half_size]

            self.sortArray(left_side)
            self.sortArray(right_side)

            k, i, j = 0, 0, 0

            while i < len(left_side) and j < len(right_side):
                if(left_side[i] < right_side[j]):
                    nums[k] = left_side[i]
                    i += 1
                else:
                    nums[k] = right_side[j]
                    j += 1
                k += 1

            # add remaining elements
            while i < len(left_side):
                nums[k] = left_side[i]
                i += 1
                k += 1
            

            while j < len(right_side):
                nums[k] = right_side[j]
                j += 1
                k += 1


        return nums

        