class Solution {
     private static void solve(int[] nums, int index, List<List<Integer>> ans, List<Integer> output) {
        // Base case: if we have considered all elements
        if (index >= nums.length) {
            ans.add(new ArrayList<>(output)); // Create a deep copy of the current subset
            return;
        }

        // Choice 1: Include the current element
        int currValue = nums[index];
        output.add(currValue);
        solve(nums, index + 1, ans, output); // Recurse

        // Backtrack: Remove the current element to explore the "exclude" path
        output.remove(output.size() - 1);

        while(index + 1 < nums.length && nums[index] == nums[index+1]){
            index++;
        }

        // Choice 2: Exclude the current element
        solve(nums, index + 1, ans, output); // Recurse
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, ans, output);
        return ans;
    }
}