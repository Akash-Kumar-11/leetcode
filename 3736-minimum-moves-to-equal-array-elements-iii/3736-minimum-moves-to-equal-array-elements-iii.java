class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max , nums[i]);
        }
        int j = 0;
        while(j < nums.length ) {
           while(nums[j] < max){
                nums[j]++;
                count++;
           }
           j++;
        }
        return count;
    }
}