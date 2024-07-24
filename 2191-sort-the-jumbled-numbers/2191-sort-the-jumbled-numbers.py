class Solution:
    def get_transformed_number(self, mapping, num):
        new_num = 0
        i = 1
        while True:
            dec = num % 10
            num = num // 10

            new_num = new_num + (i * mapping[dec])
            i *= 10

            if num == 0:
                break

        return new_num

    def sortJumbled(self, mapping: List[int], nums: List[int]) -> List[int]:
        transformed_nums = []

        for num in nums:
            transformed_nums.append(self.get_transformed_number(mapping, num))

        return [i[0] for i in sorted(zip(nums, transformed_nums), key=lambda x: x[1])]
