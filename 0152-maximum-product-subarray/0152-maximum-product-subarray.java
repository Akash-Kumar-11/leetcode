class Solution {
    public int maxProduct(int[] nums) {
        // Handle empty array edge case
        if (nums == null || nums.length == 0) return 0;

        // Initialize overall max, and local tracking variables
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // If the current number is negative, swapping max and min 
            // ensures we correctly calculate the new potential maximum.
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // The choice is either to start a new subarray at 'curr' 
            // or to multiply 'curr' with the previous subarray products.
            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            // Update the global maximum result found so far
            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}
