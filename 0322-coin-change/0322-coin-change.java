class Solution {
    public int coinChange(int[] coins, int amount) {
        int output = rec(coins, amount, new int[amount + 1]);
        if(output == Integer.MAX_VALUE){
            return -1;
        }
        return output;
    }

    public int rec(int[] coins, int amount, int[] dp){
        if(amount == 0)
            return 0;

        if(dp[amount] != 0)
            return dp[amount];

        int minVal = Integer.MAX_VALUE;
        for(int coin: coins){
            if((amount - coin) >= 0){
                int subproblem = rec(coins, amount - coin, dp);
                if(subproblem != -1)
                    minVal = Math.min(minVal, 1 + subproblem);    
            }
        }
        dp[amount] = (minVal == Integer.MAX_VALUE) ? -1 : minVal;
        return dp[amount];
    }
}