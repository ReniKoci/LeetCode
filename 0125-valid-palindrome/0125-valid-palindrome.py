class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if s.strip() == "" or len(s.strip()) == 1:
            return True
        left = 0
        right = len(s) - 1
        while left <= right:
            while left < len(s) and not s[left].isalnum():
                left+=1
            
            while right >= 0 and not s[right].isalnum():
                right-=1

            if left >= right:
                break

            if s[left].lower() != s[right].lower():
                return False

            left += 1
            right -= 1

        return True
        