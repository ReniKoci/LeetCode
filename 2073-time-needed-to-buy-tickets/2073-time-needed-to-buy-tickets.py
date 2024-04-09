class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        ourBoy = tickets[k]
        res = 0
        for i, ticket in enumerate(tickets):
            if i <=k:
                whichIsBiggerBoy = min(ourBoy, ticket)
            else:
                whichIsBiggerBoy = min(ourBoy - 1, ticket)
            res += whichIsBiggerBoy
        
        return res
        