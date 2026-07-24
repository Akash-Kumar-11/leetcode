class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        Set<Integer> s = new HashSet<>();
        for(int i = 0;i<n;i++){
            for(int j= i;j<n;j++){
                s.add(nums[i]^nums[j]);
            }
        }

        Set<Integer> s2 = new HashSet<>();
        for(int pair : s){
            for(int i : nums){
                s2.add(pair ^ i );
            }
        }

        return s2.size();
    }
}