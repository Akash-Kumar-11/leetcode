class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = nums[n/2];
        int count = 0;
        for(int i = 0; i < n/2 ; i++){
            count += Math.abs(mid - nums[i]);
            count += Math.abs(mid - nums[n - i - 1]);
        }
        return count;
    }
}