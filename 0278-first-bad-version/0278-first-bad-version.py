# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        left = 1
        right = n
        while (left < right):
            if isBadVersion(left):
                return left
            mid = left + (right - left) // 2
            if not isBadVersion(left) and not isBadVersion(mid):
                left = mid
            elif isBadVersion(mid):
                right = mid
            
            if right - left == 1:
                break

        return right