class Solution:
    def countOfAtoms(self, formula: str) -> str:
        currentCoeff = 1
        dct = {}
        i = len(formula) - 1
        stack = [1]

        while i >= 0:
            c = formula[i]
            if c.isdigit():
                temp = ""
                while(i >= 0 and formula[i].isdigit()):
                    temp = formula[i] + temp
                    i -= 1
                currentCoeff = int(temp)
                i += 1
            elif c == ")":
                stack.append(currentCoeff * stack[-1])
                currentCoeff = 1
            elif c == "(":
                stack.pop()
            elif c.isalpha():
                if c.islower():
                    element = formula[i-1] + c
                    i -= 1
                else:
                    element = c

                if element in dct:
                    dct[element] += currentCoeff * stack[-1]
                else:
                    dct[element] = currentCoeff * stack[-1]
                currentCoeff = 1


            i -= 1

        res = ""
        for k in sorted(dct):
            if dct[k] != 1: 
                res += k + str(dct[k])
            else:
                res += k

        return res
