class Solution {
    static void solve(int[]nums, List<List<Integer>> ans, List<Integer> output,boolean[] used){
        if(output.size() == nums.length){
                ans.add((new ArrayList<>(output)));
                return;
            }
        for(int i = 0; i < nums.length; i++){
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
           used[i] = true;
            output.add(nums[i]);

            solve(nums, ans, output,used);
            used[i] = false;
            output.remove(output.size() - 1);
        }
        return;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> output = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        solve(nums, ans ,output,used);
        return ans;


        

    }
}