class Solution:
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        left_index = 0
        for element in arr2:
            for i in range(len(arr1)):
                if arr1[i] != element:
                    continue
                else:
                    arr1[left_index], arr1[i] = arr1[i], arr1[left_index]
                    left_index += 1

        arr1[left_index:] = sorted(arr1[left_index:])
        return arr1

