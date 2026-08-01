class Solution {
    int solve(int i, int j , int [] nums){
        if(i>j){
            return 0;
        }

        if(i == j){
            return nums[i];
        }

        int take_i = nums[i] + Math.min(solve(i+2,j,nums) , solve(i+1,j-1,nums));
        int take_j = nums[j] + Math.min(solve(i,j-2,nums) , solve(i+1,j-1,nums));
        return Math.max(take_i , take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        int total = 0;

        for(int i = 0; i<n ; i++){
            total += nums[i];
        }

        int p1 = solve(0,n-1,nums);
        int p2 = total - p1;

        return p1 >= p2;
        
    }
}