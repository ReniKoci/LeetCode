class Solution:
    def maxProfitAssignment(self, difficulty: List[int], profit: List[int], worker: List[int]) -> int:
        # sort with respect to profit in descending order
        sorted_jobs = sorted(zip(profit, difficulty), reverse=True)
        worker.sort()

        res = 0
        for job in sorted_jobs:
            curr_profit = job[0]
            curr_diff = job[1]

            for i, w in enumerate(worker):
                if w >= curr_diff:
                    res += curr_profit * (len(worker) - i)
                    worker = worker[:i]
                    break
        
        return res
            