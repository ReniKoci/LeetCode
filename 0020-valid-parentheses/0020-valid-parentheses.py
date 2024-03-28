class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        for i in range(len(s)):
            if (s[i] == '}' or s[i] == ']' or s[i] == ')') and not stack:
                return False

            if s[i] in '([{':
                stack.append(s[i])

            else:
                if (s[i] == '}' and stack[-1] != '{') or \
                    (s[i] == ']' and stack[-1] != '[') or \
                    (s[i] == ')' and stack[-1] != '('):
                    return False
            
                stack.pop()
        
        return not stack