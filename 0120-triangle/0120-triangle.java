import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        // Use a DP array (or modify a copy of the last row)
        int[] dp = new int[n];
        
        // Initialize dp with the values of the bottom row
        List<Integer> lastRow = triangle.get(n - 1);
        for (int j = 0; j < n; j++) {
            dp[j] = lastRow.get(j);
        }
        
        // Work our way up from the second-to-last row to the top
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = currentRow.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        // The top element now holds the minimum path sum
        return dp[0];
    }
}
