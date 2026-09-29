class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        
        // Base case: There is 1 way to make an amount of 0 (use no coins)
        dp[0] = 1;
        
        // Process each coin one by one to count unique combinations
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        
        return dp[amount];
    }
}
