class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++)
            totalSum += nums[i];

        if(totalSum % 2 != 0)
            return false;

        // we need to find a subset of numbers that equal to half the total sum
        totalSum /= 2;

        boolean[] dp = new boolean[totalSum + 1];
        dp[0] = true; // once we hit 0 it means that the we can subset the array

        for(int num: nums){
            for(int i = totalSum; i > 0; i--){
                if(i >= num){ // invalid calculation becasue the value would be negative
                    dp[i] = dp[i] || dp[i - num];
                }
            }
        }

        return dp[totalSum];

        
        // HashMap<Integer, Boolean> memo = new HashMap<>();
        // return findHalfSum(nums, 0, totalSum/2, memo);
    }

    public boolean findHalfSum(int[] nums, int index, int target, HashMap<Integer, Boolean> memo){
        if(memo.containsKey(target))
            return memo.get(target);

        if(index >= nums.length || target < 0)
            return false;

        if(target == 0)
            return true;

        
        boolean result = findHalfSum(nums, index + 1, target - nums[index], memo)
                || findHalfSum(nums, index + 1, target, memo);
        
        // Memoize the result
        memo.put(target, result);
        return result;
    }
}