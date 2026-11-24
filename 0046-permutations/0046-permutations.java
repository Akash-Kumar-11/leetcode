class Solution {
    static void solve(int[]nums, List<List<Integer>> ans, List<Integer> output){
        if(output.size() == nums.length){
            ans.add((new ArrayList<>(output)));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(output.contains(nums[i])){
                continue;
            }
            else{
                output.add(nums[i]);
            }
            solve(nums, ans, output);
            output.remove(output.size() - 1);
        }
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> output = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, ans ,output);
        return ans;


        

    }
}