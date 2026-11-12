class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        
        // Track longest strictly increasing subarray
        for (int i = 1, incLen = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                ans = Math.max(ans, ++incLen);
            } else {
                incLen = 1;
            }
        }
        
        // Track longest strictly decreasing subarray
        for (int i = 1, decLen = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                ans = Math.max(ans, ++decLen);
            } else {
                decLen = 1;
            }
        }
        
        return ans;
    }
}